package com.archer.livequote.db.domain;

import java.util.List;

import javax.validation.constraints.Pattern;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
public class UserEntity {

	@Id
	private ObjectId id;
	@Field("guid")
	private String guid;
	@NotEmpty
	@Email
	private String email;
	@Field("system_used_count")
	private int usedCount = 1;
	@Field("cell_number")
	private String cell;
	@Pattern(regexp = "^\\d{5}(?:[-\\s]\\d{4})?$")
	@NotEmpty
	private String zip;
	@Field("add_date")
	private String addDate;
	@Field("mod_date")
	private String modDate;
	@Field("quote_history")
	private List<QuoteHistory> quoteHistory;

	public ObjectId getId() {
		return id;
	}

	public String getModDate() {
		return modDate;
	}

	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getUsedCount() {
		return usedCount;
	}

	public void setUsedCount(int usedCount) {
		this.usedCount = usedCount;
	}

	public List<QuoteHistory> getQuoteHistory() {
		return quoteHistory;
	}

	public void setQuoteHistory(List<QuoteHistory> quoteHistory) {
		this.quoteHistory = quoteHistory;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", guid=" + guid + ", email=" + email
				+ ", usedCount=" + usedCount + ", cell=" + cell + ", zip="
				+ zip + ", addDate=" + addDate + ", quoteHistory="
				+ quoteHistory + "]";
	}

}
