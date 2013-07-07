package com.archer.livequote.service;

import com.archer.livequote.db.domain.CompanyEntity;


public interface CompanyService {

    void createCompany(CompanyEntity comp);

    CompanyEntity getCompanyById(String guid);

    CompanyEntity updateEmail(String guid, String oldEmail, String newEmail);

    boolean removeEmail(String guid, String emailToRemove);

    void addEmail(String companyGuid, String emailToAdd);

    boolean updateCompany(String guid, CompanyEntity comp);

	

}
