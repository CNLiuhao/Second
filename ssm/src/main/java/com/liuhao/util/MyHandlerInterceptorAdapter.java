package com.liuhao.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerInterceptorAdapter implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		HttpSession session=arg0.getSession();
		String name= (String) session.getAttribute("loginname");
		String url=arg0.getRequestURI();
		System.out.println(name);
		System.out.println(url);
		if(name==null || "".equals(name)){
			if( url.endsWith("login.jsp")||url.endsWith("Login")||url.endsWith(".jpg")||url.endsWith(".css")||url.endsWith(".js")||url.endsWith(".png")){
				System.out.println(name + "************" + url);
				return true;
			}else {
				
				PrintWriter out=arg1.getWriter();
				
				out.print("<script type='text/javascript'>top.location.href='/TestMessage/views/login.jsp'</script>");
				return false;
			}
			
		}else {
			return true;
		}
		
	}
	
	

}
