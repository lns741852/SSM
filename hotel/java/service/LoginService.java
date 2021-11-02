/**
 * Project Name:hotel-admin
 * File Name:LoginService.java
 * Package Name:com.java.service.impl
 * Date:上午10:35:41
 * Copyright (c) 2019, bluemobi All Rights Reserved.
 *
*/

package com.java.service;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.java.pojo.OneMenu;

/**
 * Description: Date: 上午10:35:41 <br/>
 * 
 * @author 丁鹏
 * @version
 * @see
 */
public interface LoginService {

    boolean login(String username, String pwd, HttpSession session) throws Exception;

    List<OneMenu> getSQAuthority();

	Set<String> getAllAuthority();

}
