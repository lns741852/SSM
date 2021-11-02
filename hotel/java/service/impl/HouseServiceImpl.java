/**
 * Project Name:hotel-admin
 * File Name:HouseServiceImpl.java
 * Package Name:com.java.service.impl
 * Date:下午2:10:06
 * Copyright (c) 2019, bluemobi All Rights Reserved.
 *
*/

package com.java.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.java.mapper.HouseMapper;
import com.java.pojo.RoomType;
import com.java.service.HouseService;

/**
 * Description: Date: 下午2:10:06 <br/>
 * 
 * @author 丁鹏
 * @version
 * @see
 */
@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;


    @Override
    public List<Map<String, Object>> findRoomsInfo() {
        return houseMapper.selectRoomsInfo();
    }

	@Override
	public List<Map<String, Object>> getRoomType(Integer pageNum, Integer pageSize) {				
		PageHelper.startPage(pageNum, pageSize);
		return houseMapper.selectRoomType();
	}

	@Override
	public List<Map<String, Object>> findRoomType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkRoomType(String roomType) {
	
		int flag = houseMapper.selectRoomTypeByName(roomType);
		
		if(flag>=1) {
			return false;
		}
		
		return true;
	}

	@Override
	public void saveRoomType(RoomType roomType) {
		houseMapper.saveRoomType(roomType);
		
	}

	@Override
	public Map<String,Object> getRoomTypeById(Integer id) {
	
		return houseMapper.selectRoomTypeById(id);
	}

	@Override
	public void updateRoomType(RoomType roomType) {
		
		houseMapper.updateRoomType(roomType);
		
	}

	@Override
	public void deleteRoomType(Integer id) {		
		houseMapper.deleteRoomType(id);
	}

	@Override
	public List<Map<String, Object>> getRoomType() {		
		return houseMapper.selectRoomType();
	}

	@Override
	public void saveRoom(String roomNum, String roomTypeId, String roomState) {
		 houseMapper.insertRoom(roomNum,roomState,roomTypeId);
		
	}

}
