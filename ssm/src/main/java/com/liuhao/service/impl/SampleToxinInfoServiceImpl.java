package com.liuhao.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuhao.dao.ISampleToxinInfoDao;
import com.liuhao.entity.SampleInfo;
import com.liuhao.entity.SampleToxinInfo;
import com.liuhao.service.ISampleToxinInfoService;


@Service
public class SampleToxinInfoServiceImpl implements ISampleToxinInfoService {

	
	@Autowired
	private ISampleToxinInfoDao isampleToxinInfoDao;
	
	@Override
	public List<SampleToxinInfo> QueryAllToxin() {
		return isampleToxinInfoDao.QueryAllToxin();
	}
	@Override
	public List<SampleToxinInfo> QueryToxinfromsamplinfo(String cropCategoryId) {
		return isampleToxinInfoDao.QueryToxinfromsamplinfo(cropCategoryId);
	}
	@Override
	public List<SampleToxinInfo> QueryToxinToShow(Map<String, Object> map) {
		return isampleToxinInfoDao.QueryToxinToShow(map);
	}
}
