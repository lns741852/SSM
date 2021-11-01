package com.jay.crud.test;

import java.util.Random;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jay.crud.bean.Department;
import com.jay.crud.bean.Employee;
import com.jay.crud.dao.DepartmentMapper;
import com.jay.crud.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	DepartmentMapper DepartmentMapper;
	
	@Test
	public void testCRUD(){
		//System.out.println(DepartmentMapper);		
	
		//DepartmentMapper.insertSelective(new Department(null,"開發部"));
		
	
	
		/*
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i = 0;i < 200;i++){			
			String uname = UUID.randomUUID().toString().substring(0,5);			
			mapper.insertSelective(new Employee(null,uname,"M",uname+"@gmail.com",1));
		}
		*/
			
	}

}
