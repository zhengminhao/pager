package com.java.demo.service;

import java.io.Serializable;

import com.java.demo.model.Pager;
import com.java.demo.model.Student;

public interface StudentService extends Serializable {

	/**
	 * 查询分页方法
	 * @param seadrchModel 封装查询参数
	 * @param pageNum 第几页
	 * @param pageSize 数据条数
	 * @return
	 */
	public Pager<Student> findStudent(Student seadrchModel,int pageNum,int pageSize);
}
