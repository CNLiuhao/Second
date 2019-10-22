package com.liuhao.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuhao.dao.ICitiesDao;
import com.liuhao.entity.AddressCity;
import com.liuhao.entity.AddressProvince;
import com.liuhao.entity.AddressTown;
import com.liuhao.service.ICitiesService;

@Service
public class CitiesServiceImpl implements ICitiesService {
	
	@Autowired
	private ICitiesDao iCitiesDao;
	@Override
	public List<AddressProvince> SelectAll() {
		
		return iCitiesDao.SelectAll();
	}
	@Override
	public List<AddressCity> selectcity(String code) {
		
		return iCitiesDao.selectcity(code);
	}
	@Override
	public List<AddressTown> selecttown(String code) {
		return iCitiesDao.selecttown(code);
	}
	
	@Override
	public List<AddressProvince> QueryProvincename(String cropCategoryId) {
		return iCitiesDao.QueryProvincename(cropCategoryId);
	}
	@Override
	public List<AddressProvince> QueryProvinceToShow(Map<String, Object> map) {
		return iCitiesDao.QueryProvinceToShow(map);
	}
}
