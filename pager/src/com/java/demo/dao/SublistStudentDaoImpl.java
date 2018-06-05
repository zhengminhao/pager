package com.java.demo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.java.demo.model.Pager;
import com.java.demo.model.Student;
import com.java.demo.util.Constant;
import com.java.demo.util.JdbcUtil;

public class SublistStudentDaoImpl implements StudentDao {

	private static final long serialVersionUID = 4362082760314130598L;

	public Pager<Student> findStudent(Student seadrchModel, int pageNum,
			int pageSize) {
		List<Student> allStudentData = getAllStudent(seadrchModel);
		Pager<Student> pager = new Pager<Student>(pageNum, pageSize,
				allStudentData);
		//
		return pager;
	}

	private List<Student> getAllStudent(Student seadrchModel) {
		// 结果数据
		List<Student> result = new ArrayList<Student>();
		List<Object> params = new ArrayList<Object>();
		String stuName = seadrchModel.getStuName();
		int gender = seadrchModel.getGender();
		//
		StringBuilder sql = new StringBuilder(
				"select * from t_student where 1=1");		
		if(stuName!=null && !"".equals(stuName)){
			sql.append(" stu_name like ?");
			params.add(" %" + stuName + "%");
		}
		if(gender==Constant.GENDER_MAIL ||gender==Constant.GENDER_FEMAIL){
			sql.append(" and gender= ? ");
			params.add(gender);
		}
		
		System.out.println("执行语句："+sql.toString());
		System.out.println("参数 ："+params);
		// 调用连接数据库实现数据获取
		JdbcUtil jdbcUtil = new JdbcUtil();
		jdbcUtil.getConnection();
		try {
			List<Map<String, Object>> maplist = jdbcUtil.findResult(
					sql.toString(), params);
			
			// 遍历数据
			for (Map<String, Object> map : maplist) {
				Student s = new Student(map);
				result.add(s);
			}
		} catch (SQLException e) {
			throw new RuntimeException("获取数据源失败！！", e);

		} finally {
			// 关闭连接，释放资源
			jdbcUtil.releaseConn();
		}
		System.out.println("打印数据结果：" + result);
		return result;
	}

}
