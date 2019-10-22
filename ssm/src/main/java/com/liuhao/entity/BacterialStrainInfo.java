package com.liuhao.entity;

public class BacterialStrainInfo {

	private Integer id;
	private Integer sampleInfoId;
	private String sampleNum;
	private String originalNum;
	private String wordAddr;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSampleInfoId() {
		return sampleInfoId;
	}
	public void setSampleInfoId(Integer sampleInfoId) {
		this.sampleInfoId = sampleInfoId;
	}
	public String getSampleNum() {
		return sampleNum;
	}
	public void setSampleNum(String sampleNum) {
		this.sampleNum = sampleNum;
	}
	public String getOriginalNum() {
		return originalNum;
	}
	public void setOriginalNum(String originalNum) {
		this.originalNum = originalNum;
	}
	public String getWordAddr() {
		return wordAddr;
	}
	public void setWordAddr(String wordAddr) {
		this.wordAddr = wordAddr;
	}
	
}
