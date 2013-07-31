package com.archer.livequote.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
//	@InitBinder
//    public void initBinder(WebDataBinder binder) {
//        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true);
//        binder.registerCustomEditor(Date.class, editor);
//    }
	
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
	public String home(@Valid QuoteRequest qr, BindingResult result) {
		if(result.hasErrors()){
			System.out.println("something is wrong!");
			return "home";
		}
		qs.sendQuote(qr);
		return "success";
	}
	
}
