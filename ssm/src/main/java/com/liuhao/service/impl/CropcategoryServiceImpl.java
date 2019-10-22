package com.liuhao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuhao.dao.ICropcategoryDao;
import com.liuhao.entity.CropCategory;
import com.liuhao.service.ICropcategoryService;
import com.liuhao.util.PageUtil;


@Service
public class CropcategoryServiceImpl implements ICropcategoryService {
	
	@Autowired
	private ICropcategoryDao icropcategoryDao;
	@Override
	public List<CropCategory> queryall() {
		
		return icropcategoryDao.queryall();
	}
	
	
	
	@Override
	public CropCategory selcetone(int cropid)  {
		return icropcategoryDao.selcetone(cropid);
	}
	
	
	@Override
	public int updateCrop(CropCategory category) {
		return icropcategoryDao.updateCrop(category);
	}



	@Override
	public int count() {
	/*	return icropcategoryDao.count();*/
		return 0;
	}


	@Override
	public int deletById(String id) {
		return icropcategoryDao.deletById(id);
	}

	@Override
	public int insertcrop(CropCategory category) {
		return icropcategoryDao.insertcrop(category);
	}
	@Override
	public List<CropCategory> QueryALLaboutcropId() {
		return icropcategoryDao.QueryALLaboutcropId();
	}

}
