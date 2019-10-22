package com.liuhao.controller;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuhao.common.Result;
import com.liuhao.entity.CropSpecies;
import com.liuhao.service.ICropSpeciesService;
import com.liuhao.service.ICropcategoryService;

@Controller
public class CropSpesciesController {

	@Autowired
	private ICropSpeciesService iCropSpeciesService;
	
	
	@RequestMapping("QueryAllCropSpecies")
	@ResponseBody
	public Result queryallcropspecies(){
		Result result = null;
		try {
			List<CropSpecies> AllCropSpecies = iCropSpeciesService.QueryAllCropSpecies();
			result = new Result("200",AllCropSpecies,"success");
		} catch (Exception e) {
			result = new Result("500",null,"error");
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("QueryCropSpecies")
	@ResponseBody
	public Result  queryall(String cropCategoryId) {
		Result result = null;
		try {
			List<CropSpecies> list = iCropSpeciesService.QueryAll(cropCategoryId);
			result = new Result("200",list,"success");
		} catch (Exception e) {
			result = new Result("500",null,"laji");
			e.printStackTrace();
		}
		
		return result;
	}
	
	@RequestMapping("DeleteById")
	public String  delete(ModelMap map,String cropCategoryId,String cropSid) {
		
		int qop = -1;
		qop = iCropSpeciesService.DeleteById(cropSid);
		if (qop > 0) {
			map.put("cropid", cropCategoryId);
			return "redirect:SelectOneCrop";
		}
		return "";
	}
	@RequestMapping("SelectSpOne")
	public String selectone(ModelMap map,String cropSid,String cropCategoryId) {
		CropSpecies cropSpecies = iCropSpeciesService.SelectSpOne(cropSid);
		if (cropSpecies != null) {
			map.put("cropCategoryId", cropCategoryId);
			map.put("cropSpecies", cropSpecies);
			return "speciesadd";
		}
		return "";
	}
	@RequestMapping("SelectCropSpeciesBycropId")
	public String selectspeciesbycropid(String cropCategoryId,ModelMap map){
		List<CropSpecies> species = iCropSpeciesService.QueryMessagefromsampleinfo(cropCategoryId);
		map.put("cropCategoryId", cropCategoryId);
		map.put("species", species);
		
		return "person_first2";
	}
	
}
