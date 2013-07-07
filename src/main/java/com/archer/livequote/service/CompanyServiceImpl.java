package com.archer.livequote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archer.livequote.dao.CompanyDao;
import com.archer.livequote.db.domain.CompanyEntity;

@Service("compService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyDao cdao;

    @Override
    public void createCompany(CompanyEntity comp) {
	comp.setAccountType("free");
	cdao.insertNewCompany(comp);
    }

    @Override
    public CompanyEntity getCompanyById(String guid) {
	return cdao.getByGuid(guid);
    }

    @Override
    public CompanyEntity updateEmail(String guid, String oldEmail,
	    String newEmail) {
	return cdao.updateCompanyEmail(guid, oldEmail, newEmail);
    }

    @Override
    public boolean removeEmail(String guid, String emailToRemove) {
	return cdao.removeEmail(guid, emailToRemove) != null;
    }

    @Override
    public void addEmail(String companyGuid, String emailToAdd) {
	cdao.addCompanyEmail(companyGuid, emailToAdd);
    }

    @Override
    public boolean updateCompany(String guid, CompanyEntity comp) {
	return cdao.updateComapnyInfo(guid, comp) != null;
    }

    @Override
    public boolean removeArea(String guid, String areaToRemove) {
	return cdao.removeArea(guid, areaToRemove)!=null;
    }

    @Override
    public void addArea(String companyGuid, String areaToAdd) {
	 cdao.addArea(companyGuid, areaToAdd);	
    }

    @Override
    public boolean removeCategory(String guid, String categoryToRemove) {
	return cdao.removeCategory(guid, categoryToRemove)!=null;
    }

    @Override
    public void addCategory(String companyGuid, String categoryToAdd) {
	 cdao.addCategory(companyGuid, categoryToAdd);	
    }

}
