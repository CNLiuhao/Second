package com.liuhao.entity;

public class AddressTown {

	private Integer tid;
	private String code;
	private String tname;
	private String cityCode;
	
	public AddressTown() {

	}

	

	
	public AddressTown(Integer tid, String code, String tname, String cityCode) {
		this.tid = tid;
		this.code = code;
		this.tname = tname;
		this.cityCode = cityCode;
	}




	public Integer getTid() {
		return tid;
	}




	public void setTid(Integer tid) {
		this.tid = tid;
	}




	public String getTname() {
		return tname;
	}




	public void setTname(String tname) {
		this.tname = tname;
	}




	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	
}
