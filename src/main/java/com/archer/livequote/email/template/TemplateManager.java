package com.archer.livequote.email.template;

import com.archer.livequote.db.domain.EmailTemplate;

import java.util.Collection;

/**
 * @author Aaron Yang
 */
public interface TemplateManager {
    EmailTemplate getTemplatesByGuid(String guid);

    /**
     * @return
     */
    Collection<EmailTemplate> getEmailTemplates();
}
