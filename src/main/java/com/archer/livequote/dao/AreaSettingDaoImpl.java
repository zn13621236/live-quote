package com.archer.livequote.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.archer.livequote.db.domain.AreaSetting;

@Repository
public class AreaSettingDaoImpl implements AreaSettingDao {

    @Autowired
    CrudDao crud;

    @Override
    public String getAreaByZip(String zipCode) {
	int zip = Integer.valueOf(zipCode);
	List<AreaSetting> asList = crud.getAll(AreaSetting.class);
	for (AreaSetting as : asList) {
	    if (as.getZipCodeRange().getMinZip() <= zip
		    && zip <= as.getZipCodeRange().getMaxZip()) {
		return as.getAreaName();
	    }
	}
	return null;
    }
    @Override   
    public void createAreaRecord(AreaSetting areaSetting){
	crud.save(areaSetting);
    }

}
