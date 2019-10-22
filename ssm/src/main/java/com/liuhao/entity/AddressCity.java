package com.liuhao.entity;

public class AddressCity {

	private Integer cid;
	private String code;
	private String cname;
	private String provinceCode;
	
	
	
	public AddressCity() {
	}
	public AddressCity(Integer cid, String code, String cname, String provinceCode) {
		this.cid = cid;
		this.code = code;
		this.cname = cname;
		this.provinceCode = provinceCode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	
}
