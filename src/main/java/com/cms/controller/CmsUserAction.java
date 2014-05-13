package com.cms.controller;

import com.cms.service.CmsUserService;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Administrator on 14-3-1.
 */
@ParentPackage("myStrutsDefault")
@Namespace("/admin/user")
@Results({@Result(name = "query", location = "/WEB-INF/user/userList.jsp"),@Result(name = "index", location = "/index.jsp")})
@Controller
public class CmsUserAction {
    private Logger LOG = Logger.getLogger(this.getClass());
    private CmsUserService cmsUserService;

    @Action("query")
    public String query(){
        LOG.info("come in CmsUserAction...... ");
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("cmsUserList",cmsUserService.findAllCmsUser());
        return "query";
    }

    public void setCmsUserService(CmsUserService cmsUserService) {
        this.cmsUserService = cmsUserService;
    }
}
