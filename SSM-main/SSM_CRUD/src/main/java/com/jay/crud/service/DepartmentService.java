package com.jay.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.crud.bean.Department;
import com.jay.crud.dao.DepartmentMapper;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	public List<Department> getDepts(){
		 List<Department> list = departmentMapper.selectByExample(null);
		 return list;
		 
	}

}
