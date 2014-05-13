package com.cms.controller;

import com.cms.service.CmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 14-5-13.
 */
@Controller
@RequestMapping("/user")
public class CmsUserController {
    @Autowired
    private CmsUserService cmsUserService;
    @RequestMapping("/userList")
    public String userList(Model model){
        model.addAttribute("cmsUserList",cmsUserService.findAllCmsUser());
        return "/user/userList";
    }
}
