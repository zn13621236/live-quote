/**
 *
 */
package com.archer.livequote.email.service;

import com.archer.livequote.email.domain.Template;
import com.archer.livequote.email.template.TemplateManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Locale;
import java.util.Map;

/**
 * @author Aaron Yang
 */
public abstract class AbstractEmailService implements EmailService {
    private static Logger logger = LoggerFactory.getLogger(SpringEmailService.class);
    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private TemplateManager templateManager;

    public void sendEmail(String template, String[] to, Map<String, Object> parameters) {
        sendEmail(templateManager.getTemplatesById(template), to, parameters, null);
    }

    @Override
    public void sendEmail(String template, String[] to, Map<String, Object> parameters, Locale locale) {
        Assert.notNull(template, "Email template id must be not null.");
        logger.info("The email template is {}.", template);
        sendEmail(templateManager.getTemplatesById(template), to, parameters, locale);
    }

    protected void sendEmail(Template template, String[] to, Map<String, Object> parameters, Locale locale) {
        Assert.notNull(template, "Email template must be not null.");
        String content = templateEngine.processTemplateIntoString(template, parameters, locale);
        if (logger.isDebugEnabled()) {
            logger.debug(content);
        }

        doSend(template.getFrom(), template.getSubject(), content, to, template.isHtml());
    }

    @Override
    public void sendEmail(final String from, final String subject, final String content, final String[] to, boolean html) {
        doSend(from, subject, content, to, html);
    }

    abstract protected void doSend(final String from, final String subject, final String content, final String[] to, final boolean html);
}
