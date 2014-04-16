package com.cms.dao;

import com.cms.pojo.CmsUser;

import java.util.List;

/**
 * Created by Administrator on 14-3-20.
 */
public interface CmsUserDao extends BaseDao<CmsUser> {
    CmsUser findByUserName(String userName);
    CmsUser findCmsUserByUserNameAndPassword(String userName, String password);
    CmsUser findCmsUserByEmailAndPassword(String email, String password);
    List<CmsUser> findAllCmsUser();
}
