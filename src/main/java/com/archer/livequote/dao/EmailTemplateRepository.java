package com.archer.livequote.dao;

import com.archer.livequote.db.domain.EmailTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: ayang
 */
@Repository
public interface EmailTemplateRepository extends MongoRepository<EmailTemplate, String> {
}
