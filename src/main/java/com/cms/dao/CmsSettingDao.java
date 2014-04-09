package com.cms.dao;

import com.cms.pojo.CmsSetting;

/**
 * Created by Administrator on 14-4-9.
 */
public interface CmsSettingDao extends BaseDao<CmsSetting> {
    CmsSetting findByCode(String code);
}
