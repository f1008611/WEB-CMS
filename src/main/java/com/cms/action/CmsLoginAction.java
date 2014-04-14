package com.cms.action;

import com.cms.service.CmsUserService;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 14-4-14.
 */
@Namespace("/admin")
@Action(value = "cmsLoginAction")
@Results({@Result(name = "success", location = "/WEB-INF/admin/index.jsp"),@Result(name = "index", location = "/index.jsp")})
@Controller
public class CmsLoginAction {
    private Logger LOG = Logger.getLogger(this.getClass());
    private String loginName;
    private String password;
    @Autowired
    private CmsUserService cmsUserService;
}
