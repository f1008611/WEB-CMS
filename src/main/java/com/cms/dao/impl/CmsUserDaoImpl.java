package com.cms.dao.impl;

import com.cms.dao.CmsUserDao;
import com.cms.pojo.CmsUser;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 14-3-20.
 */
@Repository("cmsUserDao")
public class CmsUserDaoImpl extends BaseDaoImpl<CmsUser> implements CmsUserDao {
    @Override
    public CmsUser findByUserName(String userName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", userName);
        return  this.get("from CmsUser t where t.userName = :userName", params);
    }

    @Override
    public CmsUser login(String userName, String password) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", userName);
        params.put("password", password);
        return  this.get("from CmsUser t where t.userName = :userName and t.password = :password", params);
    }
}
