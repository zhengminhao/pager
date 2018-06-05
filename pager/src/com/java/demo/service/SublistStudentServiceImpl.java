package com.java.demo.service;

import com.java.demo.dao.StudentDao;
import com.java.demo.dao.SublistStudentDaoImpl;
import com.java.demo.model.Pager;
import com.java.demo.model.Student;

public class SublistStudentServiceImpl implements StudentService {

	private static final long serialVersionUID = 4817089465568809091L;
	private StudentDao studentDao;
	

	public SublistStudentServiceImpl() {
		studentDao = new SublistStudentDaoImpl();
	}


	public StudentDao getStudentDao() {
		return studentDao;
	}


	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}


	public Pager<Student> findStudent(Student seadrchModel, int pageNum,
			int pageSize) {
		Pager<Student> result =studentDao.findStudent(seadrchModel, pageNum, pageSize);
		return result;
	}

}
