package com.archer.livequote.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.archer.livequote.model.QuoteRequest;
import com.archer.livequote.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archer.livequote.dao.AreaSettingDao;
import com.archer.livequote.dao.CompanyDao;
import com.archer.livequote.dao.UserDao;
import com.archer.livequote.db.domain.CompanyEntity;
import com.archer.livequote.db.domain.QuoteHistory;
import com.archer.livequote.db.domain.UserEntity;
import com.archer.livequote.email.service.EmailService;

@Service("quoteService")
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	CompanyDao cdao;
	@Autowired
	UserDao udao;
	@Autowired
	AreaSettingDao adao;
	// @Autowired
	// EmailService emailService;
	// @Autowired
	// EmailTemplate et;
	@Autowired
	EmailService es;

	@Override
	public void sendQuote(QuoteRequest qr) {
		// save user..
		saveUser(qr);
		// get email list..
		String[] emailList = getEmailList(qr);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("quoteRequest", qr);
		es.sendEmail("2", emailList, model);

		// et.setSubject("New customer needs quote");
		// et.setToEmails(emailList);
		// et.setText(assembleEmailBody(qr));
		// emailService.sendEmail(et);

	}

	public void saveUser(QuoteRequest qr) {
		UserEntity ue = null;
		// if not exist, create user, add quote history
		if (udao.getUserByEmail(qr.getUe().getEmail()) == null) {
			ue = qr.getUe();

		} else { // if exist, add quote history
			ue = udao.getUserByEmail(qr.getUe().getEmail());
		}
		QuoteHistory qh = new QuoteHistory();
		qh.setCategory(qr.getCategory());
		qh.setQuoteDate(CommonUtils.getCurrentTime());
		if (ue.getQuoteHistory() == null) {
			ue.setQuoteHistory(Arrays.asList(qh));
		} else {
			ue.getQuoteHistory().add(qh);
		}
		ue.setUsedCount(ue.getUsedCount() + 1);
		udao.createUser(ue);
	}

	public String[] getEmailList(QuoteRequest qr) {
		List<CompanyEntity> cList = null;
		// if no prefer company, send to all qualified company
		if (qr.getPerferedCompany() == null) {
			cList = cdao.getByCaegoryAndArea(qr.getCategory(),
                    adao.getAreaByZip(qr.getUe().getZip()));
		} else {
			cList = qr.getPerferedCompany();
		}
		List<String> eList = new ArrayList<String>();
		for (CompanyEntity ce : cList) {
			eList.addAll(ce.getEmail());
		}
		return eList.toArray(new String[eList.size()]);
	}

	public String assembleEmailBody(QuoteRequest qr) {
		StringBuffer sb = new StringBuffer();
		sb.append("email: ");
		sb.append(qr.getUe().getEmail());
		sb.append("zipcode: ");
		sb.append(qr.getUe().getZip());
		sb.append("detail: ");
		sb.append(qr.getDetail());
		return sb.toString();
	}
}
