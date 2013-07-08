package com.archer.livequote.dao;

import com.archer.livequote.db.domain.AreaSetting;


public interface AreaSettingDao {

    String getAreaByZip(String zipCode);

    void createAreaRecord(AreaSetting areaSetting);
	
}
