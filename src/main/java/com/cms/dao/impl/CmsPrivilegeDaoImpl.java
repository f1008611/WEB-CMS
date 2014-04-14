package com.cms.dao.impl;

import com.cms.dao.CmsPrivilegeDao;
import com.cms.pojo.CmsPrivilege;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 14-4-14.
 */
public class CmsPrivilegeDaoImpl extends BaseDaoImpl<CmsPrivilege> implements CmsPrivilegeDao {
    @Override
    public List<CmsPrivilege> findCmsPrivilegeByRoleId(Long roleId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("roleId",roleId);
        String hql ="from CmsPrivilege t ,CmsRolePrivilegeRel r where t.id=r.privilegeId and r.roleId=:roleId";
        return find(hql,params);
    }
}
