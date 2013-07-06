package com.archer.livequote.dao;

import java.util.List;

import com.archer.livequote.db.domain.EmailList;

public interface EmailListDao {

	EmailList getByCategory(String category);

	void createEmailList(EmailList emailList);

	void addToEmailList(String category, List<String> emailList);

	void changeCategoryName(String category, String newCategory);

	void removeFromEmailList(String category, String email);

}
