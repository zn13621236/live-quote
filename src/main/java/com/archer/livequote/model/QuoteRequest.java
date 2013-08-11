package com.archer.livequote.model;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.archer.livequote.db.domain.CompanyEntity;
import com.archer.livequote.db.domain.UserEntity;

public class QuoteRequest {
	@NotEmpty
	private String category;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@NotEmpty
	private Date serviceTime;
	private String detail;
	private List<CompanyEntity> perferedCompany;
	@Valid
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

	public Date getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Date serviceTime) {
		this.serviceTime = serviceTime;
	}

	@Override
	public String toString() {
		return "QuoteRequest [category=" + category + ", serviceTime="
				+ serviceTime + ", detail=" + detail + ", perferedCompany="
				+ perferedCompany + ", ue=" + ue + "]";
	}

}
