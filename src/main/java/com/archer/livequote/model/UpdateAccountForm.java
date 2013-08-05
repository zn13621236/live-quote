package com.archer.livequote.model;

import javax.validation.constraints.Pattern;

public class UpdateAccountForm {


	@Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$")
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UpdateAccountForm [phone=" + phone + "]";
	}


}
