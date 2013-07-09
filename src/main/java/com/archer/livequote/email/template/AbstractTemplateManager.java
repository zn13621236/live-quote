package com.archer.livequote.email.template;

import com.archer.livequote.db.domain.EmailTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ayang
 */
public abstract class AbstractTemplateManager implements TemplateManager, InitializingBean {
    private final Map<String, EmailTemplate> templateMap = new HashMap<String, EmailTemplate>();
    private List<EmailTemplate> emailTemplates;

    @Override
    public EmailTemplate getTemplatesById(String id) {
        return templateMap.get(id);
    }

    @Override
    public Collection<EmailTemplate> getEmailTemplates() {
        return emailTemplates;
    }

    protected abstract List<EmailTemplate> loadTemplate() throws IOException;

    @Override
    public void afterPropertiesSet() throws Exception {
        emailTemplates = loadTemplate();
        if (!CollectionUtils.isEmpty(emailTemplates)) {
            for (EmailTemplate emailTemplate : emailTemplates) {
                templateMap.put(emailTemplate.getId(), emailTemplate);
            }
        }
    }
}
