package com.liuhao.service;

import java.util.List;

import com.liuhao.entity.CropCategory;
import com.liuhao.util.PageUtil;

public interface ICropcategoryService {

	
	public List<CropCategory> queryall();
	
	
	public CropCategory selcetone(int cropid) ;
	
	public int updateCrop(CropCategory category) ;
	
	
	public int deletById(String id) ;
	
	public int insertcrop(CropCategory category);


	int count();
	
	List<CropCategory> QueryALLaboutcropId();
}
