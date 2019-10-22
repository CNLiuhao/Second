package com.liuhao.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liuhao.entity.SampleToxinInfo;

@Repository
public interface ISampleToxinInfoDao {

	List<SampleToxinInfo> QueryAllToxin();
	
	List<SampleToxinInfo> QueryToxinfromsamplinfo(String cropCategoryId);
	
	List<SampleToxinInfo> QueryToxinToShow(Map<String, Object> map);
}
