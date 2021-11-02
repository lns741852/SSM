/**
 * Project Name:hotel-admin
 * File Name:SystemUserController.java
 * Package Name:com.java.controller
 * Date:上午11:26:34
 * Copyright (c) 2019, bluemobi All Rights Reserved.
 *
*/

package com.java.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.pojo.OneMenu;
import com.java.service.LoginService;
import com.java.service.SystemUserService;

/**
 * Description:系统用户管理模块 Date: 上午11:26:34 <br/>
 * 
 * @author 丁鹏
 * @version
 * @see
 */
@Controller
public class SystemUserController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private SystemUserService systemUserService;

    /**
     * 
     * Description: 获取授权信息<br/>
     *
     * @author 丁鹏
     * @param model
     * @return
     */
    @RequestMapping("/toAddUser.do")
    public String toAddUser(Model model) {
        List<OneMenu> sqAuthorityList = loginService.getSQAuthority();
        model.addAttribute("sqAuthorityList", sqAuthorityList);
        return "user/addSystemUser.jsp";
    }

    /**
     * 
     * Description: 添加系统用户(同时授权)<br/>
     *
     * @author 丁鹏
     * @param username
     * @param pwd
     * @param oneIds
     * @param twoIds
     * @return
     * @throws Exception
     */
    @RequestMapping("/addSystemUser.do")
    public @ResponseBody boolean addSystemUser(String username, String pwd, String oneIds, String twoIds)
            throws Exception {
        Thread.sleep(3000);
        return systemUserService.saveSystemUser(username, pwd, oneIds, twoIds);
    }

    @RequestMapping("/getSystemUserByLimit.do")
    public String getSystemUserByLimit(Model model,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<Map<String, Object>> systemUserList = systemUserService.findSystemUserByLimit(pageNum, pageSize);
        model.addAttribute("systemUserList", systemUserList);
        return "user/showSystemUser.jsp";
    }

    /**
     * 
     * Description: 修改用户状态<br/>
     *
     * @author 丁鹏
     * @param flag
     * @return
     */
    @RequestMapping("/updateSystemUserStatus.do")
    public String updateSystemUserStatus(Long userId, String flag) {
        // 校验flag=0/1
        // 调用业务层
        boolean result = systemUserService.updateSystemUserStatus(userId, flag);
        return "redirect:/getSystemUserByLimit.do";
    }

}
