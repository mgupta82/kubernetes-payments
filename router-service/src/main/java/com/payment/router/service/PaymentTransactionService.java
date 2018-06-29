package com.payment.router.service;
import java.nio.ByteBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.utils.UUIDs;
import com.payment.router.dao.PaymentTransactionRepository;
import com.payment.router.model.PaymentTransaction;

@Service
public class PaymentTransactionService {
	
	private static final Logger logger = LoggerFactory.getLogger(PaymentTransactionService.class);
	
	@Autowired
	PaymentTransactionRepository repository;
	
	private ByteBuffer stringToByte(String input)  {
		return ByteBuffer.wrap(input.getBytes());
	}		
	
	/**
	 * 
	 * @param request
	 * @param messageId
	 * @return
	 */
	public PaymentTransaction insertPaymentRequest(iso.std.iso._20022.tech.xsd.pacs_008_001.Document request,String messageId,String transactionId)  {
		logger.info("Inserting Payment Request  : "+messageId);
		//TODO Save Actual request
		PaymentTransaction paymentTransaction = repository.save(new PaymentTransaction(UUIDs.timeBased(), messageId,transactionId , "INIT",stringToByte("<request></request>")));
		logger.info("Payment Request Inserted Successfully  : "+messageId+ ":"+paymentTransaction.getId());
		return paymentTransaction;
	}
	
	/**
	 * 
	 * @param paymentTransaction
	 * @param messageId
	 * @return
	 */
	public PaymentTransaction updatePaymentRequest(PaymentTransaction paymentTransaction,String messageId) {
		logger.info("Updating Payment Request  : "+messageId + ":"+paymentTransaction.getId());
		paymentTransaction = repository.save(paymentTransaction);
		logger.info("Payment Request updated Successfully  : "+messageId+ ":"+paymentTransaction.getId());
		return paymentTransaction;
	}		
	
	/**
	 * 
	 * @param messageId
	 * @param transactionId
	 * @return
	 */
	public PaymentTransaction findExistingRequest(String messageId,String transactionId)  {
		return repository.findExistingRequest(messageId, transactionId);
	}

}
