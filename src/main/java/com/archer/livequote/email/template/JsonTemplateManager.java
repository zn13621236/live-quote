/**
 *
 */
package com.archer.livequote.email.template;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.archer.livequote.db.domain.EmailTemplate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Aaron Yang
 */
@Repository(value="jsonTemplateManager")
public class JsonTemplateManager extends AbstractTemplateManager {
    @Value("classpath:email/templates.json")
    private Resource resource;

    @Override
    protected List<EmailTemplate> loadTemplate() throws IOException {
        return new ObjectMapper().readValue(resource.getInputStream(), new TypeReference<List<EmailTemplate>>() {
        });
    }

}
