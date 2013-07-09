package com.archer.livequote.service;

import com.archer.livequote.dao.CompanyDao;
import com.archer.livequote.dao.VendorAccountRepository;
import com.archer.livequote.db.domain.CompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service("compService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyDao cdao;

    @Autowired
    private VendorAccountRepository vendorAccountRepository;

    @Autowired
    private transient PasswordEncoder passwordEncoder;
    private final String SALT = "life-quote";

    public CompanyEntity getByUsernameAndPassword(String username, String password) {
        List<CompanyEntity> vendors = vendorAccountRepository.findByUserNameAndPasswordQuery(username, passwordEncoder.encodePassword(password, SALT));
        if (!CollectionUtils.isEmpty(vendors)) {
            return vendors.get(0);
        }
        return null;
    }

    @Override
    public void insertCompany(CompanyEntity company) {
        company.setPassword(passwordEncoder.encodePassword(company.getPassword(), SALT));
        cdao.insertNewCompany(company);
    }

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
        return cdao.removeArea(guid, areaToRemove) != null;
    }

    @Override
    public void addArea(String companyGuid, String areaToAdd) {
        cdao.addArea(companyGuid, areaToAdd);
    }

    @Override
    public boolean removeCategory(String guid, String categoryToRemove) {
        return cdao.removeCategory(guid, categoryToRemove) != null;
    }

    @Override
    public void addCategory(String companyGuid, String categoryToAdd) {
        cdao.addCategory(companyGuid, categoryToAdd);
    }

    @Override
    public void updateArea(String guid, String oldArea, String newArea) {
        cdao.removeArea(guid, oldArea);
        cdao.addArea(guid, newArea);
    }

    @Override
    public void updateCategory(String guid, String oldCategory,
                               String newCategory) {
        cdao.removeCategory(guid, oldCategory);
        cdao.addCategory(guid, newCategory);
    }

}
