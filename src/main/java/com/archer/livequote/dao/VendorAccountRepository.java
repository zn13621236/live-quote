package com.archer.livequote.dao;

import com.archer.livequote.db.domain.CompanyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: ayang
 */
@Repository
public interface VendorAccountRepository extends MongoRepository<CompanyEntity, String> {
    @Query("{ 'user_name' : ?0}")
    CompanyEntity findByUserName(final String userName);

    @Query("{ 'user_name' : ?0, 'password' : ?1 }")
    List<CompanyEntity> findByUserNameAndPasswordQuery(final String userName, final String password);
}
