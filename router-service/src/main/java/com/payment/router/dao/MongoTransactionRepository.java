package com.payment.router.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.payment.router.model.MongoTransaction;

@Repository
@Profile("mongo")
public interface MongoTransactionRepository extends MongoRepository<MongoTransaction, Integer> {
	
	public MongoTransaction findByMessageId(String messageId);
	
}
