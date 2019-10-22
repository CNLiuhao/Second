package com.liuhao.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.liuhao.entity.SampleInfo;

public interface ISampleInfoService {

	
	PageInfo<SampleInfo> queryall(int pageNum,int size,Map<String, Object> map);
	
	
	
	
	
	List<SampleInfo> queryall(String cropCategoryId);
	
	
	
	List<SampleInfo> QueryTimefromSampleInfo(String cropCategoryId);
	
	PageInfo<SampleInfo> QuerymessagebyConditions(int pageNum,int size, Map<String, Object> map);
	
	
	List<SampleInfo> QueryProvinceInSinfoByspecies(Map<String, Object> map);
	
	List<SampleInfo> QueryTimeInSinfoByProv(Map<String, Object> map);
	
	
	List<SampleInfo> QueryInSampleInfoByCcPT(Map<String, Object> map);
	
	List<SampleInfo> QueryTimeInMap(Map<String, Object> map);
	
	List<SampleInfo> QueryMessageShowOnMap(Map<String, Object> map);
}
