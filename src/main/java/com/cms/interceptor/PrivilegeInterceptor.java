package com.cms.interceptor;

import com.cms.pojo.CmsUser;
import com.cms.service.CmsPrivilegeService;
import com.cms.service.CmsUserService;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 14-4-15.
 */

public class PrivilegeInterceptor  extends AbstractInterceptor {
    private Logger LOG  =Logger.getLogger(this.getClass());
    private CmsUserService cmsUserService;
    private CmsPrivilegeService cmsPrivilegeService;

    @Override
    public void init() {
        LOG.info("PrivilegeInterceptor init...........");
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        LOG.info("PrivilegeInterceptor intercept come in...........");
        HttpServletRequest request = ServletActionContext.getRequest();
        String requestURL = request.getServletPath();
        System.out.println("requestURL="+requestURL+"===="+requestURL.startsWith("/admin/login"));
        if(requestURL.startsWith("/admin/login")){
           LOG.info("login.."+cmsUserService.isLogin(request.getSession()));
            if(!cmsUserService.isLogin(request.getSession())){
                LOG.info("login.."+"index");
                return "index";
            }else{
                //check privileges
                CmsUser cmsUser= cmsUserService.getCurrentCmsUser(request.getSession());
                if(cmsUser!=null&&cmsPrivilegeService.isPassReqUrl(request.getSession(),requestURL)){
                    actionInvocation.invoke();
                    LOG.info("放行 login");
                }

            }
        }else {
            LOG.info(" ........");
            if(!cmsUserService.isLogin(request.getSession())){
                return "index";
            }else{
                //check privileges
                CmsUser cmsUser= cmsUserService.getCurrentCmsUser(request.getSession());
                LOG.info(cmsPrivilegeService.isPassReqUrl(request.getSession(),requestURL)+"99999");
                if(cmsUser!=null&&cmsPrivilegeService.isPassReqUrl(request.getSession(),requestURL)){
                    actionInvocation.invoke();
                    LOG.info(cmsPrivilegeService.isPassReqUrl(request.getSession(),requestURL)+"放行");
                }

            }
            request.setAttribute("loginErrorMessage","该用户没权限。。。。");
        }

        LOG.info("PrivilegeInterceptor intercept come out...........");
        return "index";
    }



    @Override
    public void destroy() {
        LOG.info("PrivilegeInterceptor destroy...........");
    }

    public void setCmsUserService(CmsUserService cmsUserService) {
        this.cmsUserService = cmsUserService;
    }

    public void setCmsPrivilegeService(CmsPrivilegeService cmsPrivilegeService) {
        this.cmsPrivilegeService = cmsPrivilegeService;
    }
}
