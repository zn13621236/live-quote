package com.archer.livequote.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.archer.livequote.db.domain.CompanyEntity;
import com.archer.livequote.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {
    private static final Logger logger = LoggerFactory
	    .getLogger(CompanyController.class);

    @Autowired
    CompanyService cService;

    // company front page... for create, delete, update option
    @RequestMapping(method = RequestMethod.GET)
    public String companyHome(Locale locale, Model model) {
	logger.info("Welcome home! The client locale is {}.", locale);
	Date date = new Date();
	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
		DateFormat.LONG, locale);
	String formattedDate = dateFormat.format(date);
	model.addAttribute("serverTime", formattedDate);
	return "company";
    }

    // new company sign up ..
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String createCompany(Model model) {
	CompanyEntity comp = new CompanyEntity();
	model.addAttribute("company", comp);
	return "companyCreate";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String createCompany(@ModelAttribute("company") CompanyEntity comp,
	    BindingResult result) {
	cService.createCompany(comp);
	return "manageAccount";
    }

    // manage account
    @RequestMapping(value = "/{companyGuid}/manage", method = RequestMethod.GET)
    public String manageAccount(@PathVariable String companyGuid, Model model) {
	CompanyEntity ce = cService.getCompanyById(companyGuid);
	model.addAttribute("company", ce);
	return "manageAccount";
    }

    // edit email.....

    // email management page
    // @RequestMapping(value = "/{companyGuid}/emailManagement", method =
    // RequestMethod.GET)
    // public String manageEmail(@PathVariable String companyGuid, Model model)
    // {
    // CompanyEntity ce = cService.getCompanyById(companyGuid);
    // model.addAttribute("company", ce);
    // return "manageAccount";
    // }

    // update email
    @RequestMapping(value = "/{companyGuid}/emailManagement/update", method = RequestMethod.GET)
    public String updateEmail(@PathVariable String companyGuid,
	    @RequestParam("oldEmail") String oldEmail, Model model) {
	CompanyEntity ce = cService.getCompanyById(companyGuid);
	model.addAttribute("company", ce);
	model.addAttribute("oldEmail", oldEmail);
	return "emailUpdate";
    }

    @RequestMapping(value = "/{companyGuid}/emailManagement/update", method = RequestMethod.POST)
    public String updateEmail(@PathVariable String companyGuid,
	    @RequestParam("newEmail") String newEmail,
	    @RequestParam("oldEmail") String oldEmail, Model model) {
	cService.updateEmail(companyGuid, oldEmail, newEmail);
	return manageAccount(companyGuid, model);
    }

    // remove email
    @RequestMapping(value = "/{companyGuid}/emailManagement/remove", method = RequestMethod.GET)
    public String removeEmailPage(@PathVariable String companyGuid,
	    @RequestParam String oldEmail, Model model) {
	model.addAttribute("oldEmail", oldEmail);
	return "emailRemove";
    }

    @RequestMapping(value = "/{companyGuid}/emailManagement/remove", method = RequestMethod.POST)
    public String removeEmail(@PathVariable String companyGuid,
	    @RequestParam String oldEmail, Model model) {
	cService.removeEmail(companyGuid, oldEmail);
	return manageAccount(companyGuid, model);
    }

    // add email
    @RequestMapping(value = "/{companyGuid}/emailManagement/add", method = RequestMethod.GET)
    public String addEmail(@PathVariable String companyGuid, Model model) {
	return "emailAdd";
    }

    @RequestMapping(value = "/{companyGuid}/emailManagement/add", method = RequestMethod.POST)
    public String addEmail(@PathVariable String companyGuid,
	    @RequestParam String newEmail, Model model) {
	cService.addEmail(companyGuid, newEmail);
	return manageAccount(companyGuid, model);
    }

    // remove area
    @RequestMapping(value = "/{companyGuid}/area/remove", method = RequestMethod.GET)
    public String removeAreaPage(@PathVariable String companyGuid,
	    @RequestParam String oldArea, Model model) {
	model.addAttribute("oldArea", oldArea);
	return "areaRemove";
    }

    @RequestMapping(value = "/{companyGuid}/area/remove", method = RequestMethod.POST)
    public String removeArea(@PathVariable String companyGuid,
	    @RequestParam String oldArea, Model model) {
	cService.removeArea(companyGuid, oldArea);
	return manageAccount(companyGuid, model);
    }

    // add area
    @RequestMapping(value = "/{companyGuid}/area/add", method = RequestMethod.GET)
    public String addArea(@PathVariable String companyGuid, Model model) {
	return "areaAdd";
    }

    @RequestMapping(value = "/{companyGuid}/area/add", method = RequestMethod.POST)
    public String addArea(@PathVariable String companyGuid,
	    @RequestParam String newArea, Model model) {
	cService.addArea(companyGuid, newArea);
	return manageAccount(companyGuid, model);
    }
    
    
    //update area
    @RequestMapping(value = "/{companyGuid}/area/update", method = RequestMethod.GET)
    public String updateArea(@PathVariable String companyGuid,
	    @RequestParam("oldArea") String oldArea, Model model) {
	CompanyEntity ce = cService.getCompanyById(companyGuid);
	model.addAttribute("company", ce);
	model.addAttribute("oldArea", oldArea);
	return "areaUpdate";
    }

    @RequestMapping(value = "/{companyGuid}/area/update", method = RequestMethod.POST)
    public String updateArea(@PathVariable String companyGuid,
	    @RequestParam("newArea") String newArea,
	    @RequestParam("oldArea") String oldArea, Model model) {
	cService.updateArea(companyGuid, oldArea, newArea);
	return manageAccount(companyGuid, model);
    }
    
    
    // remove category
    @RequestMapping(value = "/{companyGuid}/category/remove", method = RequestMethod.GET)
    public String removeCategoryPage(@PathVariable String companyGuid,
	    @RequestParam String oldCategory, Model model) {
	model.addAttribute("oldCategory", oldCategory);
	return "categoryRemove";
    }

    @RequestMapping(value = "/{companyGuid}/category/remove", method = RequestMethod.POST)
    public String removeCategory(@PathVariable String companyGuid,
	    @RequestParam String oldCategory, Model model) {
	cService.removeCategory(companyGuid, oldCategory);
	return manageAccount(companyGuid, model);
    }

    // add category
    @RequestMapping(value = "/{companyGuid}/category/add", method = RequestMethod.GET)
    public String addCategory(@PathVariable String companyGuid, Model model) {
	return "categoryAdd";
    }

    @RequestMapping(value = "/{companyGuid}/category/add", method = RequestMethod.POST)
    public String addCategory(@PathVariable String companyGuid,
	    @RequestParam String newCategory, Model model) {
	cService.addCategory(companyGuid, newCategory);
	return manageAccount(companyGuid, model);
    }
    //update category
    @RequestMapping(value = "/{companyGuid}/category/update", method = RequestMethod.GET)
    public String updateCategory(@PathVariable String companyGuid,
	    @RequestParam("oldCategory") String oldCategory, Model model) {
	CompanyEntity ce = cService.getCompanyById(companyGuid);
	model.addAttribute("company", ce);
	model.addAttribute("oldCategory", oldCategory);
	return "categoryUpdate";
    }

    @RequestMapping(value = "/{companyGuid}/category/update", method = RequestMethod.POST)
    public String updateCategory(@PathVariable String companyGuid,
	    @RequestParam("newCategory") String newCategory,
	    @RequestParam("oldCategory") String oldCategory, Model model) {
	cService.updateCategory(companyGuid, oldCategory, newCategory);
	return manageAccount(companyGuid, model);
    }

    
    // edit company regular fields....

    @RequestMapping(value = "/{companyGuid}", method = RequestMethod.GET)
    public String companyEdit(@PathVariable String companyGuid, Model model) {
	CompanyEntity ce = cService.getCompanyById(companyGuid);
	CompanyEntity ce2 = new CompanyEntity();
	model.addAttribute("company", ce);
	model.addAttribute("company2", ce2);
	return "companyEdit";
    }

    @RequestMapping(value = "/{companyGuid}", method = RequestMethod.POST)
    public String companyEdit(@PathVariable String companyGuid,
	    @ModelAttribute("company2") CompanyEntity comp,
	    BindingResult result, Model model) {
	cService.updateCompany(companyGuid, comp);
	return manageAccount(companyGuid, model);
    }
    
    

}
