/**
 *
 */
package com.archer.livequote.email.template;

import com.archer.livequote.dao.EmailTemplateRepository;
import com.archer.livequote.db.domain.EmailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author Aaron Yang
 */
@Service
public class MongoTemplateManager extends AbstractTemplateManager {
    @Autowired
    private EmailTemplateRepository emailTemplateRepository;

    @Override
    protected List<EmailTemplate> loadTemplate() throws IOException {
        return emailTemplateRepository.findAll();
    }
}
