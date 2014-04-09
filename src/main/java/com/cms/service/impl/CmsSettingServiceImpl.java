package com.cms.service.impl;

import com.cms.Constants.Constants;
import com.cms.dao.CmsSettingDao;
import com.cms.pojo.CmsSetting;
import com.cms.service.CmsSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 14-4-9.
 */
@Service("cmsSettingService")
public class CmsSettingServiceImpl extends BaseServiceImpl<CmsSetting> implements CmsSettingService {

    @Autowired
    private CmsSettingDao cmsSettingDao;
    @Override
    public void updateVersion() {
       CmsSetting cmsSetting=cmsSettingDao.findByCode(Constants.versionCode);
        if(cmsSetting==null){
            cmsSetting=new CmsSetting();
            cmsSetting.setCode(Constants.versionCode);
        }
        cmsSetting.setValue(String.valueOf(System.currentTimeMillis()));
        cmsSettingDao.update(cmsSetting);
    }
}
