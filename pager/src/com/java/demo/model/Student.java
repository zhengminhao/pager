package com.java.demo.model;

import java.io.Serializable;
import java.util.Map;

public class Student implements Serializable {

	private static final long serialVersionUID = -4064291727886865381L;

	private Integer id;
	private String stuName;//姓名
	private int age;//年龄
	private int gender;//性别
	private String address;//地址
	
	//map取数据
	public Student(Map<String, Object> map) {
		this.id = (Integer) map.get("id");
		this.stuName = (String) map.get("stu_name");
		this.age = (Integer) map.get("age");
		this.gender = (Integer) map.get("gender");
		this.address = (String) map.get("address");
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer id, String stuName, int age, int gender,
			String address) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", stuName=" + stuName + ", age=" + age
				+ ", gender=" + gender + ", address=" + address + "]";
	}

}
