package com.archer.livequote.service;

import com.archer.livequote.db.domain.CompanyEntity;

public interface CompanyService {

    void createCompany(CompanyEntity comp);

    CompanyEntity getCompanyById(String guid);

    CompanyEntity updateEmail(String guid, String oldEmail, String newEmail);

    boolean removeEmail(String guid, String emailToRemove);

    void addEmail(String companyGuid, String emailToAdd);

    boolean removeArea(String guid, String emailToRemove);

    void addArea(String companyGuid, String areaToAdd);

    void updateArea(String guid, String oldArea, String newArea);

    boolean removeCategory(String guid, String categoryToRemove);

    void addCategory(String companyGuid, String categoryToAdd);

    void updateCategory(String guid, String oldCategory,
                        String newCategory);

    boolean updateCompany(String guid, CompanyEntity comp);

    CompanyEntity getByUsernameAndPassword(String username, String password);

    void insertCompany(CompanyEntity company);
}
