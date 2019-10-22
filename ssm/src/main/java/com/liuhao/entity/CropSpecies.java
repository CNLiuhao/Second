package com.liuhao.entity;

public class CropSpecies {
	
	private Integer cropSid;
	private String cropSpecies;
	private Integer	cropCategoryId;
	private Integer state;
	
	
	
	public CropSpecies() {

	}
	
	public CropSpecies(Integer cropSid, String cropSpecies, Integer cropCategoryId, Integer state) {
		this.cropSid = cropSid;
		this.cropSpecies = cropSpecies;
		this.cropCategoryId = cropCategoryId;
		this.state = state;
	}
	public Integer getCropSid() {
		return cropSid;
	}
	public void setCropSid(Integer cropSid) {
		this.cropSid = cropSid;
	}
	public String getCropSpecies() {
		return cropSpecies;
	}
	public void setCropSpecies(String cropSpecies) {
		this.cropSpecies = cropSpecies;
	}
	public Integer getCropCategoryId() {
		return cropCategoryId;
	}
	public void setCropCategoryId(Integer cropCategoryId) {
		this.cropCategoryId = cropCategoryId;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	
	

}
