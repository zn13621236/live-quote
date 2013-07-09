/**
 *
 */
package com.archer.livequote.email.service;

import com.archer.livequote.email.domain.Template;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.annotation.Resource;
import java.util.Locale;
import java.util.Map;

/**
 * @author Aaron Yang
 */
@Component
public class VelocityTemplateEngine implements TemplateEngine {
    private static Logger logger = LoggerFactory.getLogger(VelocityTemplateEngine.class);
    @Resource
    private VelocityEngine velocityEngine;

    @Override
    public String processTemplateIntoString(Template emailTemplate, Map<String, Object> model, Locale locale) {
        StringBuilder templateFileName = new StringBuilder("email/velocity/");
        templateFileName.append(emailTemplate.getTemplateFile());
        if (locale != null) {
            templateFileName.append("_").append(locale.toString());
        }
        templateFileName.append(".vm");
        logger.info("The template file name is {}.", templateFileName.toString());
        return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateFileName.toString(), "UTF-8", model);
    }
}
