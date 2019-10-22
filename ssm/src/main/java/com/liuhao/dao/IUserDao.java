package com.liuhao.dao;

import java.util.List;


import com.liuhao.entity.AddressProvince;
import com.liuhao.entity.CropCategory;
import com.liuhao.entity.Roles;
import com.liuhao.entity.User;
import com.liuhao.util.PageUtil;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {

	
	List<User> queryall(Map<String, Object> map);
	
	
	int deleteuser(int id);
	
	List<Roles> queryallroles();
	
	List<AddressProvince> queryallprovince();
	
	List<CropCategory> queryallcropcategory();
	
	int insertuser(User user);
	
	User selectone(String id);
	
	int update(User user);
}
