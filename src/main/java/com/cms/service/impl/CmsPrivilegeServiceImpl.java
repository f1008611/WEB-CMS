package com.cms.service.impl;

import com.cms.dao.CmsPrivilegeDao;
import com.cms.pojo.CmsPrivilege;
import com.cms.service.CmsPrivilegeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;


/**
 * Created by Administrator on 14-3-19.
 */
@Service("cmsPrivilegeService")
public class CmsPrivilegeServiceImpl implements CmsPrivilegeService ,InitializingBean{
    private Map<String, String> linkMap = new HashMap<String, String>();
     private Logger LOG=Logger.getLogger(this.getClass());
    @Autowired
    private CmsPrivilegeDao cmsPrivilegeDao;


    @Override
    public void afterPropertiesSet() throws Exception {
        List<CmsPrivilege> cmsPrivilegeList=findCmsPrivilegeByParentId(null,"V");
        for(CmsPrivilege cmsPrivilege:cmsPrivilegeList){
            LOG.info("link="+cmsPrivilege.getLink()+"  code="+cmsPrivilege.getCode());
            linkMap.put(cmsPrivilege.getLink(),cmsPrivilege.getCode());
        }
    }

    @Override
    public boolean isPassReqUrl(HttpSession session, String reqUrl) {
        boolean result= false;
        Set<String> linkSet=linkMap.keySet();
        Set<String> cmsUserPrivileges= getCurrentPrivileges(session);
        for(String link:linkSet){
            if(!"".equals(link)&&reqUrl.startsWith(link)){
                   String code =linkMap.get(link);
                LOG.info("code ="+code+" ======"+!cmsUserPrivileges.contains(code));
                if(cmsUserPrivileges.contains(code)){
                    result=true;
                    break;
                }
            }
        }
        return result;
    }


    @Override
    public List<CmsPrivilege> findCmsPrivilegeByParentId(Long parentId, String status) {
        return cmsPrivilegeDao.findCmsPrivilegeByParentId(parentId,status);
    }

    @Override
    public Set<String> getCurrentPrivileges(HttpSession session) {
        Set<String> set=new HashSet<String>();
        Object obj=session.getAttribute("current_user_privileges");
        if(obj!=null&& (obj instanceof  Set)){
             set=(Set<String>)obj;
        }
        return set;
    }
}
