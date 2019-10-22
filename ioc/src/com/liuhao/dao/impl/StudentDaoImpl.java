package com.liuhao.dao.impl;

import com.liuhao.dao.IStudentDao;
import com.liuhao.entity.Student;

public class StudentDaoImpl implements IStudentDao {
	
	private Student student;

	
	public void setStudent(Student student) {
		this.student = student;
	}


	@Override
	public void name() {
		System.out.println("dao");
		student.name();
	}

}
