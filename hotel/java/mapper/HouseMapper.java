/**
 * Project Name:hotel-admin
 * File Name:HouseMapper.java
 * Package Name:com.java.mapper
 * Date:下午2:08:18
 * Copyright (c) 2019, bluemobi All Rights Reserved.
 *
*/

package com.java.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.java.pojo.RoomType;

/**
 * Description: Date: 下午2:08:18 <br/>
 * 
 * @author 丁鹏
 * @version
 * @see
 */

public interface HouseMapper {


    List<Map<String, Object>> selectRoomType();

    /**
     * 
     * Description: 获取房间信息<br/>
     *
     * @author 丁鹏
     * @return
     */
    @Select("SELECT rm.id AS roomId,rm.room_num,rm.room_status,rt.room_price,rt.room_type_name \r\n"
            + "FROM rooms rm INNER JOIN room_type rt ON rm.room_type_id=rt.id")
    List<Map<String, Object>> selectRoomsInfo();  
    
    @Select("SELECT count(*) FROM room_type WHERE room_type_name=#{roomType}")
	int selectRoomTypeByName(String roomType);
    
    
    
    @Insert("INSERT INTO room_type(id,room_type_name,room_price) VALUES(NULL,#{roomTypeName},#{price})")
	void saveRoomType(RoomType roomType);

    
    
    @Select("SELECT * FROM room_type WHERE id=#{id}")
    Map<String,Object> selectRoomTypeById(Integer id);
    
    
    @Update("UPDATE room_type SET room_type_name=#{roomTypeName},room_price=#{price} WHERE id=#{id}")
	void updateRoomType(RoomType roomType);
    
    
    @Delete("DELETE room_type.* FROM room_type WHERE id=#{id}")
	void deleteRoomType(Integer id);
    
    
    @Insert("INSERT INTO rooms(id,room_num,room_status,room_type_id) VALUES(NULL,#{0},#{1},#{2})")
	void insertRoom(String roomNum, String roomState, String roomTypeId);

}
