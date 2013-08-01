package com.archer.livequote.dao;


import com.archer.livequote.db.domain.CompanyEntity;

import java.util.List;

public interface CompanyDao {

    CompanyEntity getByGuid(String guid);

    CompanyEntity getByEmail(String email);
    
    CompanyEntity getByUserName(String userName);
    
    CompanyEntity insertNewCompany(CompanyEntity newCompany);

//	CompanyEntity updateCompanyName(String guid, String newName);

    CompanyEntity updateCompanyEmail(String guid, String oldEmail,
                                     String newEmail);

    CompanyEntity removeEmail(String guid, String emailToRemove);

    CompanyEntity removeCategory(String guid, String categoryToRemove);

    CompanyEntity addCategory(String guid, String newCategory);

    CompanyEntity addCompanyEmail(String guid, String newEmail);

    boolean removeCompany(String guid);

  //  CompanyEntity updatePassword(String guid, String newPassword);

    CompanyEntity updateComapnyInfo(String guid, CompanyEntity newComp);

    CompanyEntity removeArea(String guid, String areaToRemove);

    CompanyEntity addArea(String guid, String newArea);

    List<CompanyEntity> getByCaegoryAndArea(String category, String area);


}
