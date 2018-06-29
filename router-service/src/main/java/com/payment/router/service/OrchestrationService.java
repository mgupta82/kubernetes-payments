package com.payment.router.service;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.utils.UUIDs;
import com.payment.router.dao.PaymentTransactionRepository;
import com.payment.router.model.PaymentTransaction;

import iso.std.iso._20022.tech.xsd.pacs_002_001.Document;

@Service
public class OrchestrationService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrchestrationService.class);
	
	@Autowired
	CoreService coreService;	
	
	@Autowired
	PaymentTransactionRepository repository;
	
	public void process(iso.std.iso._20022.tech.xsd.pacs_008_001.Document input,String messageId) throws Exception {
		
		//TODO : Step 1: Call Transformation Service
		
		//TODO : Step 2: Audit Service for Transformation
		
		//TODO : Step 3: Call Persistence Service
		
		//TODO : Step 4: Audit Service for Persistence
		
		//TODO : Step 5: Call Validation Service
		
		//TODO : Step 6: Audit Service Validation 
		
		//TODO : Step 7: Call Core Service

		//TODO : Step 8: Audit Service for Core
		
	}
	
	public Document sendNack(iso.std.iso._20022.tech.xsd.pacs_008_001.Document input,String messageId,ErrorCode errorCode) {
		logger.info("Sending NACK for : "+messageId);
		try {
			Document document = coreService.processFailure(input, messageId, errorCode);
			logger.info("NACK sent successfully  : "+messageId);
			return document;
		}catch(Exception ex) {
			logger.error("Severe Error : Failed to Send NACK . Please reconcile manually : "+ex);
		}
		return null;
	}
	
	public Document sendAck(iso.std.iso._20022.tech.xsd.pacs_008_001.Document input,String messageId) {
		logger.info("Sending ACK for : "+messageId);
		try {
			Document document = coreService.process(input, messageId);
			logger.info("ACK sent successfully  : "+messageId);
			return document;
		}catch(Exception ex) {
			logger.error("Severe Error : Failed to Send ACK. Please reconcile manually : "+ex);
		}
		return null;
	}
	
	public void playbackResponse(PaymentTransaction paymentTransaction,String messageId) {
		logger.info("Playing back response : "+messageId);
		try {
			coreService.playbackResponse(paymentTransaction);
			logger.info("Response played back for  : "+messageId);
		}catch(Exception ex) {
			logger.error("Severe Error : Failed to play back response : "+ex);
		}		
	}
	
	private String extractTransactionId(iso.std.iso._20022.tech.xsd.pacs_008_001.Document input) {
		String transactionId = "";
		if(input.getFIToFICstmrCdtTrf().getCdtTrfTxInf()!=null 
				&& input.getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0)!=null 
				&& input.getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0).getPmtId()!=null) {
			transactionId = input.getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0).getPmtId().getTxId();
		}		
		return transactionId;
	}
	
	private ByteBuffer stringToByte(String input)  {
		return ByteBuffer.wrap(input.getBytes());
	}	
	
	public PaymentTransaction insertPaymentRequest(iso.std.iso._20022.tech.xsd.pacs_008_001.Document input,String messageId)  {
		logger.info("Inserting Payment Request  : "+messageId);
		PaymentTransaction paymentTransaction = repository.save(new PaymentTransaction(UUIDs.timeBased(), messageId,extractTransactionId(input) , "INIT",stringToByte("<request></request>")));
		logger.info("Payment Request Inserted Successfully  : "+messageId+ ":"+paymentTransaction.getId());
		return paymentTransaction;
	}
	
	public PaymentTransaction updatePaymentRequest(PaymentTransaction paymentTransaction,String messageId) {
		logger.info("Updating Payment Request  : "+messageId + ":"+paymentTransaction.getId());
		paymentTransaction = repository.save(paymentTransaction);
		logger.info("Payment Request updated Successfully  : "+messageId+ ":"+paymentTransaction.getId());
		return paymentTransaction;
	}	
	
	public PaymentTransaction findDuplicateRequest(iso.std.iso._20022.tech.xsd.pacs_008_001.Document input,String messageId) {
		logger.info("Checking duplicate request  : "+messageId);
		return repository.findExistingRequest(messageId, extractTransactionId(input));
	}

}
