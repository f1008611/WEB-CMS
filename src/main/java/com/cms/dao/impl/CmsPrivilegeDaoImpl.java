package com.cms.dao.impl;

import com.cms.dao.CmsPrivilegeDao;
import com.cms.pojo.CmsPrivilege;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 14-4-14.
 */
@Repository("cmsPrivilegeDao")
public class CmsPrivilegeDaoImpl extends BaseDaoImpl<CmsPrivilege> implements CmsPrivilegeDao {
    @Override
    public List<CmsPrivilege> findCmsPrivilegeByRoleId(Long roleId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("roleId",roleId);
        String hql ="select t from CmsPrivilege t ,CmsRolePrivilegeRel r where t.id=r.privilegeId and r.roleId=:roleId";
        return find(hql,params);
    }

    @Override
    public List<CmsPrivilege> findCmsPrivilegeByParentId(Long parentId, String status) {
        Map<String, Object> params = new HashMap<String, Object>();
        String hql ="from CmsPrivilege t where 1=1 ";
        if(StringUtils.isNotEmpty(status)){
            params.put("status",status);
            hql+=" and t.status=:status";
        }
        if(parentId!=null){
            params.put("parentId",parentId);
            hql+=" and t.parentId=:parentId";
        }

        return find(hql,params);
    }
}
