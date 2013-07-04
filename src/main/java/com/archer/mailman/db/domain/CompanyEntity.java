package com.archer.mailman.db.domain;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "company")
public class CompanyEntity {

	@Id
	private ObjectId id;
	private String guid;
	@Field("company_name")
	private String companyName;
	@Field("password")
	private String passWord;
	@Field("categories")
	private String category;
	@Field("email_list")
	private List<String> email;
	@Field("account_type")
	private String accountType;
	@Field("active_date")
	private String activeDate;
	private String status;
	@Field("add_date")
	private String addDate;
	@Field("mod_date")
	private String modDate;

	public ObjectId getId() {
		return id;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<String> getEmail() {
		return email;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(String activeDate) {
		this.activeDate = activeDate;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public String getModDate() {
		return modDate;
	}

	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

	@Override
	public String toString() {
		return "CompanyEntity [id=" + id + ", guid=" + guid + ", companyName="
				+ companyName + ", passWord=" + passWord + ", category="
				+ category + ", email=" + email + ", accountType="
				+ accountType + ", activeDate=" + activeDate + ", status="
				+ status + ", addDate=" + addDate + ", modDate=" + modDate
				+ "]";
	}


}
