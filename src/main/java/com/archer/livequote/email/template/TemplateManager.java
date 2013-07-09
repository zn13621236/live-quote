package com.archer.livequote.email.template;

import com.archer.livequote.db.domain.EmailTemplate;

import java.util.Collection;

/**
 * @author Aaron Yang
 */
public interface TemplateManager {
    EmailTemplate getTemplatesById(String id);

    /**
     * @return
     */
    Collection<EmailTemplate> getEmailTemplates();
}
