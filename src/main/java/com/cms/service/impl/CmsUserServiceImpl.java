package com.cms.service.impl;

import com.cms.dao.BaseDao;
import com.cms.dao.CmsOnlineDao;
import com.cms.dao.CmsRoleDao;
import com.cms.dao.CmsUserDao;
import com.cms.pojo.CmsOnline;
import com.cms.pojo.CmsRole;
import com.cms.pojo.CmsUser;
import com.cms.service.CmsUserService;
import com.cms.utils.IpUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 14-3-1.
 */
@Service("cmsUserService")
public class CmsUserServiceImpl extends BaseServiceImpl<CmsUser> implements CmsUserService {
    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private CmsUserDao cmsUserDao;
    @Autowired
    private CmsOnlineDao cmsOnlineDao;


    @Override
    public CmsUser findByUserName(String userName) {
        return cmsUserDao.findByUserName(userName);
    }

    @Override
    public CmsUser login(String userName, String password) {
        logger.info("come in CmsUserServiceImpl -------> login");
        CmsUser cmsUser=cmsUserDao.login(userName, password);
         if(cmsUser!=null){
             cmsUser.setUpdateTime(new Date());
             cmsUser.setLastLoginTime(new Date());
             cmsUserDao.update(cmsUser);
             //mark ip

             CmsOnline cmsOnline=new CmsOnline();
             cmsOnline.setLoginName(cmsUser.getUserName());
             cmsOnline.setIp(IpUtils.getIpAddr(ServletActionContext.getRequest()));
             cmsOnline.setLoginTime(new Date());
             cmsOnline.setStatus("login");
             cmsOnlineDao.save(cmsOnline);
         }
        logger.info("come out CmsUserServiceImpl -------> login");
        return cmsUser;
    }

/*
    @Override
    public List<CmsUser> findAllUser() {
        return cmsUserBaseDao.find("from CmsUser ");
    }*/

    @Override
    public void updateEntity() {

    }
}
