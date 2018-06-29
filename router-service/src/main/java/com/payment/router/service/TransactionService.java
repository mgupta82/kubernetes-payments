package com.payment.router.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.router.dao.TransactionRepository;
import com.payment.router.model.Transaction;

@Service
public class TransactionService {
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);
	
	@Autowired
	TransactionRepository transactionRepository;
	
	public Transaction insertPaymentRequest(iso.std.iso._20022.tech.xsd.pacs_008_001.Document request,String messageId,String transactionId)  {
		logger.info("Inserting Transaction Request  : "+messageId);
		Transaction transaction = transactionRepository.save(new Transaction(messageId, transactionId, "INIT", "<request></request>"));
		logger.info("Transaction Inserted Successfully  : "+messageId+ ":"+transaction.getId());
		return transaction;
	}
	
	public Transaction updatePaymentRequest(Transaction transaction,String messageId) {
		logger.info("Updating Transaction Request  : "+messageId + ":"+transaction.getId());
		transaction = transactionRepository.save(transaction);
		logger.info("Transaction Request updated Successfully  : "+messageId+ ":"+transaction.getId());
		return transaction;		
		
	}

	public Transaction findExistingRequest(String messageId,String transactionId)  {
		return transactionRepository.findByMessageId(messageId);
	}

}
