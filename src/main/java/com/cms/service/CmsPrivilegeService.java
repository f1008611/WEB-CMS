package com.cms.service;

import com.cms.pojo.CmsPrivilege;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 14-3-19.
 */
public interface CmsPrivilegeService {
    boolean isPassReqUrl(HttpSession session,String reqUrl);
    List<CmsPrivilege> findCmsPrivilegeByParentId(Long parentId,String status);
    Set<String> getCurrentPrivileges(HttpSession session);
}
