package com.liuhao.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liuhao.entity.AddressCity;
import com.liuhao.entity.AddressProvince;
import com.liuhao.entity.AddressTown;

@Repository
public interface ICitiesDao {
	
	List<AddressProvince> SelectAll();
	List<AddressCity> selectcity(String code);
	List<AddressTown> selecttown(String code);
	
	
	List<AddressProvince> QueryProvincename(String cropCategoryId);
	List<AddressProvince> QueryProvinceToShow(Map<String, Object> map);
}
