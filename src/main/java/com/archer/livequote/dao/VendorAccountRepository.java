package com.archer.livequote.dao;

import com.archer.livequote.db.domain.CompanyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: ayang
 */
@Repository
public interface VendorAccountRepository extends MongoRepository<CompanyEntity, String> {
    CompanyEntity findByUserName(final String userName);
}
