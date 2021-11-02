/**
 * Project Name:hotel-admin
 * File Name:InRoomService.java
 * Package Name:com.java.service
 * Date:下午3:58:02
 * Copyright (c) 2019, bluemobi All Rights Reserved.
 *
*/

package com.java.service;

import java.util.List;
import java.util.Map;

import com.java.pojo.InRoomInfo;

/**
 * Description: Date: 下午3:58:02 <br/>
 * 
 * @author 丁鹏
 * @version
 * @see
 */
public interface InRoomService {

    List<Map<String, Object>> findInRoomInfo(Map<String, Object> paramMap, Integer pageNum, Integer pageSize);

    List<Map<String, Object>> findKXRoom();

    boolean saveInRoomInfo(InRoomInfo inRoomInfo);

    List<Map<String, Object>> findRoomsByStatus(String status);

    Map<String, Object> findOutRoomInfoByRoomId(Long roomId);

    boolean outRoom(Long roomId, Long iriId, Float qita) throws Exception;

    List<Map<String, Object>> findCost(Map<String, Object> paramMap, Integer pageNum, Integer pageSize);
}
