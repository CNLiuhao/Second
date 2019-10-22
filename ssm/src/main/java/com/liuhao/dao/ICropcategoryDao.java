package com.liuhao.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.liuhao.entity.CropCategory;
import com.liuhao.util.PageUtil;

@Repository
public interface ICropcategoryDao {

	
	List<CropCategory> queryall();
	
	CropCategory selcetone(int cropid);
	
	int updateCrop(CropCategory category);
	
	int count();
	
	int deletById(String id);
	
	
	int insertcrop(CropCategory category);
	
	List<CropCategory> QueryALLaboutcropId();
}
