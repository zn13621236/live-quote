/**
 *
 */
package com.archer.livequote.email.template;

import com.archer.livequote.db.domain.EmailTemplate;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * @author Aaron Yang
 */
@Repository
public class JsonTemplateManager extends AbstractTemplateManager {
    @Value("classpath:email/templates.json")
    private Resource resource;

    @Override
    protected List<EmailTemplate> loadTemplate() throws IOException {
        return new ObjectMapper().readValue(resource.getInputStream(), new TypeReference<List<EmailTemplate>>() {
        });
    }

}
