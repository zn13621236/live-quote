package com.archer.livequote.model;

import java.util.List;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class CompanyCreateForm {
	private String companyName;
	private String userName;
	private String password;
	private String email;
	private String phone;
	private List<String> area;
	private List<String> category;
	@NotEmpty
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@NotEmpty
    @Size(min=4, max=20)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
//@Pattern(regexp = "")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@NotEmpty
	@Email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<String> getArea() {
		return area;
	}

	public void setArea(List<String> area) {
		this.area = area;
	}

	public List<String> getCategory() {
		return category;
	}

	public void setCategory(List<String> category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CompanyCreateForm [companyName=" + companyName + ", userName="
				+ userName + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + ", area=" + area + ", category="
				+ category + "]";
	}

}
