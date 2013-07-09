/**
 *
 */
package com.archer.livequote.email.service;

import com.archer.livequote.email.domain.Template;

import java.util.Locale;
import java.util.Map;

/**
 * @author Aaron Yang
 */
public interface TemplateEngine {
    /**
     * @param emailTemplate
     * @param model
     * @return
     */
    public String processTemplateIntoString(Template emailTemplate, Map<String, Object> model, Locale locale);
}
