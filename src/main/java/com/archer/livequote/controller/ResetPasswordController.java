package com.archer.livequote.controller;

import com.archer.livequote.db.domain.CompanyEntity;
import com.archer.livequote.fyp.domain.Token;
import com.archer.livequote.fyp.exception.InvalidTokenException;
import com.archer.livequote.fyp.service.AesEncodedTokenService;
import com.archer.livequote.model.CompanyForm;
import com.archer.livequote.service.CompanyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * @author: ayang
 */
@Controller
public class ResetPasswordController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private AesEncodedTokenService aesEncodedTokenService;

    @RequestMapping(method = RequestMethod.GET, value = "/password/reset")
    public String handleRequestForgotPassword(@RequestParam("t") String encodedToken, @RequestParam("h") String hash, BindingResult result) {
        if (StringUtils.isBlank(encodedToken) || StringUtils.isBlank(hash)) {
            result.reject("");
            return "titles.company.reset";
        }
        try {
            Token token = aesEncodedTokenService.verify(encodedToken, hash);
            CompanyEntity companyEntity = companyService.findByUserName(token.getUsername());
            if (companyEntity == null) {
                //Error out when company is deleted
                result.rejectValue("username", "");
                return "titles.company.reset";
            }
            if (!companyEntity.getGuid().equals(token.getGuid())) {
                //Error out, seems the token is hacked
                result.rejectValue("username", "");
                return "titles.company.reset";
            }
            //TODO build session object to access secured url
            return "";
        } catch (InvalidTokenException e) {
            //wrong token or hash
            result.reject("");
            return "titles.company.reset";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/secure/password")
    public String resetPassword(@Valid CompanyForm companyForm, BindingResult result) {
        if (result.hasErrors()) {
            return "titles.company.reset";
        }
        //TODO update password
        return "";

    }
}
