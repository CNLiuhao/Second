package com.liuhao.service;

import java.util.List;
import java.util.Map;

import com.liuhao.entity.SampleInfo;
import com.liuhao.entity.SampleToxinInfo;

public interface ISampleToxinInfoService {
	
	
	public List<SampleToxinInfo> QueryAllToxin();

	List<SampleToxinInfo> QueryToxinfromsamplinfo(String cropCategoryId);
	
	List<SampleToxinInfo> QueryToxinToShow(Map<String, Object> map);
}
