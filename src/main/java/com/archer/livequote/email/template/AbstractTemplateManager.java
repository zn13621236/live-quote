package com.archer.livequote.email.template;

import com.archer.livequote.email.domain.Template;
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
    private final Map<String, Template> templateMap = new HashMap<String, Template>();
    private List<Template> templates;

    @Override
    public Template getTemplatesById(String id) {
        return templateMap.get(id);
    }

    @Override
    public Collection<Template> getTemplates() {
        return templates;
    }

    protected abstract List<Template> loadTemplate() throws IOException;

    @Override
    public void afterPropertiesSet() throws Exception {
        templates = loadTemplate();
        if (!CollectionUtils.isEmpty(templates)) {
            for (Template template : templates) {
                templateMap.put(template.getId(), template);
            }
        }
    }
}
