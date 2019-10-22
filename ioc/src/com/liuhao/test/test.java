package com.liuhao.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liuhao.web.controller;

public class test {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcContext.xml");
		controller c = (controller)context.getBean("web");
		c.name();
	}

}
