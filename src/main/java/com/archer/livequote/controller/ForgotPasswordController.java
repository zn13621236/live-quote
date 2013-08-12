package com.archer.livequote.controller;

import com.archer.livequote.db.domain.CompanyEntity;
import com.archer.livequote.email.service.EmailService;
import com.archer.livequote.fyp.service.AesEncodedTokenService;
import com.archer.livequote.service.CompanyService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ayang
 */
@Controller
@RequestMapping("/password")
public class ForgotPasswordController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private AesEncodedTokenService aesEncodedTokenService;

    @Autowired
    private EmailService emailService;

    @RequestMapping(method = RequestMethod.GET)
    public String forgotPassword() {
        return "titles.company.fyp";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handleRequestForgotPassword(@RequestParam("username") String username, BindingResult result) {
        if (StringUtils.isBlank(username)) {
            result.rejectValue("username", "");
            return "titles.company.fyp";
        }
        CompanyEntity companyEntity = companyService.findByUserName(username);
        if (companyEntity == null) {
            result.rejectValue("username", "");
            return "titles.company.fyp";
        }
        if (CollectionUtils.isEmpty(companyEntity.getEmail())) {
            result.rejectValue("username", "");
            return "titles.company.fyp";
        }
        String url = aesEncodedTokenService.build(username, companyEntity.getGuid());

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("company", companyEntity);
        parameters.put("fyp_url", url);
        emailService.sendEmail("", companyEntity.getEmail().toArray(new String[companyEntity.getEmail().size()]), parameters);
        return "titles.company.fyp.success";
    }
}
