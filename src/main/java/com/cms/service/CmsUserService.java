package com.cms.service;

import com.cms.pojo.CmsUser;

/**
 * Created by Administrator on 14-3-1.
 */
public interface CmsUserService {


    CmsUser login(String userName,String password);
    CmsUser findByUserName(String userName);

}
