package com.archer.livequote.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.archer.livequote.model.QuoteRequest;
import com.archer.livequote.service.QuoteService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	QuoteService qs;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		QuoteRequest qr=new QuoteRequest();		
		model.addAttribute("quoteRequest", qr );
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(@ModelAttribute("quoteRequest") QuoteRequest qr,@RequestParam("day") String day,@RequestParam("month") String month,@RequestParam("year") String year, Model model) {
		
		qr.setServiceTime(day+"/"+month+"/"+year);
		qs.sendQuote(qr);
		return "success";
	}
	
}
