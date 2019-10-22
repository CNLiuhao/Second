package com.liuhao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuhao.common.Result;
import com.liuhao.entity.AddressProvince;
import com.liuhao.entity.SampleInfo;
import com.liuhao.entity.SampleToxinInfo;
import com.liuhao.service.ICitiesService;
import com.liuhao.service.ISampleInfoService;
import com.liuhao.service.ISampleToxinInfoService;

@Controller
public class SampleToxinInfoController {


	@Autowired
	private ISampleToxinInfoService  isampleToxinInfoService;
	@Autowired
	private ISampleInfoService isampleInfoService;
	@Autowired
	private ICitiesService icitiesService;
	
	
	@RequestMapping("QueryAllToxin")
	@ResponseBody
	public Result queryall(){
		Result result = null;
		try {
			List<SampleToxinInfo> allToxin = isampleToxinInfoService.QueryAllToxin();
			result = new Result("200",allToxin,"success");
		} catch (Exception e) {
			result = new Result("500",null,"error");
			e.printStackTrace();
		}
		return result;
	}
	@RequestMapping("QueryToxinFromSampleinfo")
	@ResponseBody
	public Result querytoxinfromsampleinfo(String cropCategoryId) {
		Result result = null;
		Map<String , Object> map = new HashMap<String, Object>();
		try {
			List<SampleToxinInfo> toxinfromsamplinfo = isampleToxinInfoService.QueryToxinfromsamplinfo(cropCategoryId);
			List<SampleInfo> timefromSampleInfo = isampleInfoService.QueryTimefromSampleInfo(cropCategoryId);
			List<AddressProvince> provincename = icitiesService.QueryProvincename(cropCategoryId);
			map.put("toxin", toxinfromsamplinfo);
			map.put("samtime",timefromSampleInfo);
			map.put("province", provincename);
			result = new Result("200", map, "success");
		} catch (Exception e) {
			result = new Result("500", null, "funckinbitch");
			e.printStackTrace();
		}
		return result;
	}
		
}
