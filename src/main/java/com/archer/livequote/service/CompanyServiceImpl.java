package com.archer.livequote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archer.livequote.dao.CompanyDao;

@Service("compService")
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyDao cdao;
	
	
	
}
