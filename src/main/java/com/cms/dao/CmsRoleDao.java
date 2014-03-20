package com.cms.dao;

import com.cms.pojo.CmsRole;

/**
 * Created by Administrator on 14-3-20.
 */
public interface CmsRoleDao {
   CmsRole findCmsRoleByName(String roleName);
}
