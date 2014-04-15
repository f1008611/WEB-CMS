package com.cms.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 14-4-15.
 */


public class PrivilegeInterceptor  extends AbstractInterceptor {
    private Logger LOG  =Logger.getLogger(this.getClass());

    @Override
    public void init() {
        LOG.info("PrivilegeInterceptor init...........");
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        LOG.info("PrivilegeInterceptor intercept come in...........");
        HttpServletRequest request = ServletActionContext.getRequest();
        String requestURL = request.getServletPath();
        System.out.println("requestURL="+requestURL+"===="+"/admin/login".startsWith(requestURL));
        if(requestURL.startsWith("/admin/login")){
            actionInvocation.invoke();
            LOG.info("放行");
        }

        LOG.info("PrivilegeInterceptor intercept come out...........");
        return null;
    }



    @Override
    public void destroy() {
        LOG.info("PrivilegeInterceptor destroy...........");
    }
}
