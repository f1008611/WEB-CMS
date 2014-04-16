package com.cms.action;

import com.cms.pojo.CmsUser;
import com.cms.service.CmsUserService;
import com.cms.utils.IpUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


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
