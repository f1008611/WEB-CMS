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

import java.util.Date;


/**
 * Created by Administrator on 14-3-1.
 */
@Namespace("/admin")
@Action(value = "cmsUserAction")
@Results({@Result(name="aa",location="/WEB-INF/admin/index.jsp")})
@Controller
public class CmsUserAction{
    private Logger logger=Logger.getLogger(this.getClass());

    private String userName="a";
    private String password="b";
    @Autowired
    private CmsUserService cmsUserService;

    public String login(){
        System.out.println("userName="+userName+"======password="+password);
       // cmsUserService.login(userName,password);
        CmsUser cmsUser=new CmsUser();
        cmsUser.setUserName(userName);
        cmsUser.setPassword(password);
        cmsUser.setCreateTime(new Date());
        cmsUserService.save(cmsUser);
        logger.info("ip="+IpUtils.getIpAddr(ServletActionContext.getRequest()));
        return "aa";
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
