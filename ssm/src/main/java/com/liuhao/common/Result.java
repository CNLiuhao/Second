package com.liuhao.common;

public class Result {
	
	public String code;   //状态码
	public Object result;  //返回的数据
	public String message;  //成功 失败
	
	
	public Result() {
		
	}
	public Result(String code, Object result, String message) {
		this.code = code;
		this.result = result;
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Result [code=" + code + ", result=" + result + ", message=" + message + "]";
	}

	
	

}
