package com.archer.livequote.dao;

import com.archer.livequote.db.domain.UserEntity;

public interface UserDao {

	UserEntity createUser(UserEntity ue);
	
	
//	UserEntity updateUserEmail(String guid,String newEmail);
//	
//	UserEntity updateStatus(String guid, String status);
	
	boolean increaseUsedNumber(String guid);
	
	UserEntity getUserByGuid(String guid);

	UserEntity deleteUserByGuid(String guid);


	boolean addQuotHistory(String guid, String quoteCategory);

//	UserEntity updateCell(String guid, String cell);
	
}
