package com.archer.livequote.dao;

import com.archer.livequote.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.archer.livequote.db.domain.QuoteHistory;
import com.archer.livequote.db.domain.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	CrudDao crud;

	@Override
	public UserEntity createUser(UserEntity ue) {
		String time = CommonUtils.getCurrentTime();
		if(getUserByEmail(ue.getEmail())!=null){
		ue.setGuid(CommonUtils.generateUid());
		ue.setAddDate(time);
		ue.setUsedCount(1);
		ue.setModDate(time);
		return crud.save(ue);}
		return null;
	}

	@Override
	public UserEntity deleteUserByGuid(String guid) {
		return crud.remove("guid", guid, UserEntity.class);
	}

//	@Override
//	public UserEntity updateCell(String guid, String cell) {
//		String time = CommonUtils.getCurrentTime();
//		UserEntity ue = getUserByGuid(guid);
//		ue.setCell(cell);
//		return crud.save(ue);
//	}

//	@Override
//	public UserEntity updateUserEmail(String guid, String newEmail) {
//		String time = CommonUtils.getCurrentTime();
//		UserEntity ue = getUserByGuid(guid);
//		ue.setEmail(newEmail);
//		return crud.save(ue);
//	}

	@Override
	public boolean increaseUsedNumber(String guid) {
		String time = CommonUtils.getCurrentTime();
		UserEntity ue = getUserByGuid(guid);
		ue.setUsedCount(ue.getUsedCount() + 1);
		ue.setModDate(time);
		return crud.save(ue)!=null;
	}

	@Override
	public UserEntity getUserByGuid(String guid) {
		return crud.getByField("guid", guid, UserEntity.class);
	}
	
	@Override
	public UserEntity getUserByEmail(String email) {
		return crud.getByField("email", email, UserEntity.class);
	}
	
	//quote history operation..
	@Override
	public boolean addQuotHistory(String guid,String quoteCategory){
	    String time = CommonUtils.getCurrentTime();
	    QuoteHistory qh=new QuoteHistory();
	    qh.setCategory(quoteCategory);
	    qh.setQuoteDate(time);
	    UserEntity ue=getUserByGuid(guid);
	    ue.getQuoteHistory().add(qh);
	    return crud.save(ue)!=null;
	}
	
}
