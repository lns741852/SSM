/**
 * Project Name:hotel-admin
 * File Name:InRoomMapper.java
 * Package Name:com.java.mapper
 * Date:下午3:50:20
 * Copyright (c) 2019, bluemobi All Rights Reserved.
 *
*/

package com.java.mapper;
/**
 * Description: 
 * Date:     下午3:50:20 <br/>
 * @author   丁鹏
 * @version  
 * @see 	 
 */

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.java.pojo.InRoomInfo;

public interface InRoomMapper {

    List<Map<String, Object>> selectInRoomInfo(Map<String, Object> paramMap);

    /**
     * 
     * Description: 获取空闲房间<br/>
     *
     * @author 丁鹏
     * @return
     */
    @Select("SELECT * FROM rooms WHERE room_status='0'")
    List<Map<String, Object>> selectKXRoom();

    /**
     * 
     * Description: 添加入住信息<br/>
     *
     * @author 丁鹏
     * @param info
     * @return
     */
    @Insert("INSERT INTO in_room_info VALUES(NULL,#{customerName},#{gender},#{isVip},#{idcard},#{phone},#{money},#{createDate},#{roomId},1,0)\r\n"
            + "")
    int insertInRoomInfo(InRoomInfo info);

    /**
     * 
     * Description: 修改房间状<br/>
     *
     * @author 丁鹏
     * @param roomId
     * @param status：0空闲，1已入住,2打扫
     * @return
     */
    @Update("UPDATE `rooms` SET room_status=#{1} WHERE id=#{0}")
    int updateRoomStatus(Long roomId, String status);

    /**
     * 
     * Description: 根据房间状态获取房间信息<br/>
     *
     * @author 丁鹏
     * @param status
     * @return
     */
    @Select("SELECT * FROM rooms WHERE room_status=#{0}")
    List<Map<String, Object>> getRoomsByStatus(String status);

    /**
     * 
     * Description: 根据房间主键获取退房客人的信息<br/>
     *
     * @author 丁鹏
     * @param roomId
     * @return
     */
    Map<String, Object> selectOutRoomInfoByRoomId(Long roomId);

    /**
     * 
     * Description: 修改入住信息表中的状态:未退房--->已经退房<br/>
     *
     * @author 丁鹏
     * @param iriId
     * @return
     */
    @Update("UPDATE in_room_info SET out_room_status='1' WHERE id=#{0}")
    int updateIRIStatus(Long iriId);

    /**
     * 
     * Description: 修改订单结算状态<br/>
     *
     * @author 丁鹏
     * @param iriId
     * @return
     */
    @Update("UPDATE orders SET order_status='1' WHERE iri_id=#{0}")
    int updateOrderStatus(Long iriId);

    /**
     * Description: 查询消费记录，同时包括条件查询<br/>
     *
     * @author 丁鹏
     * @param paramMap
     * @return
     */
    List<Map<String, Object>> selectCost(Map<String, Object> paramMap);

}
