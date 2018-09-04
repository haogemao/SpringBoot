package com.peron.springboot;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

public class Student extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		// 数据
		//List<Student> studentList = getStudentList();
		Map results = new HashMap();
		results.put("content", "你好，jsonp");

		JSONArray jsonArray = JSONArray.fromObject(results);
		String result = jsonArray.toString();

		// 前端传过来的回调函数名称
		String callback = req.getParameter("theFunction");
		// 用回调函数名称包裹返回数据，这样，返回数据就作为回调函数的参数传回去了
		result = callback + "(" + result + ")";

		resp.getWriter().write(result);

	}

}
