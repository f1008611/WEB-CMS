package com.cms.action;

import com.cms.pojo.CmsUser;
import com.cms.service.CmsUserService;
import com.cms.utils.IpUtils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 14-4-14.
 */
@Namespace("/admin")
@Results({@Result(name = "success", location = "/WEB-INF/admin/index.jsp"),@Result(name = "index", location = "/index.jsp")})
@Controller
public class CmsLoginAction extends ActionSupport {
    private Logger LOG = Logger.getLogger(this.getClass());
    private String loginName;
    private String password;
    @Autowired
    private CmsUserService cmsUserService;

    @Action("login")
    public String login() {
        HttpServletRequest request = ServletActionContext.getRequest();
        LOG.info("loginName=" + loginName + "======password=" + password);
        CmsUser cmsUser = cmsUserService.login(loginName, password);
        LOG.info("ip=" + IpUtils.getIpAddr(ServletActionContext.getRequest()));
        if(cmsUser==null){
            request.setAttribute("loginErrorMessage","用户名或密码有误！");
            return "index";
        }
        return "success";
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }


}
