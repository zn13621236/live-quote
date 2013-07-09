package com.archer.livequote.db.domain;

public class QuoteHistory {

	private String quoteDate;
	private String Category;

	public String getQuoteDate() {
		return quoteDate;
	}

	public void setQuoteDate(String quoteDate) {
		this.quoteDate = quoteDate;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	@Override
	public String toString() {
		return "QuoteHistory [quoteDate=" + quoteDate + ", Category="
				+ Category + "]";
	}

}
