package com.archer.livequote.to_be_expired;

import java.util.List;


public interface EmailListDao {

	EmailList getByCategory(String category);

	void createEmailList(EmailList emailList);

	void addToEmailList(String category, List<String> emailList);

	void changeCategoryName(String category, String newCategory);

	void removeFromEmailList(String category, String email);

}
