package com.person.springboot.utils;

import com.person.springboot.entities.Girl;
import com.person.springboot.entities.Result;

public class ResultUtils {
	
	public static Result<Girl> success(Girl data){
		Result<Girl> result = new Result<Girl>();
		result.setCode(0);
		result.setMsg("成功");
		result.setData(data);
		return result;
	}
	
	public static Result success() {
		return success(null);
	}
	
	public static Result error(Integer code, String msg) {
		Result<Girl> result = new Result<Girl>();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(null);
		return result;
	}

}
