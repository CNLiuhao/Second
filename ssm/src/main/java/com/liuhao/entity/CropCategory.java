package com.liuhao.entity;

public class CropCategory {

	private Integer id;
	private String cropcategory;
	private Integer state;
	
	public CropCategory() {
		
	}
	
	public CropCategory(String cropcategory, Integer state) {
		this.cropcategory = cropcategory;
		this.state = state;
	}

	public CropCategory(Integer id, String cropcategory, Integer state) {
		this.id = id;
		this.cropcategory = cropcategory;
		this.state = state;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCropcategory() {
		return cropcategory;
	}
	public void setCropcategory(String cropcategory) {
		this.cropcategory = cropcategory;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	
}
