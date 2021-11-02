/**
 * Project Name:hotel-admin
 * File Name:LoginServiceImpl.java
 * Package Name:com.java.service.impl
 * Date:上午10:16:31
 * Copyright (c) 2019, bluemobi All Rights Reserved.
 *
*/

package com.java.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.mapper.LoginMapper;
import com.java.pojo.OneMenu;
import com.java.pojo.TwoMenu;
import com.java.service.LoginService;
import com.java.utils.MD5Tool;

/**
 * Description: Date: 上午10:16:31 <br/>
 * 
 * @author 丁鹏
 * @version
 * @see
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
	private String pwd;

    /**
     * 简单描述该方法的实现功能（可选）.
     * 
     * @see com.java.service.impl.LoginService#login(java.lang.String,
     *      java.lang.String, org.springframework.ui.Model,
     *      javax.servlet.http.HttpSession)
     */
    @Override
    @Transactional(readOnly = false)
    public boolean login(String username, String pwd, HttpSession session) throws Exception {  
    	pwd = MD5Tool.md5(pwd);
        int flag = loginMapper.login(username, pwd);
        if (flag >= 1) {
            List<OneMenu> oneMenuList = loginMapper.getAuthorityByUsername(username);
            
            Set<String> set = new java.util.HashSet<String>();
            
            for(OneMenu  oneMenu:oneMenuList) {
            		for(TwoMenu twoMenu:oneMenu.getTwoMenuList()) {            			
            			set.add(twoMenu.getUrl());
            		}
            }
           
            session.setAttribute("oneMenuList", oneMenuList);
            session.setAttribute("myUrls", set);
            session.setAttribute("username", username);
            return true;
        }
        return false;
    }

    @Override
    public List<OneMenu> getSQAuthority() {
        return loginMapper.getSQAuthority();
    }

	@Override
	public Set<String> getAllAuthority() {
		return loginMapper.getAllAuthority();
	}
}
