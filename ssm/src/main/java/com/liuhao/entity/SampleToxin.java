package com.liuhao.entity;

public class SampleToxin {
    private Integer stid;

    private Integer toxinId;

    private Float toxinCount;

    private Integer sampleInfoId;

    private SampleToxinInfo info;
    
    
    
    public SampleToxinInfo getInfo() {
		return info;
	}

	public void setInfo(SampleToxinInfo info) {
		this.info = info;
	}

	public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public Integer getToxinId() {
        return toxinId;
    }

    public void setToxinId(Integer toxinId) {
        this.toxinId = toxinId;
    }

    public Float getToxinCount() {
        return toxinCount;
    }

    public void setToxinCount(Float toxinCount) {
        this.toxinCount = toxinCount;
    }

    public Integer getSampleInfoId() {
        return sampleInfoId;
    }

    public void setSampleInfoId(Integer sampleInfoId) {
        this.sampleInfoId = sampleInfoId;
    }
}