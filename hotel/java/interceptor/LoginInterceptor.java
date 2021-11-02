package com.java.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



public class LoginInterceptor extends HandlerInterceptorAdapter {

	//登入攔截器
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//1.定义哪些路径是不需要拦截(将这些路径称为白名单)
		Set<String> uri = new HashSet<String>();
		uri.add("/dologin.do");
		uri.add("/login.do");
		uri.add("/logout.do");
		
		//获取请求路径，如:/user/index.htm
		String servletPath = request.getServletPath();
		
		if(uri.contains(servletPath)){
			return true ;
		}
		
		
		//2.判断用户是否登录,如果登录就放行
		HttpSession session = request.getSession();		
		String username = (String)session.getAttribute("username");
		
		if(username!=null){
			return true ;
		}else{
			response.sendRedirect(request.getContextPath()+"/login.do");
			return false;
		}
		
	}
	
}