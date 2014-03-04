package com.cms.action;

import com.cms.pojo.CmsUser;
import com.cms.service.CmsUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * Created by Administrator on 14-3-1.
 */
@Namespace("/admin")
@Action(value = "cmsUserAction")
@Results({@Result(name="aa",location="/WEB-INF/admin/index.jsp")})
@Controller
public class CmsUserAction{


    private String userName;
    private String password;
    @Autowired
    private CmsUserService cmsUserService;

    public String login(){
        System.out.println("userName="+userName+"======password="+password);
        cmsUserService.login(userName,password);
        return "aa";
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
