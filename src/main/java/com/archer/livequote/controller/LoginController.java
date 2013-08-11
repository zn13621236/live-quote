package com.archer.livequote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
//    @Autowired
//    private CompanyDao cdao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "titles.company.login";
    }

    @RequestMapping(value = "/login-error", method = RequestMethod.GET)
    public String loginFailure() {
        return "titles.company.loginError";
    }

//    @RequestMapping(value = "/secure/{companyGuid}/emailManagement", method = RequestMethod.GET)
//    public String manageEmail(@PathVariable String companyGuid, Model model) {
//        CompanyEntity ce = cdao.getByGuid(companyGuid);
//        model.addAttribute("company", ce);
//        return "manageAccount";
//    }
}
