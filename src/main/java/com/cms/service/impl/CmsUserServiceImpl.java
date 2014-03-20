package com.cms.service.impl;

import com.cms.dao.BaseDao;
import com.cms.pojo.CmsUser;
import com.cms.service.CmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 14-3-1.
 */
@Service("cmsUserService")
public class CmsUserServiceImpl implements CmsUserService {
    @Autowired
    private BaseDao<CmsUser> cmsUserBaseDao;
    @Override
    public CmsUser findByUserName(String userName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", userName);
        return  cmsUserBaseDao.get("from CmsUser t where t.userName = :userName", params);
    }

    @Override
    public CmsUser login(String userName, String password) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", userName);
        params.put("password", password);
        return  cmsUserBaseDao.get("from CmsUser t where t.userName = :userName and t.password = :password", params);

    }
}
