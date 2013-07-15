package com.archer.livequote;

import com.archer.livequote.dao.AreaSettingDao;
import com.archer.livequote.dao.CompanyDao;
import com.archer.livequote.db.domain.AreaSetting;
import com.archer.livequote.db.domain.CompanyEntity;
import com.archer.livequote.db.domain.ZipCodeRange;
import com.archer.livequote.service.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/ApplicationContext.xml"})
public class DaoTest {

    @Autowired
    CompanyDao cDao;
    @Autowired
    AreaSettingDao adao;
    @Autowired
    private CompanyService companyService;

    @Test
    public void insertTest() {
        CompanyEntity c = new CompanyEntity();
        c.setEmail(Arrays.asList(new String[]{"abc@gmail.com",
                "bcd@gmail.com"}));
        cDao.insertNewCompany(c);

    }

    @Test
    public void testGet() {

        CompanyEntity c = cDao.getByEmail("abc@gmail.com");
        System.out.println(c.toString());
    }

    @Test
    public void testUpdateEmail() {
        CompanyEntity c = cDao.getByEmail("abc@gmail.com");

        cDao.updateCompanyEmail(c.getGuid(), "abc@gmail.com", "abc1@gmail.com");
    }

    @Test
    public void insertAreaTest() {
        AreaSetting as = new AreaSetting();
        ZipCodeRange zcr = new ZipCodeRange();
        zcr.setMinZip(98000);
        zcr.setMaxZip(98500);
        as.setAreaName("seattle");
        as.setZipCodeRange(zcr);
        adao.createAreaRecord(as);
    }

    @Test
    public void insertPassword() {
        companyService.createCompany(createCompany("a@b.com", "a@b.com"));
    }

    private CompanyEntity createCompany(String username, String password) {
        CompanyEntity company = new CompanyEntity();
        company.setUserName(username);
        company.setPassword(password);
        company.setEmail(Arrays.asList(new String[]{username}));
        return company;
    }
}
