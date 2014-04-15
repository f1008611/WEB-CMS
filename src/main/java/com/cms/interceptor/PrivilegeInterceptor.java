package com.cms.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.InterceptorRef;

/**
 * Created by Administrator on 14-4-15.
 */
@InterceptorRef("defaultStack")
public class PrivilegeInterceptor  implements Interceptor {
    private Logger LOG  =Logger.getLogger(this.getClass());

    @Override
    public void init() {
        LOG.info("PrivilegeInterceptor init...........");
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        LOG.info("PrivilegeInterceptor intercept come in...........");

        LOG.info("PrivilegeInterceptor intercept come out...........");
        return null;
    }



    @Override
    public void destroy() {
        LOG.info("PrivilegeInterceptor destroy...........");
    }
}
