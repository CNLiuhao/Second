package com.liuhao.entity;

public class SampleToxinInfo {
    private Integer tid;

    private String toxinType;

    private Integer state;

 

	public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getToxinType() {
        return toxinType;
    }

    public void setToxinType(String toxinType) {
        this.toxinType = toxinType == null ? null : toxinType.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}