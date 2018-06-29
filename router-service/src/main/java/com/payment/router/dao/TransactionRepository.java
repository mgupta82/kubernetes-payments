package com.payment.router.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.payment.router.model.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, Integer> {
	
}
