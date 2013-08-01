package com.archer.livequote.model;

import java.util.List;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.archer.livequote.db.domain.CompanyEntity;
import com.archer.livequote.validator.Unique;

public class CompanyForm {
	@NotEmpty
	@Size(min=2)
	private String companyName;
	@NotEmpty
    @Size(min=4, max=20)
	@Unique(entity=CompanyEntity.class, property="user_name",message = "{Unique.companyForm.userName}")
	private String userName;
    @Size(min=5, max=20)
	private String password;
	private String confirmPassword;
	@NotEmpty
	@Email
	private String email;
	@Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$")
	private String phone;
	@NotEmpty
	private List<String> area;
	@NotEmpty
	private List<String> category;
	public CompanyForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
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
		return "CompanyForm [companyName=" + companyName + ", userName="
				+ userName + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", email=" + email + ", phone=" + phone
				+ ", area=" + area + ", category=" + category + "]";
	}
}
