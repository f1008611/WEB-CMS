package com.cms.action;

import com.cms.pojo.CmsUser;
import com.cms.service.CmsUserService;
import com.cms.utils.IpUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * Created by Administrator on 14-3-1.
 */
@Namespace("/admin")
@Action(value = "cmsUserAction")
@Results({@Result(name = "success", location = "/WEB-INF/admin/index.jsp"),@Result(name = "index", location = "/index.jsp")})
@Controller
public class CmsUserAction {
    private Logger logger = Logger.getLogger(this.getClass());

    private String loginName;
    private String password;
    @Autowired
    private CmsUserService cmsUserService;

    public String login() {
        HttpServletRequest request = ServletActionContext.getRequest();
        logger.info("loginName=" + loginName + "======password=" + password);
        CmsUser cmsUser = cmsUserService.login(loginName, password);
        logger.info("ip=" + IpUtils.getIpAddr(ServletActionContext.getRequest()));
        if(cmsUser==null){
            request.setAttribute("loginErrorMessage","用户名或密码有误！");
            return "index";
        }
        return "success";
    }


    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
