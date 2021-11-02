/**
 * Project Name:hotel-admin
 * File Name:LoginMapper.java
 * Package Name:com.java.mapper
 * Date:上午9:35:13
 * Copyright (c) 2019, bluemobi All Rights Reserved.
 *
*/

package com.java.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Select;

import com.java.pojo.OneMenu;

/**
 * Description: Date: 上午9:35:13 <br/>
 * 
 * @author 丁鹏
 * @version
 * @see
 */
public interface LoginMapper {

    /**
     * 登录 Description: <br/>
     *
     * @author 丁鹏
     * @param username
     * @param password
     * @return
     */
    @Select("SELECT COUNT(*) FROM system_user where username=#{0} AND pwd=#{1} AND use_status=1")
    int login(String username, String password);

    /**
     * 
     * Description: 根据用户id获取具体的权限<br/>
     *
     * @author 丁鹏
     * @param id
     * @return
     */
    List<OneMenu> getAuthorityByUsername(String username);

    /**
     * 
     * Description: 获取授权信息<br/>
     *
     * @author 丁鹏
     * @param id
     * @return
     */
    List<OneMenu> getSQAuthority();
    
    
    
    @Select("SELECT authority_url FROM system_authority")
	Set<String> getAllAuthority();

}
