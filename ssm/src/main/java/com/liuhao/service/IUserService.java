package com.liuhao.service;

import java.util.List;
import java.util.Map;

import com.liuhao.entity.AddressProvince;
import com.liuhao.entity.CropCategory;
import com.liuhao.entity.Roles;
import com.liuhao.entity.User;
import com.liuhao.util.PageUtil;

public interface IUserService {

	
	public List<User> selectAlluser(Map<String, Object> map);
	public int deleteuser(int id);
	public List<Roles> queryallroles();
	public List<AddressProvince> queryallprovince();
	public List<CropCategory> queryallcropcategory();
	public int insertuser(User user);
	public User selectone(String id);
	public int update(User user);
}
