/**
  * Project Name:hotel-admin
 * File Name:HouseController.java
 * Package Name:com.java.controller
 * Date:下午2:07:59
 * Copyright (c) 2019, bluemobi All Rights Reserved.
 *
*/

package com.java.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.java.pojo.RoomType;
import com.java.service.HouseService;
import com.java.utils.AjaxResult;
import com.java.utils.Msg;


/**
 * Description: 客房管理 Date: 下午2:07:59 <br/>
 * 
 * @author 丁鹏
 * @version
 * @see
 */
@Controller
public class HouseController {

    @Autowired
    private HouseService houseService;

    @RequestMapping("/HouseManage.do")
    public String getHouseManage() {
        return "room/showRoomType.jsp";
    }
    
  
    
    @RequestMapping("/addRoomPage.do")
    public String addRoomPage() {
        return "room/addRoom.jsp";
    }
    
    
    @RequestMapping("/showRoom.do")
    public String showRoom() {
        return "room/showRoom.html";
    }
    

    /**
     * 
     * Description: ajax触发获取所有的房间类型<br/>
     *
     * @author 丁鹏
     * @return
     */
    @RequestMapping("/getAllRoomType.do")
    @ResponseBody
    public  Object getAllRoomType(@RequestParam(value = "pageno", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pagesize", required = false, defaultValue = "5") Integer pageSize) {
    	
    	 AjaxResult result = new AjaxResult();
    	 try {
    	 
    	 List<Map<String, Object>> inRoomList = houseService.getRoomType(pageNum, pageSize);
         PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(inRoomList);
    	        
         result.setSuccess(true);
		 result.setPageInfo(pageInfo);
			
		} catch (Exception e) {
			result.setSuccess(false);
			e.printStackTrace();
			result.setMessage("數據查詢失敗!");
		}
		 
		return result; 
    	
      
    }

    @RequestMapping("/getRoomInfo.do")
    public @ResponseBody List<Map<String, Object>> getRoomInfo() {
        return houseService.findRoomsInfo();
    }
    
	//後端效驗
	@ResponseBody
	@RequestMapping("/roomTypeCheck.do")
	public Msg checkRoomType(String roomTypeName,boolean shouldVerify){
	
		String regx = "^[\\u2E80-\\u9FFF]{2,5}$";
		if(!roomTypeName.matches(regx)){
			return Msg.fail().addMap("va_msg", "用戶名錯誤");
		}
		if(shouldVerify) {
			boolean b = houseService.checkRoomType(roomTypeName);
			if(!b){
				return Msg.fail().addMap("va_msg", "用戶名不可用");			
			}
			
		}
		return Msg.success();

		
	}
	
	//新增+JSR303效驗
	@RequestMapping(value="/saveRoomType.do")
	@ResponseBody
	public Msg saveRoomType(@Valid RoomType roomType, BindingResult result){
		//BindingResult是JSR303功能
		if(result.hasErrors()){
			HashMap<String,Object> map = new HashMap<>();
			List<FieldError> fieldErrors = result.getFieldErrors();
			
			for (FieldError error:fieldErrors) {
				map.put(error.getField(), error.getDefaultMessage());
			}
			return Msg.fail().addMap("errorFields", map);
		}else{			
			Integer id = roomType.getId();
			if(id!=null) {
				houseService.updateRoomType(roomType);
				
			}else {				
				houseService.saveRoomType(roomType);		
			}
			return Msg.success();
		}
	
	}
	
	//修改
	@ResponseBody
	@RequestMapping(value="/roomTypeCheckById.do")
	public Msg roomTypeCheckById(Integer id ,HttpServletRequest request){
		
		Map<String,Object> roomType = houseService.getRoomTypeById(id);		
		return Msg.success().addMap("roomType",roomType);	
	}

	
	@ResponseBody
	@RequestMapping(value="/roomTypeDeleteById.do")
	public Msg roomTypeDeleteById(Integer id){
		try {
			houseService.deleteRoomType(id);
			return Msg.success();	
		}catch(Exception e){
			return Msg.fail().addMap("va_msg", "資料刪除失敗");
		}

	}
	
	@ResponseBody
	@RequestMapping(value="/getRoomType.do")
	public Object getRoomType(){
		 AjaxResult result = new AjaxResult();
		
		try {
			List<Map<String, Object>> inRoomList = houseService.getRoomType();
		    result.setSuccess(true);
			 result.setData(inRoomList);
				
			} catch (Exception e) {
				result.setSuccess(false);
				e.printStackTrace();
				result.setMessage("數據查詢失敗!");
			}
			 
			return result; 
   	
	      
	    }
	
	@ResponseBody
	@RequestMapping(value="/saveRoom.do")
	public Object saveRoom(String roomNum, String roomTypeId, String roomState){
		 AjaxResult result = new AjaxResult();
		
		try {
			houseService.saveRoom(roomNum, roomTypeId, roomState);
		    result.setSuccess(true);			
			} catch (Exception e) {
				result.setSuccess(false);
				e.printStackTrace();
				result.setMessage("數據查詢失敗!");
			}
			 
			return result; 
   	
	      
	    }
		
	
	
	

	
}	
