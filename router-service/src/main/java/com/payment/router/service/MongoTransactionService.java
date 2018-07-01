package com.payment.router.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.payment.router.dao.MongoTransactionRepository;
import com.payment.router.model.MongoTransaction;
import com.payment.router.model.Transaction;

@Service
public class MongoTransactionService implements TransactionService {
	
	private static final Logger logger = LoggerFactory.getLogger(MongoTransactionService.class);
	
	@Autowired
	MongoTransactionRepository repository;
	
	public Transaction insertPaymentRequest(iso.std.iso._20022.tech.xsd.pacs_008_001.Document request,String messageId,String transactionId,String requestxml)  {
		logger.info("Inserting Transaction Request  : "+messageId);
		MongoTransaction transaction = repository.save(new MongoTransaction(UUID.randomUUID(),messageId, transactionId, "INIT", requestxml));
		logger.info("Transaction Inserted Successfully  : "+messageId+ ":"+transaction.getId());
		return transaction;
	}
	
	public Transaction updatePaymentRequest(Transaction transaction,String messageId) {
		logger.info("Updating Transaction Request  : "+messageId + ":"+transaction.getId());
		transaction = repository.save((MongoTransaction)transaction);
		logger.info("Transaction Request updated Successfully  : "+messageId+ ":"+transaction.getId());
		return transaction;		
		
	}

	public Transaction findExistingRequest(String messageId,String transactionId)  {
		return repository.findByMessageId(messageId);
	}

}
