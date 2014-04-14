package com.cms.dao;

import com.cms.pojo.CmsPrivilege;

import java.util.List;

/**
 * Created by Administrator on 14-4-14.
 */
public interface CmsPrivilegeDao extends BaseDao<CmsPrivilege>{
    List<CmsPrivilege> findCmsPrivilegeByRoleId(Long roleId);
}
