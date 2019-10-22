package com.liuhao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuhao.common.Result;
import com.liuhao.entity.CropCategory;
import com.liuhao.service.ICropcategoryService;
import com.liuhao.util.PageUtil;

@Controller
public class CropController {

	@Autowired
	private ICropcategoryService iCropcategoryService;
	
	@RequestMapping("QueryAllCrop")
	public String querycrop(ModelMap map,String pageNum) {
		
		PageHelper pageHelper = new PageHelper();
		PageUtil pageUtil = new PageUtil();
		int num = 1;
		if (pageNum != null &&  !"".equals(pageNum)) {
			num = Integer.parseInt(pageNum);
		}
		pageUtil.setPageNum(num);
		pageHelper.startPage(num,3);
		List<CropCategory> cropCategories = iCropcategoryService.queryall();
		PageInfo<CropCategory> info = new PageInfo<>(cropCategories);
		pageUtil.setList(cropCategories);
		pageUtil.setCount((int)info.getTotal());
		if (cropCategories != null) {
			map.put("page", pageUtil);
			return "categorylist";
		}
		return "";
	}
	
	@RequestMapping("DeleteCrop")
	public String deletecrop(String id) {
		int qop = -1;
		qop = iCropcategoryService.deletById(id);
		if (qop >0) {
			return "redirect:QueryAllCrop";
		}
		return "";
	}
	
	@RequestMapping("SelectOneCrop")
	public String selectonecrop(ModelMap map,String cropid) {
		int id = Integer.parseInt(cropid);
		CropCategory cropCategory = iCropcategoryService.selcetone(id);
		map.put("cropsqop", cropCategory);
		
		return "toxinedit1";
	}
	
	@RequestMapping("UpdateCrop")
	public String updatecrop(CropCategory category) {
		
		int qop = -1;
		qop = iCropcategoryService.updateCrop(category);
		if (qop > 0) {
			return "redirect:QueryAllCrop";
		}
		return "";
	}
	
	@RequestMapping("JustQueryAll")
	@ResponseBody
	public Result queryallcrop() {
		Result result = null;
		try {
			List<CropCategory> list = iCropcategoryService.queryall();
			result = new Result("200",list,"success");
		} catch (Exception e) {
			result = new Result("999",null,"nanshou");
			e.printStackTrace();
		}
		
		return result;
	}

	@RequestMapping("QueryaboutcropCategory")
	public String queryallcropid(ModelMap map) {
		
		List<CropCategory> queryALLaboutcropId = iCropcategoryService.QueryALLaboutcropId();
		map.put("cropId", queryALLaboutcropId);
		return "person_first1";
	}
//	@RequestMapping("QueryaboutcropCategory")
//	@ResponseBody
//	public Result queryallcropid() {
//		Result result = null ;
//		
//		try {
//			List<CropCategory> queryALLaboutcropId = iCropcategoryService.QueryALLaboutcropId();
//			result = new Result("200", queryALLaboutcropId, "oj8k");
//		} catch (Exception e) {
//			result = new Result("500", null, "sj8wy");
//			e.printStackTrace();
//		}
//		return result;
//	}
	
}
