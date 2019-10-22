package com.liuhao.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.taglibs.standard.lang.jstl.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuhao.dao.ISampleInfoDao;
import com.liuhao.entity.SampleInfo;
import com.liuhao.service.ISampleInfoService;

@Service
public class SampleInfoServiceImpl implements ISampleInfoService {

	@Autowired
	private ISampleInfoDao isampleinfoDao;
	
	@Override
	public PageInfo<SampleInfo> queryall(int pageNum, int size,Map<String , Object> map) {
		PageHelper.startPage(pageNum, size);
		List<SampleInfo> list = isampleinfoDao.findallsampleinfo(map);
		PageInfo<SampleInfo> info = new PageInfo<>(list);
		ArrayList<SampleInfo> qop = new ArrayList<>();
		for (SampleInfo sampleInfo : list) {
			qop.add(isampleinfoDao.findallinfo(sampleInfo.getId()));
		}
		info.setList(qop);
		return info;
	}
	
	@Override
	public List<SampleInfo> queryall(String cropCategoryId) {
		
		List<SampleInfo> sampleinfoId = isampleinfoDao.QueryAllId();
		ArrayList<SampleInfo> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cropCategoryId", cropCategoryId);
		for (SampleInfo sampleInfo : sampleinfoId) {
			map.put("id", sampleInfo.getId());
			SampleInfo aboutSpecies = isampleinfoDao.QuerySomeAboutSpecies(map);
			if (aboutSpecies != null) {
				list.add(aboutSpecies);
			}
		}
		return list;
	}
	
	@Override
	public List<SampleInfo> QueryTimefromSampleInfo(String cropCategoryId) {
		return isampleinfoDao.QueryTimefromSampleInfo(cropCategoryId);
	}
	@Override
	public PageInfo<SampleInfo> QuerymessagebyConditions(int pageNum,int size,Map<String, Object> map) {
		PageHelper.startPage(pageNum,size);
		List<SampleInfo> selectQueryCondoitionsId = isampleinfoDao.SelectQueryCondoitionsId(map);
		PageInfo<SampleInfo> info = new PageInfo<>(selectQueryCondoitionsId);
		List<SampleInfo> list = new ArrayList<>();
		for (SampleInfo sampleInfo : selectQueryCondoitionsId) {
			map.put("sid", sampleInfo.getId());
			list.add(isampleinfoDao.QuerymessagebyConditions(map));
		}
		info.setList(list);
		return info;
	}
	@Override
	public List<SampleInfo> QueryProvinceInSinfoByspecies(Map<String, Object> map) {
		return isampleinfoDao.QueryProvinceInSinfoByspecies(map);
	}
	@Override
	public List<SampleInfo> QueryTimeInSinfoByProv(Map<String, Object> map) {
		return isampleinfoDao.QueryTimeInSinfoByProv(map);
	}
	@Override
	public List<SampleInfo> QueryInSampleInfoByCcPT(Map<String, Object> map) {
		return isampleinfoDao.QueryInSampleInfoByCcPT(map);
	}
	@Override
	public List<SampleInfo> QueryTimeInMap(Map<String, Object> map) {
		return isampleinfoDao.QueryTimeInMap(map);
	}
	@Override
	public List<SampleInfo> QueryMessageShowOnMap(Map<String, Object> map) {
		return isampleinfoDao.QueryMessageShowOnMap(map);
	}
}
