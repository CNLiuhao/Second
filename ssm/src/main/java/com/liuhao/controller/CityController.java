package com.liuhao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuhao.entity.AddressCity;
import com.liuhao.entity.AddressProvince;
import com.liuhao.entity.AddressTown;
import com.liuhao.service.ICitiesService;

@Controller
public class CityController {

	@Autowired
	private ICitiesService iCitiesService;
	
	@RequestMapping("QueryAllProvince")
	@ResponseBody    //
	public List<AddressProvince> queryprovince() {
		List<AddressProvince> provinces = iCitiesService.SelectAll();
		return provinces;
		
		
	}
	@RequestMapping("QueryCities")
	@ResponseBody
	public List<AddressCity> querycity(String code) {
		
		List<AddressCity> city = iCitiesService.selectcity(code);
		
		return city;
	}
	@RequestMapping("QueryTown")
	@ResponseBody
	public List<AddressTown> querytown(String code) {
		List<AddressTown> town = iCitiesService.selecttown(code);
		
		return town;
	}
	
}
