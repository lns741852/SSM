/**
 * Project Name:hotel-admin
 * File Name:LoginServiceImpl.java
 * Package Name:com.java.service.impl
 * Date:上午10:16:31
 * Copyright (c) 2019, bluemobi All Rights Reserved.
 *
*/

package com.java.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.mapper.SystemUserMapper;
import com.java.service.SystemUserService;
import com.java.utils.MD5Tool;

/**
 * Description: Date: 上午10:16:31 <br/>
 * 
 * @author 丁鹏
 * @version
 * @see
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {
    @Autowired
    private SystemUserMapper systemUserMapper;

    @Transactional(readOnly = false)
    @Override
    public boolean saveSystemUser(String username, String pwd, String oneIds, String twoIds) throws Exception {
        // 1、往system_user表中添加数据，获取生成的主键值
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        paramMap.put("pwd", MD5Tool.md5(pwd));
        int flag1 = systemUserMapper.insertSystemUser(paramMap);
        // 2、将userId与权限id都添加到user_authority表中中
        if (flag1 <= 0)
            return false;
        Long userId = Long.parseLong(paramMap.get("userId") + "");
        String idStr = oneIds + twoIds;// "1,1,1,4,4,10,12,14"
        String[] idAttr = idStr.replaceAll("(.,)\\1+", "$1").split("\\,");
        for (String authorityId : idAttr) {
            int flag2 = systemUserMapper.insertAuthority(userId, Long.parseLong(authorityId));
            if (flag2 <= 0)
                return false;
        }
        return true;
    }

    @Override
    public List<Map<String, Object>> findSystemUserByLimit(Integer pageNum, Integer pageSize) {
        return systemUserMapper.selectAllSystemUser();
    }

    @Override
    public boolean updateSystemUserStatus(Long userId, String flag) {
        return systemUserMapper.updateSystemUserStatus(userId, flag) >= 1;
    }
}
