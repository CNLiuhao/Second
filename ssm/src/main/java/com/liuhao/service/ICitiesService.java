package com.liuhao.service;

import java.util.List;
import java.util.Map;

import com.liuhao.entity.AddressCity;
import com.liuhao.entity.AddressProvince;
import com.liuhao.entity.AddressTown;

public interface ICitiesService {

	public List<AddressProvince> SelectAll();
	public List<AddressCity> selectcity(String code);
	public List<AddressTown> selecttown(String code) ;
	
	
	List<AddressProvince> QueryProvincename(String cropCategoryId);
	List<AddressProvince> QueryProvinceToShow(Map<String, Object> map);
}
