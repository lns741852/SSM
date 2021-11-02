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
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Description: Date: 上午9:35:13 <br/>
 * 
 * @author 丁鹏
 * @version
 * @see
 */
public interface SystemUserMapper {

    /**
     * Description: 添加系统用户 ，同时返回主键值<br/>
     *
     * @author 丁鹏
     * @param paramMap
     * @return
     */
    int insertSystemUser(Map<String, Object> paramMap);

    /**
     * 添加权限信息 Description: <br/>
     *
     * @author 丁鹏
     * @param userId
     * @param authorityId
     * @return
     */
    int insertAuthority(Long userId, Long authority);

    /**
     * 查询所有系统用户信息
     */
    @Select("SELECT * FROM SYSTEM_USER")
    List<Map<String, Object>> selectAllSystemUser();

    /**
     * 
     * Description: 修改状态<br/>
     *
     * @author 丁鹏
     * @param userId
     * @param flag
     * @return
     */
    @Update("UPDATE `system_user` SET use_status=#{1} WHERE id=#{0}")
    int updateSystemUserStatus(Long userId, String flag);

}
