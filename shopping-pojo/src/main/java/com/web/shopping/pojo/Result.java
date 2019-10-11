package com.web.shopping.pojo;

public class Result {
	
	
	private boolean success;
	private String message;
	
	
	/** 
	* @Title: Result 
	* @Description: Result构造函数 
	* @param b
	* @param string * @author dpk
	* @date 2019-09-09 11:40:09 
	*/ 
	public Result() {
	}

	public Result(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
