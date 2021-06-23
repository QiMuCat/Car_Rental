package com.ll.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: 柒木Cat
 * @date: 2021/6/19 23:20
 *
 * 页面跳转控制器
 */

@Controller
@RequestMapping("sys")
public class SysController {
    /**
     * 跳转到管理页面
     * @return
     * */
    @RequestMapping("toMenuManager")
    public String toMenuManager(){
        return "system/menu/menuManager";
    }

    /**
     * 跳转到菜单管理的右边的菜单树页面
     * @return
     * */
    @RequestMapping("toMenuRight")
    public String toMenuRight(){
        return "system/menu/MenuRight";
    }

    /**
     * 跳转到菜单管理的左边的菜单树页面
     * @return
     * */
    @RequestMapping("toMenuLeft")
    public String toMenuLeft(){
        return "system/menu/MenuLeft";
    }

    /**
     * 跳转到角色管理页面
     * @return
     * */
    @RequestMapping("toRoleManager")
    public String toRoleManager(){
        return "system/role/roleManager";
    }

    /**
     * 跳转到用户管理页面
     * @return
     * */
    @RequestMapping("toUserManager")
    public String toUserManager(){
        return "system/user/userManager";
    }

    /**
     * 跳转到日志管理页面
     * @return
     * */
    @RequestMapping("toLogInfoManager")
    public String toLogInfoManager(){
        return "system/logInfo/logInfoManager";
    }

    /**
     * 跳转到公告管理界面
     * @return
     * */
    @RequestMapping("toNewsManager")
    public String toNewsManager(){
        return "system/news/newsManager";
    }

}
