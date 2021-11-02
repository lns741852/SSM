/**
 * Project Name:hotel-admin
 * File Name:LoginController.java
 * Package Name:com.java.controller
 * Date:上午8:35:59
 * Copyright (c) 2019, bluemobi All Rights Reserved.
 *
*/

package com.java.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.service.LoginService;
import com.java.utils.MD5Tool;


/**
 * Description: Date: 上午8:35:59 <br/>
 * 
 * @author 丁鹏
 * @version
 * @see
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    
    
    
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/login.do";
	}
    
	
	@RequestMapping("/index.do")
	public String logout() {		
		return "/login.jsp";
	}
    
    

    /**
     * 登陸 Description: <br/>
     *
     * @author 丁鹏
     * @param username
     * @param pwd
     * @param model
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/login.do")
    public String login(String username, String pwd, HttpSession session) throws Exception {   		
        boolean flag = loginService.login(username, pwd, session);      
        return flag ? "index.jsp" : "login.jsp";
    }
    
    
    

}
