package com.jay.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jay.crud.bean.Employee;
import com.jay.crud.bean.Msg;
import com.jay.crud.service.EmployeeService;





@Controller
public class employeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	//分頁查詢
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value="pn" ,defaultValue="1")Integer pn ){		

		PageHelper.startPage(pn,5);
		List<Employee> emps = employeeService.getAll();
		PageInfo page = new PageInfo(emps,5);		
		return Msg.success().add("pageInfo",page);		
	}
	
	
	//新增+JSR303效驗
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(@Valid Employee employee, BindingResult result){
		//BindingResult是JSR303功能
		if(result.hasErrors()){
			HashMap<String,Object> map = new HashMap<>();
			List<FieldError> fieldErrors = result.getFieldErrors();
			
			for (FieldError error:fieldErrors) {
				map.put(error.getField(), error.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else{				
			employeeService.saveEmp(employee);
			return Msg.success();			
		}

	}
	
	
	//後端效驗
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg checkuser(String empName){
		String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,16}$)";
		if(!empName.matches(regx)){
			return Msg.fail().add("va_msg", "用戶名錯誤");
		}
		
		boolean b = employeeService.checkUser(empName);
		if(b){
			return Msg.success();
		}else{
			return Msg.fail().add("va_msg", "用戶名不可用");
		}
		
	}
	
	//獲取員工-修改前
	@ResponseBody
	@RequestMapping(value="/emp/{id}")
	public Msg getEmp(@PathVariable("id")Integer id){		
		Employee emp = employeeService.getEmp(id);				
		return Msg.success().add("emp", emp);	
	}
	
	
	//修改
	@ResponseBody
	@RequestMapping(value="/emp/{empId}",method=RequestMethod.PUT)
	public Msg saveEmp(Employee employee,HttpServletRequest request){
		System.out.println(employee);
		employeeService.updateEmp(employee);	
		return Msg.success();	
	}
	
	
	
	/*單一員工刪除
	@ResponseBody
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public Msg deleteEmpById(@PathVariable("id")Integer id){
		employeeService.deleteEmp(id);
		return Msg.success();	
	}
	*/
	
	@ResponseBody
	@RequestMapping(value="/emp/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids){
		//兩個以上
		if(ids.contains("-")){
			List<Integer> del_ids = new ArrayList<>();
			String[] split = ids.split("-");
			
			for(String string : split){
				del_ids.add(Integer.parseInt(string));				
			}
			employeeService.deleteBatch(del_ids);
		//單個員工	
		}else{				
			Integer id = Integer.parseInt(ids);
			employeeService.deleteEmp(id);
		}
		return Msg.success();	
	}

	
	
	
	
	
	
/*	
	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="pn" ,defaultValue="1")Integer pn ,Model model){		
		//插件
		PageHelper.startPage(pn,5);
		List<Employee> emps = employeeService.getAll();
		//分頁
		PageInfo page = new PageInfo(emps,5);
		model.addAttribute("pageInfo",page);
		
		return "list";
	}
*/
}
