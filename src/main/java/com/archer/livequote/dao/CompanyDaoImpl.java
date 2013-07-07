package com.archer.livequote.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.archer.livequote.common.util.CommonUtil;
import com.archer.livequote.db.domain.CompanyEntity;

@Repository
public class CompanyDaoImpl implements CompanyDao {

    @Autowired
    public CrudDao crud;

    @Override
    public CompanyEntity getByGuid(String guid) {
	return crud.getByField("guid", guid, CompanyEntity.class);
    }

    // to do...
    @Override
    public CompanyEntity getByEmail(String email) {
	return crud.getByField("email_list", email, CompanyEntity.class);
    }

    @Override
    public CompanyEntity insertNewCompany(CompanyEntity newCompany) {
	String time = CommonUtil.getCurrentTime();
	newCompany.setGuid(CommonUtil.generateUid());
	newCompany.setAddDate(time);
	newCompany.setModDate(time);
	return crud.save(newCompany);
    }

    // @Override
    // public CompanyEntity updateCompanyName(String guid, String newName) {
    // String time = CommonUtil.getCurrentTime();
    // CompanyEntity comp = getByGuid(guid);
    // comp.setCompanyName(newName);
    // comp.setModDate(time);
    // return crud.save(comp);
    // }
    // update all non-list field for company entity..
    @Override
    public CompanyEntity updateComapnyInfo(String guid, CompanyEntity newComp) {
	String time = CommonUtil.getCurrentTime();
	CompanyEntity comp = getByGuid(guid);
	if (newComp.getAccountType() != null)
	    comp.setAccountType(newComp.getAccountType());
	if (newComp.getCompanyName() != null)
	    comp.setCompanyName(newComp.getCompanyName());
	if (newComp.getExpireDate() != null)
	    comp.setExpireDate(newComp.getExpireDate());
	if (newComp.getPhone() != null)
	    comp.setPhone(newComp.getPhone());
	if (newComp.getPassWord() != null)
	    comp.setPassWord(newComp.getPassWord());
	if (newComp.getUserName() != null)
	    comp.setUserName(newComp.getUserName());
	if (newComp.getStatus() != null)
	    comp.setStatus(newComp.getStatus());
	comp.setModDate(time);
	return crud.save(comp);
    }

    // email operation..
    @Override
    public CompanyEntity updateCompanyEmail(String guid, String oldEmail,
	    String newEmail) {
	String time = CommonUtil.getCurrentTime();
	CompanyEntity comp = getByGuid(guid);
	List<String> emails = comp.getEmail();
	for (String email : emails) {
	    if (email.equalsIgnoreCase(oldEmail)) {
		emails.set(emails.indexOf(oldEmail), newEmail);
	    }
	}
	comp.setModDate(time);
	return crud.save(comp);
    }

    @Override
    public CompanyEntity addCompanyEmail(String guid, String newEmail) {
	String time = CommonUtil.getCurrentTime();
	CompanyEntity comp = getByGuid(guid);
	comp.getEmail().add(newEmail);
	comp.setModDate(time);
	return crud.save(comp);
    }

    @Override
    public CompanyEntity removeEmail(String guid, String emailToRemove) {
	String time = CommonUtil.getCurrentTime();
	CompanyEntity comp = getByGuid(guid);
	List<String> emails = comp.getEmail();
	for (String email : emails) {
	    if (email.equalsIgnoreCase(emailToRemove)) {
		emails.remove(emailToRemove);
	    }
	}
	comp.setModDate(time);
	return crud.save(comp);
    }

    // category operation...

    @Override
    public CompanyEntity addCategory(String guid, String newCategory) {
	String time = CommonUtil.getCurrentTime();
	CompanyEntity comp = getByGuid(guid);
	comp.getCategory().add(newCategory);
	comp.setModDate(time);
	return crud.save(comp);
    }

    @Override
    public CompanyEntity removeCategory(String guid, String categoryToRemove) {
	String time = CommonUtil.getCurrentTime();
	CompanyEntity comp = getByGuid(guid);
	List<String> cateList = comp.getCategory();
	for (String cate : cateList) {
	    if (cate.equalsIgnoreCase(categoryToRemove)) {
		cateList.remove(categoryToRemove);
	    }
	}
	comp.setModDate(time);
	return crud.save(comp);
    }

    //area operation...
    @Override
    public CompanyEntity addArea(String guid, String newArea) {
	String time = CommonUtil.getCurrentTime();
	CompanyEntity comp = getByGuid(guid);
	comp.getArea().add(newArea);
	comp.setModDate(time);
	return crud.save(comp);
    }

    @Override
    public CompanyEntity removeArea(String guid, String areaToRemove) {
	String time = CommonUtil.getCurrentTime();
	CompanyEntity comp = getByGuid(guid);
	List<String> areaList = comp.getArea();
	for (String area : areaList) {
	    if (area.equalsIgnoreCase(areaToRemove)) {
		areaList.remove(areaToRemove);
	    }
	}
	comp.setModDate(time);
	return crud.save(comp);
    }
    
    // @Override
    // public CompanyEntity addCategoryForCompany(String guid, String category)
    // {
    // String time = CommonUtil.getCurrentTime();
    // CompanyEntity comp = getByGuid(guid);
    // comp.getCategory().add(category);
    // comp.setModDate(time);
    // return crud.save(comp);
    // }

    // @Override
    // public CompanyEntity removeCategory(String guid, String category) {
    // String time = CommonUtil.getCurrentTime();
    // CompanyEntity comp = getByGuid(guid);
    // List<String> cateList = comp.getCategory();
    // for (String cate : cateList) {
    // if (cate.equalsIgnoreCase(category)) {
    // cateList.remove(category);
    // }
    // }
    // comp.setModDate(time);
    // return crud.save(comp);
    // }

    @Override
    public boolean removeCompany(String guid) {
	return crud.remove("guid", guid, CompanyEntity.class) != null;
    }

    @Override
    public CompanyEntity updatePassword(String guid, String newPassword) {
	String time = CommonUtil.getCurrentTime();
	CompanyEntity comp = getByGuid(guid);
	comp.setPassWord(newPassword);
	comp.setModDate(time);
	return crud.save(comp);
    }

}
