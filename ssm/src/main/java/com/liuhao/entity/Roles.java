package com.liuhao.entity;

public class Roles {

	private Integer rid;
	private String role;
	private String chrole;
	
	public Roles() {
		
	}
	public Roles(Integer rid, String role, String chrole) {
		this.rid = rid;
		this.role = role;
		this.chrole = chrole;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getChrole() {
		return chrole;
	}
	public void setChrole(String chrole) {
		this.chrole = chrole;
	}
	@Override
	public String toString() {
		return "Roles [rid=" + rid + ", role=" + role + ", chrole=" + chrole + "]";
	}
	
	
}
