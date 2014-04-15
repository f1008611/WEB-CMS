package com.cms.service.impl;

import com.cms.dao.*;
import com.cms.pojo.CmsOnline;
import com.cms.pojo.CmsPrivilege;
import com.cms.pojo.CmsRole;
import com.cms.pojo.CmsUser;
import com.cms.service.CmsUserService;
import com.cms.utils.IpUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Administrator on 14-3-1.
 */
@Service("cmsUserService")
public class CmsUserServiceImpl implements CmsUserService {
    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private CmsUserDao cmsUserDao;
    @Autowired
    private CmsOnlineDao cmsOnlineDao;
    @Autowired
    private CmsRoleDao cmsRoleDao;
    @Autowired
    private CmsPrivilegeDao cmsPrivilegeDao;

    @Override
    public CmsUser getCurrentCmsUser(HttpSession session) {
        CmsUser cmsUser=null;
        Object obj= session.getAttribute("current_user");
        if(obj!=null&&obj instanceof  CmsUser){
            cmsUser=(CmsUser)obj;
        }
        return cmsUser;
    }

    @Override
    public boolean isLogin(HttpSession session) {
       Object obj= session.getAttribute("current_user");
        if(obj!=null&& obj instanceof  CmsUser){
           logger.info("已经登录。。。。");
            return true;
        }
        return false;
    }

    @Override
    public CmsUser findByUserName(String userName) {
        return cmsUserDao.findByUserName(userName);
    }

    @Override
    public CmsUser login(HttpSession session,String loginName, String password) {
        logger.info("come in CmsUserServiceImpl -------> login");
        CmsUser cmsUser=checkCmsUser(loginName,password);
        if(cmsUser!=null){

             session.setAttribute("current_user",cmsUser);
            setPrivileges(session, cmsUser);
        }
        logger.info("come out CmsUserServiceImpl -------> login");
        return cmsUser;
    }

    private void setPrivileges(HttpSession session,CmsUser cmsUser){
        Set<String> privilegeSet = new HashSet<String>();
        List<CmsRole> cmsRoleList=cmsRoleDao.findCmsRoleByCmsUserId(cmsUser.getId());

            logger.info(">>>>>>>>>>>>>>>>>>>>> "+(cmsRoleList instanceof  CmsRole));
        for(int i=0;i<cmsRoleList.size();i++){
            System.out.println("object="+cmsRoleList.get(i) instanceof  Object);
            CmsRole cmsRole=  (CmsRole)cmsRoleList.get(i);
            System.out.println(">>>>>>>>>>>>>>>>>>>>  "+cmsRole.getCode());
        }

        for(CmsRole cmsRole:cmsRoleList){
            List<CmsPrivilege> cmsPrivileges=cmsPrivilegeDao.findCmsPrivilegeByRoleId(cmsRole.getId());
            for(CmsPrivilege cmsPrivilege:cmsPrivileges){
                logger.info("current_user_privileges -------> code="+cmsPrivilege.getCode());
                  privilegeSet.add(cmsPrivilege.getCode());
            }
        }

        session.setAttribute("current_user_privileges",privilegeSet);
    }


    private CmsUser checkCmsUser(String loginName, String password){
        CmsUser cmsUser=null;
        if(StringUtils.contains(loginName,"@")){
            logger.info("是否含有@:"+StringUtils.contains(loginName,"@"));
            cmsUser=cmsUserDao.findCmsUserByEmailAndPassword(loginName,password);
        }else{
            cmsUser=cmsUserDao.findCmsUserByUserNameAndPassword(loginName, password);
        }

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
        return  cmsUser;
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
