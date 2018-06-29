package com.payment.router.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.utils.UUIDs;
import com.payment.router.dao.CassandraTransactionRepository;
import com.payment.router.model.CassandraTransaction;
import com.payment.router.model.Transaction;

@Service
@Profile("cassandra")
public class CassandraTransactionService implements TransactionService {
	
	private static final Logger logger = LoggerFactory.getLogger(CassandraTransactionService.class);
	
	@Autowired
	CassandraTransactionRepository repository;

	/**
	 * 
	 * @param request
	 * @param messageId
	 * @return
	 */
	public Transaction insertPaymentRequest(iso.std.iso._20022.tech.xsd.pacs_008_001.Document request,String messageId,String transactionId,String requestxml)  {
		logger.info("Inserting Payment Request  : "+messageId);
		//TODO Save Actual request
		CassandraTransaction paymentTransaction = repository.save(new CassandraTransaction(UUIDs.timeBased(), messageId,transactionId , "INIT",requestxml));
		logger.info("Payment Request Inserted Successfully  : "+messageId+ ":"+paymentTransaction.getId());
		return paymentTransaction;
	}
	
	/**
	 * 
	 * @param paymentTransaction
	 * @param messageId
	 * @return
	 */
	public Transaction updatePaymentRequest(Transaction paymentTransaction,String messageId) {
		logger.info("Updating Payment Request  : "+messageId + ":"+paymentTransaction.getId());
		paymentTransaction = repository.save((CassandraTransaction)paymentTransaction);
		logger.info("Payment Request updated Successfully  : "+messageId+ ":"+paymentTransaction.getId());
		return paymentTransaction;
	}		
	
	/**
	 * 
	 * @param messageId
	 * @param transactionId
	 * @return
	 */
	public Transaction findExistingRequest(String messageId,String transactionId)  {
		return repository.findByMessageId(messageId);
	}

}
