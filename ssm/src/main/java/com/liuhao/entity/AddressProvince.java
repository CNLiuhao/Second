package com.liuhao.entity;

public class AddressProvince {

	private Integer pid;
	private String code;
	private String pname;
	private String chinaname;
	
	public AddressProvince() {
		
	}
	
	
	public AddressProvince(Integer pid, String code, String pname, String chinaname) {
		this.pid = pid;
		this.code = code;
		this.pname = pname;
		this.chinaname = chinaname;
	}


	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getChinaname() {
		return chinaname;
	}
	public void setChinaname(String chinaname) {
		this.chinaname = chinaname;
	}
	
	
}
