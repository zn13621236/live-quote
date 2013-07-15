package com.archer.livequote.db.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "area_setting")
public class AreaSetting {
	@Field (value = "area_name")
	private String areaName;
	@Field(value = "zipcode_range")
	private ZipCodeRange zipCodeRange;

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public ZipCodeRange getZipCodeRange() {
		return zipCodeRange;
	}

	public void setZipCodeRange(ZipCodeRange zipCodeRange) {
		this.zipCodeRange = zipCodeRange;
	}

	@Override
	public String toString() {
		return "AreaSetting [areaName=" + areaName + ", zipCodeRange="
				+ zipCodeRange + "]";
	}

}
