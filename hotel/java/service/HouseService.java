/**
 * Project Name:hotel-admin
 * File Name:HouseService.java
 * Package Name:com.java.service
 * Date:下午2:09:34
 * Copyright (c) 2019, bluemobi All Rights Reserved.
 *
*/

package com.java.service;

import java.util.List;
import java.util.Map;

import com.java.pojo.RoomType;

/**
 * Description: Date: 下午2:09:34 <br/>
 * 
 * @author 丁鹏
 * @version
 * @see
 */
public interface HouseService {
    List<Map<String, Object>> findRoomType();

    List<Map<String, Object>> findRoomsInfo();

	List<Map<String, Object>> getRoomType(Integer pageNum, Integer pageSize);

	boolean checkRoomType(String roomType);

	void saveRoomType(RoomType roomType);

	Map<String,Object> getRoomTypeById(Integer id);

	void updateRoomType(RoomType roomType);

	void deleteRoomType(Integer id);

	List<Map<String, Object>> getRoomType();

	void saveRoom(String roomNum, String roomTypeId, String roomState);
}
