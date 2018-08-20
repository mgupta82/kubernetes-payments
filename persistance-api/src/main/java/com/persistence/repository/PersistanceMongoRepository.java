package com.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.persistence.entity.PacsMessage;

@RepositoryRestResource

public interface PersistanceMongoRepository extends MongoRepository<PacsMessage, String> {

}
