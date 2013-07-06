package com.archer.livequote;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.archer.livequote.common.util.CommonUtil;
import com.archer.livequote.constant.Environment;
import com.archer.livequote.dao.CompanyDao;
import com.archer.livequote.db.domain.CompanyEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/root-context.xml" })
public class DaoTest {

	@Autowired
	CompanyDao cDao;

	@Test
	public void insertTest() {
		Environment.init();
		CompanyEntity c = new CompanyEntity();
		c.setEmail(Arrays.asList(new String[] { "abc@gmail.com",
				"bcd@gmail.com" }));
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
	

}
