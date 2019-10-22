package com.liuhao.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuhao.entity.AddressProvince;
import com.liuhao.entity.CropCategory;
import com.liuhao.entity.Roles;
import com.liuhao.entity.User;
import com.liuhao.service.IUserService;
import com.liuhao.util.PageUtil;

@Controller
public class AllController {

	@Autowired
	private IUserService iUserService;
	
	@RequestMapping("QueryAll")
	public String queryall(ModelMap od,String pageNum,String username) {
		Map<String, Object> qop = new HashMap<>();
		qop.put("username", username);
		PageUtil pageUtil = new PageUtil();
		int num = 1;
		if (pageNum != null  && !"".equals(pageNum)) {
			num = Integer.parseInt(pageNum);
		}
		PageHelper pageHelper = new PageHelper();
		pageHelper.startPage(num,3);
		pageUtil.setPageNum(num);
		List<User> alluser = iUserService.selectAlluser(qop);
		PageInfo<User> pageInfo = new PageInfo<>(alluser);
		pageUtil.setCount((int)pageInfo.getTotal());
		pageUtil.setList(alluser);
		od.put("page", pageUtil);
		return "superadmin";
	}
	@RequestMapping("addusermes")
	public String queryrole(ModelMap map) {
		List<Roles> roles = iUserService.queryallroles();
		List<AddressProvince> province = iUserService.queryallprovince();
		List<CropCategory> cropcategory = iUserService.queryallcropcategory();
		map.put("roles", roles);
		map.put("province", province);
		map.put("cropcategory", cropcategory);
		return "user-management-add";
	}
	@RequestMapping("adduser")
	public String adduser(User user) {
		int qop = -1;
		qop = iUserService.insertuser(user);
		if (qop > 0) {
			return "redirect:QueryAll";
		}
		return "";
	}
	
	
	@RequestMapping("DeleteUser")
	public String deleteuser(String id) {
		int uid = Integer.parseInt(id);
		int qop = -1;
		qop = iUserService.deleteuser(uid);
		if (qop > 0) {
			
			return "redirect:QueryAll";
		}
		return "";
	}
	@RequestMapping("SelectOne")
	public String selectone(ModelMap map,String id) {
		User user = iUserService.selectone(id);
		int rid = 2;
		if (rid == user.getRole()) {
	 		List<CropCategory> categories = iUserService.queryallcropcategory();
	 		List<AddressProvince> provinces = iUserService.queryallprovince();
	 		map.put("crops", categories);
	 		map.put("provinces", provinces);
			String crop = user.getCategory();
			if (crop != null && !"".equals(crop)) {
				String[] crStrings = crop.split(",");
				List<Integer> integers = new ArrayList<Integer>();
				for (int i = 0; i < crStrings.length; i++) {
					if (crStrings[i] != null && !"".equals(crStrings[i])) {
						integers.add(Integer.parseInt(crStrings[i].trim()));
					}
					
				}
				map.put("crStrings", integers);
				
			}
			String area = user.getArea();
			if (area != null && !"".equals(area)) {
				String[] areas = area.split(",");
				List<Integer> integers = new ArrayList<Integer>();
				for (int i = 0; i < areas.length; i++) {
					if (areas[i] != null && !"".equals(areas[i])) {
						integers.add(Integer.parseInt(areas[i].trim()));
					}
					
				}
				map.put("areas", integers);
			}
		}
		map.put("users", user);
		map.put("id", rid);
		return "user-management-modify";
	}
	@RequestMapping("UpdateUser")
	public String udpateuser(User user) {
		int qop = -1;
		qop = iUserService.update(user);
		if (qop > 0) {
			return "redirect:QueryAll";
		}
		return "";
	}
	
}
