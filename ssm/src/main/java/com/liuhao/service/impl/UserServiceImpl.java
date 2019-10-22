package com.liuhao.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuhao.dao.IUserDao;
import com.liuhao.entity.AddressProvince;
import com.liuhao.entity.CropCategory;
import com.liuhao.entity.Roles;
import com.liuhao.entity.User;
import com.liuhao.service.IUserService;
import com.liuhao.util.PageUtil;


@Service
public class UserServiceImpl implements IUserService{
	
	
	@Autowired
	private IUserDao IUserDao;
	@Override
	public List<User> selectAlluser(Map<String, Object> map) {
		 
		return IUserDao.queryall(map);
	}
	@Override
	public int deleteuser(int id) {
		return IUserDao.deleteuser(id);
	}
	@Override
	public List<Roles> queryallroles() {
		
		return IUserDao.queryallroles();
	}
	@Override
	public List<AddressProvince> queryallprovince() {
		return IUserDao.queryallprovince();
	}
	@Override
	public List<CropCategory> queryallcropcategory() {
		return IUserDao.queryallcropcategory();
	}
	@Override
	public int insertuser(User user) {
		return IUserDao.insertuser(user);
	}
	@Override
	public User selectone(String id) {
		
		return IUserDao.selectone(id);
	}
	@Override
	public int update(User user) {
		return IUserDao.update(user);
	}

}
