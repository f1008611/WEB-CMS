package com.cms.dao;

import com.cms.pojo.CmsRole;

import java.util.List;

/**
 * Created by Administrator on 14-3-20.
 */
public interface CmsRoleDao {
   CmsRole findCmsRoleByName(String roleName);
   List<CmsRole> findCmsRoleByCmsUserId(Long userId);
}
