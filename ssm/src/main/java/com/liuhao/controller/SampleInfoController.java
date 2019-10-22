package com.liuhao.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.liuhao.common.Result;
import com.liuhao.entity.AddressProvince;
import com.liuhao.entity.CropSpecies;
import com.liuhao.entity.SampleInfo;
import com.liuhao.entity.SampleToxinInfo;
import com.liuhao.service.ICitiesService;
import com.liuhao.service.ICropSpeciesService;
import com.liuhao.service.ICropcategoryService;
import com.liuhao.service.ISampleInfoService;
import com.liuhao.service.ISampleToxinInfoService;

@Controller
public class SampleInfoController {

	@Autowired
	private ISampleInfoService iSampleInfoService;
	@Autowired
	private ICropSpeciesService iCropSpeciesService;
	@Autowired
	private ICitiesService iCitiesService;
	@Autowired
	private ISampleToxinInfoService iSampleToxinInfoService;
	Map<String, Object> map = new HashMap<>();
	
	@RequestMapping("queryallinfo")
	@ResponseBody
	public Result queryinfo(ModelMap map,String pageNum,
			String sampleid,String wuranlv,String toxinType,
			String year,String month,String day,String cropSpecies,
			String province,String city,String town
			) {
		Map<String, Object> qopmap = new HashMap<String, Object>();
		Result result = null;
		qopmap.put("sampleid", sampleid);
		qopmap.put("toxinType", toxinType);
		qopmap.put("cropSpecies", cropSpecies);
		qopmap.put("province", province);
		qopmap.put("city", city);
		qopmap.put("town", town);
		if (wuranlv != null && !"".equals(wuranlv)) {
			qopmap.put("min",wuranlv.split("-")[0] );
			qopmap.put("max",wuranlv.split("-")[1] );
		}
		if (year!= null && !"0".equals(year)) {
			if (month!= null && !"0".equals(month)) {
				if (Integer.parseInt(month) < 10) {
					qopmap.put("date", year+"-0"+month);
					if (day!= null && !"0".equals(day)) {
						if (Integer.parseInt(day) < 10) {
							qopmap.put("date", year+"-0"+month+"-0"+day);
						}else {
							qopmap.put("date", year+"-0"+month+"-"+day);
						}
					}
				}else {
					qopmap.put("date", year+"-"+month);
				}
			}else {
				qopmap.put("date", year);
			}
		}
		int num = 1;
		if (pageNum != null && !"".equals(pageNum)) {
			num = Integer.parseInt(pageNum);
		}
		try {
			PageInfo<SampleInfo> pageInfo = iSampleInfoService.queryall(num, 5,qopmap);
			result = new Result("200",pageInfo,"success");
		} catch (Exception e) {
			result = new Result("500",null,"error");
			e.printStackTrace();
		}
		return result;
	}
	

