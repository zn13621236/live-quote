package com.archer.livequote.model;

import java.util.List;

import com.archer.livequote.db.domain.CompanyEntity;
import com.archer.livequote.db.domain.UserEntity;

public class QuoteRequest {

	private String category;
	private String serviceTime;
	private String detail;
	private List<CompanyEntity> perferedCompany;
	private UserEntity ue;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public List<CompanyEntity> getPerferedCompany() {
		return perferedCompany;
	}

	public void setPerferedCompany(List<CompanyEntity> perferedCompany) {
		this.perferedCompany = perferedCompany;
	}

	public UserEntity getUe() {
		return ue;
	}

	public void setUe(UserEntity ue) {
		this.ue = ue;
	}

	public String getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}

	@Override
	public String toString() {
		return "QuoteRequest [category=" + category + ", serviceTime="
				+ serviceTime + ", detail=" + detail + ", perferedCompany="
				+ perferedCompany + ", ue=" + ue + "]";
	}

}
