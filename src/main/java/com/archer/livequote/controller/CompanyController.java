package com.archer.livequote.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.archer.livequote.db.domain.CompanyEntity;
import com.archer.livequote.model.ChangePassForm;
import com.archer.livequote.model.CompanyForm;
import com.archer.livequote.model.UpdateAccountForm;
import com.archer.livequote.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {
	private static final Logger logger = LoggerFactory
			.getLogger(CompanyController.class);

	@Autowired
	CompanyService cService;

	// new company sign up ..
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String createCompany(Model model) {
		model.addAttribute("companyForm", new CompanyForm());
		return "companyCreate";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String createCompany(@Valid CompanyForm companyForm,
			BindingResult result) {
		// model.addAttribute("company", company);
		if (result.hasErrors()) {
			logger.info("something is wrong!");
			return "companyCreate";
		}
		CompanyEntity comp = new CompanyEntity();
		comp.setUserName(companyForm.getUserName());
		comp.setArea(companyForm.getArea());
		comp.setCategory(companyForm.getCategory());
		comp.setCompanyName(companyForm.getCompanyName());
		comp.setEmail(Arrays.asList(companyForm.getEmail()));
		comp.setPassword(companyForm.getPassword());
		comp.setPhone(companyForm.getPhone());
		return "redirect:/company/" + cService.createCompany(comp).getGuid()
				+ "/manage";
	}

	// manage account
	@RequestMapping(value = "/{companyGuid}/manage", method = RequestMethod.GET)
	public String manageAccount(@PathVariable String companyGuid, Model model) {
		CompanyEntity ce = cService.getCompanyById(companyGuid);
		model.addAttribute("company", ce);
		return "manageAccount";
	}

	// update account
	@RequestMapping(value = "/{companyGuid}/update", method = RequestMethod.GET)
	public String updateAccount(@PathVariable String companyGuid, Model model) {
		CompanyEntity ce = cService.getCompanyById(companyGuid);
		model.addAttribute("company", ce);
		model.addAttribute("updateForm", new UpdateAccountForm());
		return "updateAccount";
	}

	@RequestMapping(value = "/{companyGuid}/update", method = RequestMethod.POST)
	public String updateAccount(@PathVariable String companyGuid,
			@Valid UpdateAccountForm companyForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			logger.info("something is wrong..");
			return updateAccount(companyGuid, model);					
				//	"redirect:/company/" + companyGuid+ "/update";
		}
		CompanyEntity ce = new CompanyEntity();
		if(companyForm.getPhone()!=null){
		ce.setPhone(companyForm.getPhone());}
		cService.updateCompany(companyGuid, ce);
		return manageAccount(companyGuid, model);
	}

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
		if(newEmail!=null&&!newEmail.isEmpty()){
		cService.updateEmail(companyGuid, oldEmail, newEmail);}
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
		if(newEmail!=null&&!newEmail.isEmpty()){
		cService.addEmail(companyGuid, newEmail);}
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
		if(newArea!=null&&!newArea.isEmpty()){
		cService.addArea(companyGuid, newArea);}
		return manageAccount(companyGuid, model);
	}

	// update area
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
		if(newArea!=null&&!newArea.isEmpty()){
		cService.updateArea(companyGuid, oldArea, newArea);}
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
		if(newCategory!=null&&!newCategory.isEmpty()){
		cService.addCategory(companyGuid, newCategory);}
		return manageAccount(companyGuid, model);
	}

	// update category
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
		if(newCategory!=null&&!newCategory.isEmpty()){
		cService.updateCategory(companyGuid, oldCategory, newCategory);}
		return manageAccount(companyGuid, model);
	}

	// update password
	@RequestMapping(value = "/{companyGuid}/password/update", method = RequestMethod.GET)
	public String updatePass(@PathVariable String companyGuid, Model model) {
		model.addAttribute("changePassWordForm", new ChangePassForm());
		return "passwordUpdate";
	}

	@RequestMapping(value = "/{companyGuid}/password/update", method = RequestMethod.POST)
	public String updatePass(@PathVariable String companyGuid,
			@Valid ChangePassForm changePassWordForm, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			logger.info("something wrong..");
			return "passwordUpdate";
		}
		CompanyEntity ce = cService.getCompanyById(companyGuid);
		String encodePass = cService.encodePassword(changePassWordForm
				.getOldPassWord());
		if (ce.getPassword().equalsIgnoreCase(encodePass)) {
			ce.setPassword(changePassWordForm.getNewPassWord());
			cService.updateCompany(companyGuid, ce);
			return manageAccount(companyGuid, model);
		} else {
			return "passwordUpdate";
		}
	}

}
