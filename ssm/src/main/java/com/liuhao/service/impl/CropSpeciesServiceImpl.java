package com.liuhao.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuhao.dao.ICropSpeciesDao;
import com.liuhao.entity.CropSpecies;
import com.liuhao.service.ICropSpeciesService;

@Service
public class CropSpeciesServiceImpl implements ICropSpeciesService {

	@Autowired
	private ICropSpeciesDao icropspeciesdao;
	
	
	@Override
	public List<CropSpecies> QueryAllCropSpecies() {
		return icropspeciesdao.QueryAllCropSpecies();
	}
	@Override
	public List<CropSpecies> QueryAll(String cropCategoryId) {
		return icropspeciesdao.QueryAll(cropCategoryId);
	}
	@Override
	public int DeleteById(String cropSid) {
		return icropspeciesdao.DeleteById(cropSid);
	}
	@Override
	public CropSpecies SelectSpOne(String cropSid) {
		return icropspeciesdao.SelectSpOne(cropSid);
	}
	@Override
	public int UpdateSpOne(CropSpecies cropSpecies) {
		return icropspeciesdao.UpdateSpOne(cropSpecies);
	}
	@Override
	public List<CropSpecies> QueryMessagefromsampleinfo(String cropCategoryId) {
		return icropspeciesdao.QueryMessagefromsampleinfo(cropCategoryId);
	}
	@Override
	public List<CropSpecies> QuerySpeciesToshow(Map<String, Object> map) {
		return icropspeciesdao.QuerySpeciesToshow(map);
	}
}
