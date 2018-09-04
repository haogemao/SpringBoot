package com.person.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/list")
	public List<Map<String, Object>> getUserList(){
		String sql = "select * from user_info";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list;
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestParam("username") String username, @RequestParam("password") String password) {
		String sql = "insert into user_info(username, password) values(?, ?)";
		Object[] obj = {username, password};
		int result = jdbcTemplate.update(sql, obj);
		if(result > 0) {
			return "增加成功";
		}
		else {
			return "增加失败";
		}
	}
	
	@PutMapping("/updateUser/{id}")
	public String updateUser(@PathVariable("id") Integer id, @RequestParam("username") String username, @RequestParam("password") String password) {
		String sql = "update user_info set username = ?, password = ? where id = ?";
		Object[] args = {username, password, id};
		int result = jdbcTemplate.update(sql, args);
		if(result > 0) {
			return "修改成功";
		}
		else {
			return "修改失败";
		}
	}
	
	@DeleteMapping("/delUser/{id}")
	public String delUser(@PathVariable("id") Integer id) {
		String sql = "delete from user_info where id = ?";
		Object[] args = {id};
		int result = jdbcTemplate.update(sql, args);
		if(result > 0) {
			return "删除成功";
		}
		else {
			return "删除失败";
		}
	}
	
}
