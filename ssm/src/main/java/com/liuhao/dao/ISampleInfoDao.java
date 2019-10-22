package com.liuhao.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liuhao.entity.SampleInfo;

@Repository
public interface ISampleInfoDao {
	
	
	List<SampleInfo> findallsampleinfo(Map<String, Object> map);
	
	
	SampleInfo findallinfo(int id);
	
	
	
	List<SampleInfo> QueryAllId();
	
	SampleInfo QuerySomeAboutSpecies(Map<String, Object> map);
	
	List<SampleInfo> QueryTimefromSampleInfo(String cropCategoryId);
	
	//qop
	List<SampleInfo> SelectQueryCondoitionsId(Map<String, Object> map);
	
	SampleInfo QuerymessagebyConditions(Map<String, Object> map);
	
	List<SampleInfo> QueryProvinceInSinfoByspecies(Map<String, Object> map);
	
	List<SampleInfo> QueryTimeInSinfoByProv(Map<String, Object> map);
	
	List<SampleInfo> QueryInSampleInfoByCcPT(Map<String, Object> map);
	
	List<SampleInfo> QueryTimeInMap(Map<String, Object> map);
	
	List<SampleInfo> QueryMessageShowOnMap(Map<String, Object> map);
}
