package com.java.listener;

import java.security.Permission;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.java.service.LoginService;

public class StartSystemListener implements ServletContextListener {		

	//伺服器創建時啟動,創建application對象时需要執行的方法.
	@Override
	public void contextInitialized(ServletContextEvent sce) {

		//1.將項目路徑(request.getContextPath())放置到application域中.
		ServletContext application = sce.getServletContext();
		String contextPath = application.getContextPath();
		application.setAttribute("APP_PATH", contextPath);
		System.out.println("APP_PATH...");
		
		//2.儲存權限管理路徑	
		//從application域中加載ioc容器
		ApplicationContext ioc = WebApplicationContextUtils.getWebApplicationContext(application);
		LoginService loginService = ioc.getBean(LoginService.class);
		Set<String> allAuthority = loginService.getAllAuthority();
		
		System.out.println(allAuthority);
		
		/*
		 * //存取快速、但無法排序(攔截器每次都會用到) Set<String> allURIs = new HashSet<String>();
		 * 
		 * for (Permission permission : queryAllPermission) {
		 * allURIs.add("/"+permission.getUrl()); }
		 */
		//將集合放入application域
		application.setAttribute("allAuthority", allAuthority);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}