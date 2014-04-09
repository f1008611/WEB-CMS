package com.cms.aop;

import com.cms.service.CmsSettingService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 14-4-9.
 */
@Component
@Aspect
public class VersionAop {

    @Autowired
    private CmsSettingService cmsSettingService;


    @Pointcut("execution(* com.cms.service..*.*Entity(..))")
    public void EntityMethod() {

    }

    @Before("")
    public void before() {

    }

    @After("EntityMethod")
    public void after() {
        cmsSettingService.updateVersion();
    }

    @Around("")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object object = point.proceed();
        return object;
    }

}
