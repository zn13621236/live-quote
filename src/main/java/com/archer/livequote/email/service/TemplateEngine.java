/**
 *
 */
package com.archer.livequote.email.service;

import com.archer.livequote.db.domain.EmailTemplate;

import java.util.Locale;
import java.util.Map;

/**
 * @author Aaron Yang
 */
public interface TemplateEngine {
    /**
     * @param emailEmailTemplate
     * @param model
     * @return
     */
    public String processTemplateIntoString(EmailTemplate emailEmailTemplate, Map<String, Object> model, Locale locale);
}
