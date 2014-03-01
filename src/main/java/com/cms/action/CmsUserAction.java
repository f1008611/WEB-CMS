package com.cms.action;

import com.cms.pojo.CmsUser;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 14-3-1.
 */
@Namespace("/")
@Action(value = "cmsUserAction")
public class CmsUserAction {

    public String login(){
        String userName=null;
        String password=null;
        System.out.println("userName="+userName+"======password="+password);
        return null;
    }
}
