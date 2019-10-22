package com.liuhao.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.liuhao.entity.CropSpecies;

@Repository
public interface ICropSpeciesDao {
	
	
	List<CropSpecies> QueryAllCropSpecies();
	
	List<CropSpecies> QueryAll(String cropCategoryId);
	
	
	int DeleteById(String cropSid);
	
	CropSpecies SelectSpOne(String cropSid);
	
	int UpdateSpOne(CropSpecies cropSpecies);
	
	List<CropSpecies> QueryMessagefromsampleinfo(String cropCategoryId);
	
	List<CropSpecies> QuerySpeciesToshow(Map<String, Object> map);

}
