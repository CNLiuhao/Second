package com.liuhao.service.impl;

import com.liuhao.dao.IStudentDao;
import com.liuhao.dao.impl.StudentDaoImpl;
import com.liuhao.service.IStudentService;

public class StudentServiceImpl implements IStudentService {

	private IStudentDao iStudentDao;
	
	
	
	public void setiStudentDao(IStudentDao iStudentDao) {
		this.iStudentDao = iStudentDao;
	}



	@Override
	public void name() {
		System.out.println("service");
		iStudentDao.name();
	}

}
