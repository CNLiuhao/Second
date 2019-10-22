package com.liuhao.service;

import java.util.List;
import java.util.Map;

import com.liuhao.entity.CropSpecies;

public interface ICropSpeciesService {
	
	
	public List<CropSpecies> QueryAllCropSpecies();

	public List<CropSpecies> QueryAll(String cropCategoryId);
	
	public int DeleteById(String cropSid);
	
	public CropSpecies SelectSpOne(String cropSid);
	
	public int UpdateSpOne(CropSpecies cropSpecies);
	
	List<CropSpecies> QueryMessagefromsampleinfo(String cropCategoryId);
	
	List<CropSpecies> QuerySpeciesToshow(Map<String, Object> map);
}
