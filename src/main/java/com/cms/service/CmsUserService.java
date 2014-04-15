package com.cms.service;

import com.cms.pojo.CmsUser;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 14-3-1.
 */
public interface CmsUserService {


    CmsUser login(HttpSession session,String loginName,String password);
    CmsUser findByUserName(String userName);
    boolean isLogin(HttpSession session);
    CmsUser getCurrentCmsUser(HttpSession session);


   // List<CmsUser> findAllUser();

    void updateEntity();

}
