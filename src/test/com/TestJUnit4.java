package com;


import com.cms.pojo.CmsUser;
import com.cms.service.CmsUserService;
import com.cms.utils.IpUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 14-3-19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring.xml","classpath*:hibernate/hibernate.cfg.xml","classpath*:struts/struts.xml"})
public class TestJUnit4 {

    @Autowired
    private CmsUserService cmsUserService;

    @Test
    public  void testUser(){
        CmsUser cmsUser= cmsUserService.findByUserName("a");
        if(cmsUser!=null){
            System.out.println("id="+cmsUser.getId()+",userName="+cmsUser.getUserName()+",createTime="+cmsUser.getCreateTime());
        }else {
            System.out.println("no user to find!");
        }
    }

}
