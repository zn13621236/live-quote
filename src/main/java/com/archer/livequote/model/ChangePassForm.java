package com.archer.livequote.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.archer.livequote.validator.FieldMatch;

@FieldMatch(first = "newPassWord", second = "confirmPassword", message = "{FieldMatch.changePassWordForm.confirmPassword}")
public class ChangePassForm {

	@NotEmpty
	private String oldPassWord;
	@Size(min = 5, max = 20)
	private String newPassWord;
	private String confirmPassword;

	public String getOldPassWord() {
		return oldPassWord;
	}

	public void setOldPassWord(String oldPassWord) {
		this.oldPassWord = oldPassWord;
	}

	public String getNewPassWord() {
		return newPassWord;
	}

	public void setNewPassWord(String newPassWord) {
		this.newPassWord = newPassWord;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "ChangePassForm [oldPassWord=" + oldPassWord + ", newPassWord="
				+ newPassWord + ", confirmPassword=" + confirmPassword + "]";
	}

}
