package com.liuhao.web;

import com.liuhao.service.IStudentService;

public class controller {
	private IStudentService iStudentService;

	public void setiStudentService(IStudentService iStudentService) {
		this.iStudentService = iStudentService;
	}
	public void name() {
		System.out.println("web");
		iStudentService.name();
	}

}
