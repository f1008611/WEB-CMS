package com.cms.service.impl;

import com.cms.dao.BaseDao;
import com.cms.dao.CmsRoleDao;
import com.cms.dao.CmsUserDao;
import com.cms.pojo.CmsRole;
import com.cms.pojo.CmsUser;
import com.cms.service.CmsUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 14-3-1.
 */
@Service("cmsUserService")
public class CmsUserServiceImpl extends BaseServiceImpl<CmsUser> implements CmsUserService {
    private Logger logger= Logger.getLogger(this.getClass());
    @Autowired
    private CmsUserDao cmsUserDao;
    @Autowired
    private CmsRoleDao cmsRoleDao;


    @Override
    public CmsUser findByUserName(String userName) {
        CmsRole cmsRole=cmsRoleDao.findCmsRoleByName("aa");
        if(cmsRole!=null){
            logger.info("  roleName="+cmsRole.getRoleName()+",Code="+cmsRole.getCode());
        }else {
            logger.info("   no role..");
        }
        return cmsUserDao.findByUserName(userName);
    }

    /*@Override
    public CmsUser login(String userName, String password) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", userName);
        params.put("password", password);
        return  cmsUserBaseDao.get("from CmsUser t where t.userName = :userName and t.password = :password", params);

    }


    @Override
    public List<CmsUser> findAllUser() {
        return cmsUserBaseDao.find("from CmsUser ");
    }*/
}
