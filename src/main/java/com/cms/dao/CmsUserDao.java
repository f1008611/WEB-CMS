package com.cms.dao;

import com.cms.pojo.CmsUser;

/**
 * Created by Administrator on 14-3-20.
 */
public interface CmsUserDao {
    CmsUser findByUserName(String userName);
}
