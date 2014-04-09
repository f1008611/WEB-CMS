package com.cms.dao.impl;

import com.cms.dao.CmsSettingDao;
import com.cms.pojo.CmsSetting;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 14-4-9.
 */
@Repository("cmsSettingDao")
public class CmsSettingDaoImpl extends BaseDaoImpl<CmsSetting> implements CmsSettingDao {

    @Override
    public CmsSetting findByCode(String code) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("code", code);
        return this.get("from CmsSetting t where t.code = :code", params);
    }
}
