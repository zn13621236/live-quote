package com.archer.livequote.email.template;

import com.archer.livequote.email.domain.Template;

import java.util.Collection;

/**
 * @author Aaron Yang
 */
public interface TemplateManager {
    Template getTemplatesById(String id);

    /**
     * @return
     */
    Collection<Template> getTemplates();
}
