package com.java.interceptor;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		//從application域中取值
		Set<String> allURIs = (Set<String>)request.getSession().getServletContext().getAttribute("allAuthority");	//需先在監聽器存入session
				
		//當前請求路徑
		String servletPath = request.getServletPath();
		
		
		//許可路徑要有一個範圍
		if(allURIs.contains(servletPath)){
			//擁有的權限路徑			
			Set<String> myURIs = (Set<String>)request.getSession().getAttribute("myUrls");
			if(myURIs.contains(servletPath)){
				return true ;
			}else{
				response.sendRedirect(request.getContextPath()+"/index.do");
				return false ;
			}
			
		}else{ 
			return true ;
		}
		
		
	}
	
}