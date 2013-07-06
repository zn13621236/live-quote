package com.archer.livequote.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.archer.livequote.common.util.CommonUtil;
import com.archer.livequote.db.domain.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	CrudDao crud;

	@Override
	public UserEntity createUser(UserEntity ue) {
		String time = CommonUtil.getCurrentTime();
		ue.setGuid(CommonUtil.generateUid());
		ue.setAddDate(time);
		ue.setUsedCount(1);
		ue.setModDate(time);
		return crud.save(ue);
	}

	@Override
	public UserEntity deleteUserByGuid(String guid) {
		return crud.remove("guid", guid, UserEntity.class);
	}

//	@Override
//	public UserEntity updateCell(String guid, String cell) {
//		String time = CommonUtil.getCurrentTime();
//		UserEntity ue = getUserByGuid(guid);
//		ue.setCell(cell);
//		return crud.save(ue);
//	}

//	@Override
//	public UserEntity updateUserEmail(String guid, String newEmail) {
//		String time = CommonUtil.getCurrentTime();
//		UserEntity ue = getUserByGuid(guid);
//		ue.setEmail(newEmail);
//		return crud.save(ue);
//	}

	@Override
	public boolean increaseUsedNumber(String guid) {
		String time = CommonUtil.getCurrentTime();
		UserEntity ue = getUserByGuid(guid);
		ue.setUsedCount(ue.getUsedCount() + 1);
		ue.setModDate(time);
		return crud.save(ue)!=null;
	}

	@Override
	public UserEntity getUserByGuid(String guid) {
		return crud.getByField("guid", guid, UserEntity.class);
	}

}