package com.cms.service;

import com.cms.pojo.CmsSetting;
import com.cms.service.BaseService;

/**
 * Created by Administrator on 14-4-9.
 */
public interface CmsSettingService extends BaseService<CmsSetting> {
    void updateVersion();
}
