package com.archer.livequote.service;

import com.archer.livequote.dao.CompanyDao;
import com.archer.livequote.dao.VendorAccountRepository;
import com.archer.livequote.db.domain.CompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("compService")
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyDao cdao;

    @Autowired
    private VendorAccountRepository vendorAccountRepository;

    @Autowired
    private transient Md5PasswordEncoder passwordEncoder;
    private final String SALT = "live-quote";

    @Override
    public CompanyEntity findByUserName(String username) {
        return vendorAccountRepository.findByUserName(username);
    }

    public String encodePassWord(String pass) {
        return passwordEncoder.encodePassword(pass, SALT);
    }

    @Override
    public CompanyEntity createCompany(CompanyEntity comp) {
        comp.setAccountType("free");
        comp.setStatus("active");
        comp.setPassword(passwordEncoder.encodePassword(comp.getPassword(),
                SALT));
        return cdao.insertNewCompany(comp);
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
        if (getCompanyById(guid).getEmail().size() > 1) {
            return cdao.removeEmail(guid, emailToRemove) != null;
        } else
            return false;
    }

    @Override
    public void addEmail(String companyGuid, String emailToAdd) {
        cdao.addCompanyEmail(companyGuid, emailToAdd);
    }

    @Override
    public boolean updateCompany(String guid, CompanyEntity comp) {
        if (comp.getPassword() != null) {
            comp.setPassword(passwordEncoder.encodePassword(comp.getPassword(),
                    SALT));
        }
        return cdao.updateComapnyInfo(guid, comp) != null;
    }

    @Override
    public boolean removeArea(String guid, String areaToRemove) {
        if (getCompanyById(guid).getArea().size() > 1) {
            return cdao.removeArea(guid, areaToRemove) != null;
        } else
            return false;
    }

    @Override
    public void addArea(String companyGuid, String areaToAdd) {
        cdao.addArea(companyGuid, areaToAdd);
    }

    @Override
    public boolean removeCategory(String guid, String categoryToRemove) {
        if (getCompanyById(guid).getCategory().size() > 1) {
            return cdao.removeCategory(guid, categoryToRemove) != null;
        } else
            return false;
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

    public String encodePassword(String password) {
        return passwordEncoder.encodePassword(password, SALT);
    }

}
