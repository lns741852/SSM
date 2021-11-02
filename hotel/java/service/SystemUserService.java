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
import java.util.Map;

/**
 * Description: Date: 上午10:35:41 <br/>
 * 
 * @author 丁鹏
 * @version
 * @see
 */
public interface SystemUserService {

    boolean saveSystemUser(String username, String pwd, String oneIds, String twoIds) throws Exception;

    List<Map<String, Object>> findSystemUserByLimit(Integer pageNum, Integer pageSize);

    boolean updateSystemUserStatus(Long userId, String flag);

}
