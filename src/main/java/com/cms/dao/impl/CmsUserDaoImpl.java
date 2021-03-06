package com.cms.dao.impl;

import com.cms.dao.CmsUserDao;
import com.cms.pojo.CmsUser;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
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
    public CmsUser findCmsUserByUserNameAndPassword(String userName, String password) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", userName);
        params.put("password", password);
        return  this.get("from CmsUser t where t.userName = :userName and t.password = :password", params);
    }

    @Override
    public CmsUser findCmsUserByEmailAndPassword(String email, String password) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("email", email);
        params.put("password", password);
        return  this.get("from CmsUser t where t.email = :email and t.password = :password", params);
    }

    @Override
    public List<CmsUser> findAllCmsUser() {
        String hql="from CmsUser order by id desc";
        return this.find(hql);
    }
}
