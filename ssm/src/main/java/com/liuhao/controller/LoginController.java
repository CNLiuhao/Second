package com.liuhao.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	
	@RequestMapping("Login")
	public String login(HttpSession session,String loginname) {
		session.setAttribute("loginname", loginname);
		return "index";
	}
	
	@RequestMapping("Quit")
	public String exit(HttpSession session,String loginname) {
		session.removeAttribute(loginname);
		
		return "login";
	}
}
