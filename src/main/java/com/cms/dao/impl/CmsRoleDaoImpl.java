package com.cms.dao.impl;

import com.cms.dao.BaseDao;
import com.cms.dao.CmsRoleDao;
import com.cms.pojo.CmsRole;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 14-3-20.
 */
@Repository("cmsRoleDao")
public class CmsRoleDaoImpl extends BaseDaoImpl<CmsRole> implements CmsRoleDao {
    @Override
    public CmsRole findCmsRoleByName(String roleName) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("roleName", roleName);
        return  this.get("from CmsRole t where t.roleName = :roleName", params);
    }
}