	@RequestMapping("QueryMessageByConditions")
	public String  querybyconditions(ModelMap modelMaps,String[] breed,String[] dates,String[] province,String[]toxin,String pulltion,
			String type,String typeid,@RequestParam(value="pageNum",defaultValue="0")Integer pageNum) {
		
		if (type != null && !"".equals(type)) {
			pageNum = 1;
			breed = (String[]) map.get("breed");
			province = (String[]) map.get("province");
			toxin = (String[]) map.get("txid");
			String[] qop =(String[])map.get(type);
			String[] dp = new String[qop.length-1];
			int index = 0;
			if (qop.length == 1) {
				qop[0] = "0";
				map.put(type, qop);
			}else {
				for (int i = 0; i < qop.length; i++) {
					if (!qop[i].equals(typeid)) {
						dp[index] = qop[i];
						index++;
					}
				}
				map.put(type, dp);
			}
			
		}else if (pageNum != 0) {
			breed = (String[]) map.get("breed");
			dates = (String[]) map.get("dates");
			province = (String[]) map.get("province");
			toxin = (String[]) map.get("txid");
		}else {
			pageNum = 1;
			map.put("breed", breed);
			map.put("province", province);
			map.put("txid", toxin);
			map.put("dates", dates);
		}
		if (pulltion != null && ""!=pulltion) {
			
			map.put("rate", pulltion.split("-"));
			modelMaps.put("pollutions", pulltion);
		}
		if (breed != null && !"".equals(breed)) {
			
			List<CropSpecies> speciesToshow = iCropSpeciesService.QuerySpeciesToshow(map);
			modelMaps.put("cropspecies", speciesToshow);
		}
		
		if (province != null && !"".equals(province)) {
			
			List<AddressProvince> provinceToShow = iCitiesService.QueryProvinceToShow(map);
			modelMaps.put("province", provinceToShow);
		}
		if (toxin != null && !"".equals(toxin)) {
			
			List<SampleToxinInfo> toxinToShow = iSampleToxinInfoService.QueryToxinToShow(map);
			modelMaps.put("toxinmessgae", toxinToShow);
		}
		
		
		
		if (dates != null && !"".equals(dates)) {
			
			modelMaps.put("itstime", map.get("dates"));
		}
		
		
		PageInfo<SampleInfo> pageInfo = iSampleInfoService.QuerymessagebyConditions(pageNum, 5, map);
		
		
		
		
		modelMaps.put("result", pageInfo);
		return "cus";
		
	}
	@RequestMapping("QeuryProvinceInSinfoBySpecies")
	@ResponseBody
	public Result queryprovinceinsinfo(String cropSid) {
		Map<String, Object> qaq = new HashMap<>();
		qaq.put("cropSid", cropSid);
		Result result = null;
		try {
			List<SampleInfo> queryProvinceInSinfoByspecies = iSampleInfoService.QueryProvinceInSinfoByspecies(qaq);
			result = new Result("200",queryProvinceInSinfoByspecies,"success");
		} catch (Exception e) {
			result = new Result("500",null,"error");
			e.printStackTrace();
		}
		
		return result;
	}
	@RequestMapping("QeuryTimeInSinfoByProvinec")
	@ResponseBody
	public Result querytimebyprov(String pcode) {
		Map<String, Object> qMap = new HashMap<>();
		qMap.put("pcode", pcode);
		Result result = null;
		try {
			List<SampleInfo> timeInSinfoByProv = iSampleInfoService.QueryTimeInSinfoByProv(qMap);
			result = new Result("200",timeInSinfoByProv,"success");
		} catch (Exception e) {
			result = new Result("500",null,"error");
			e.printStackTrace();
		}
		return result;
		
	}
	@RequestMapping("QueryInSampleInfoByCcPT")
	@ResponseBody
	public Result queryinfoinsamplinfo(String cropCategoryId,String cropSpecies,String province,
			String datetime,String pollutions) {
		Map<String, Object> qMap = new HashMap<>();
		Map<String, Object> dmap = new HashMap<>();
		qMap.put("cropCategoryId", cropCategoryId);
		qMap.put("cropSpecies", cropSpecies);
		qMap.put("province", province);
		qMap.put("datetime", datetime);
		if (pollutions != null && !"".equals(pollutions)) {
			qMap.put("pollutions", pollutions.split("-"));
		}
		Result result = null;
		try {
			List<SampleInfo> queryInSampleInfoByCcPT = iSampleInfoService.QueryInSampleInfoByCcPT(qMap);
			List<SampleToxinInfo> allToxin = iSampleToxinInfoService.QueryAllToxin();
			dmap.put("sampleinfo", queryInSampleInfoByCcPT);
			dmap.put("toxininfo", allToxin);
			result = new Result("200",dmap,"success");
		} catch (Exception e) {
			result = new Result("500",null,"error");
			e.printStackTrace();
		}
		return result;
	}
	@RequestMapping("QueryTimeInMap")
	@ResponseBody
	public Result querytime(String breed) {
		Map<String, Object> tMap = new HashMap<>();
		tMap.put("breed", breed);
		Result result = null;
		try {
			List<SampleInfo> queryTimeInMap = iSampleInfoService.QueryTimeInMap(tMap);
			result = new Result("200", queryTimeInMap, "success");
		} catch (Exception e) {
			result = new Result("500", null, "fuckyou");
			e.printStackTrace();
		}
		return result;
	}
	@RequestMapping("QueryMessageShowOnMap")
	@ResponseBody
	public Result querymessageshouonmap(String cropCategoryId,String breed,String dates,String toxin) {
		Result result = null;
		Map<String, Object> qMap = new HashMap<>();
		map.put("cropCategoryId", cropCategoryId);
		map.put("cropSpecies", breed);
		map.put("datetime", dates);
		map.put("toxin", toxin);
		try {
			List<SampleInfo> sampleInfoByCcPT = iSampleInfoService.QueryMessageShowOnMap(qMap);
			result = new Result("200",sampleInfoByCcPT,"success");
		} catch (Exception e) {
			result = new Result("500",null,"error");
			e.printStackTrace();
		}
		return result;
	}
}
