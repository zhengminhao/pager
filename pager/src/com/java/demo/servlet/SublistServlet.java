package com.java.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.demo.model.Pager;
import com.java.demo.model.Student;
import com.java.demo.service.StudentService;
import com.java.demo.service.SublistStudentServiceImpl;
import com.java.demo.util.Constant;

/**
 * Servlet实现类
 */
public class SublistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 调用service
	private StudentService studentService = new SublistStudentServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 前台获取参数
		String stuName = request.getParameter("stuName");
		// 性别
		int gender = Constant.GENDER_MAIL;
		String genderStr = request.getParameter("gender");
		if (genderStr != null && !"".equals(genderStr)) {
			gender = Integer.valueOf(genderStr);
		}
		// pageNum :当前页
		int pageNum = Constant.DEFAULT_PAGENUM;
		String pageNumStr = request.getParameter("pageNum");
		if (pageNumStr != null && !"".equals(pageNumStr)) {
			pageNum = Integer.parseInt(pageNumStr);
		}
		// 每页数据量
		int pageSize = Constant.DEFAULT_PAGESIZE;
		String pageSizeStr = request.getParameter("pageNum");
		if (pageSizeStr != null && !"".equals(pageSizeStr)) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		// 查询参数
		Student seadrchModel = new Student();
		seadrchModel.setStuName(stuName);
		seadrchModel.setGender(gender);
		// 调动service方法
		Pager<Student> result = studentService.findStudent(seadrchModel,
				pageNum, pageSize);
		request.setAttribute("result", result);
		request.setAttribute("stuName", stuName);
		request.setAttribute("gender", gender);
		// 页面读取数据跳转到指定页
		request.getRequestDispatcher("sublistStudent.jsp").forward(request,
				response);

	}

}
