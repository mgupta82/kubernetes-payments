package com.payment.router.service;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.utils.UUIDs;
import com.payment.router.dao.PaymentTransactionRepository;
import com.payment.router.dao.TransactionRepository;
import com.payment.router.model.PaymentTransaction;

import iso.std.iso._20022.tech.xsd.pacs_002_001.Document;

@Service
public class OrchestrationService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrchestrationService.class);
	
	@Autowired
	CoreService coreService;	
	
	@Autowired
	PaymentTransactionRepository repository;
	
	@Autowired
	Marshaller marshaller;
	
	@Autowired
	Unmarshaller unmarshaller;		
	
	public void process(iso.std.iso._20022.tech.xsd.pacs_008_001.Document input) {
		
		//Extract Message ID
		String messageId = extractMessageId(input);
		if(messageId == null) {
			logger.error("Message Id missing in Request. Unable to process message");
			return;
		}
		
		//Check for duplicate request
		if(processIfDuplicateRequest(input,messageId)) {
			return;
		}
		
		PaymentTransaction paymentTransaction = null;
		try {
			//Save Request XML 
			paymentTransaction = insertPaymentRequest(input, messageId);
			
			//TODO : Step 1: Call Transformation Service
			
			//TODO : Step 2: Audit Service for Transformation
			
			//TODO : Step 3: Call Persistence Service
			
			//TODO : Step 4: Audit Service for Persistence
			
			//TODO : Step 5: Call Validation Service
			
			//TODO : Step 6: Audit Service Validation 
			
			//TODO : Step 7: Call Core Service

			//TODO : Step 8: Audit Service for Core
			
			//Send positive ACK
			sendAck(input, messageId,paymentTransaction);			
			logger.info("Message Processed Successfully :" + messageId);			
		}catch(Exception ex) {
        	logger.error("Failed to Process Message "+messageId, ex);
        	sendNack(input, messageId, ErrorCode.GENERIC_ERROR,paymentTransaction);		
		}
	}	
	
	
	private String byteToString(ByteBuffer input ) throws UnsupportedEncodingException {
		byte[] data = new byte[input.remaining()];
		return new String(input.get(data).array());
	}
	
	private ByteBuffer stringToByte(String input)  {
		return ByteBuffer.wrap(input.getBytes());
	}	
	
	/**
	 * Extract Message Id from the Request XML
	 * @param input
	 * @return
	 */
	private String extractMessageId(iso.std.iso._20022.tech.xsd.pacs_008_001.Document input) {
		if(input!=null 
				&& input.getFIToFICstmrCdtTrf()!=null 
				&& input.getFIToFICstmrCdtTrf().getGrpHdr()!=null) {
			return input.getFIToFICstmrCdtTrf().getGrpHdr().getMsgId();
		}
		return null;
		
	}
	
	/**
	 * Extract Message Id from the Request XML
	 * @param input
	 * @return
	 */
	private String extractTransactionId(iso.std.iso._20022.tech.xsd.pacs_008_001.Document input) {
		String transactionId = "";
		if(input.getFIToFICstmrCdtTrf().getCdtTrfTxInf()!=null 
				&& input.getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0)!=null 
				&& input.getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0).getPmtId()!=null) {
			transactionId = input.getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0).getPmtId().getTxId();
		}		
		return transactionId;
	}	
	
	/**
	 * 
	 * @param input
	 * @param messageId
	 * @return
	 */
	public boolean processIfDuplicateRequest(iso.std.iso._20022.tech.xsd.pacs_008_001.Document input,String messageId) {
		logger.info("Checking duplicate request  : "+messageId);
		try {
			PaymentTransaction paymentTransaction = repository.findExistingRequest(messageId, extractTransactionId(input));
			if(paymentTransaction != null) {
	    		logger.info("Duplicate Request Received "+messageId);
	    		if(paymentTransaction.getStatus().equals("ACK") 
	    				|| paymentTransaction.getStatus().equals("NACK")) {
	    			logger.info("responsexml: "+messageId + ":"+byteToString(paymentTransaction.getResponsexml()));
	    			playbackResponse(paymentTransaction, messageId);
	    		}
	    		return true;			
			}					
		}catch(Exception ex) {
			logger.error("Failed to check duplicate message. Unable to proceed...",ex);
			return true;
		}
		return false;
	}	
	

	/**
	 * 
	 * @param input
	 * @param messageId
	 * @param errorCode
	 * @param paymentTransaction
	 */
	public void sendNack(iso.std.iso._20022.tech.xsd.pacs_008_001.Document input,String messageId,ErrorCode errorCode,PaymentTransaction paymentTransaction) {
		logger.info("Sending NACK for : "+messageId);
		try {
			Document document = coreService.processFailure(input, messageId, errorCode);
			logger.info("NACK sent successfully  : "+messageId);
        	if(paymentTransaction!=null) {
        		paymentTransaction.setStatus("NACK");
        		paymentTransaction.setResponsexml(stringToByte("<nack></nack>"));
        		updatePaymentRequest(paymentTransaction, messageId);
        	}			
		}catch(Exception ex) {
			logger.error("Severe Error : Failed to Send NACK . Please reconcile manually : "+ex);
		}

	}
	
	/**
	 * 
	 * @param input
	 * @param messageId
	 * @param paymentTransaction
	 */
	public void sendAck(iso.std.iso._20022.tech.xsd.pacs_008_001.Document input,String messageId,PaymentTransaction paymentTransaction) {
		logger.info("Sending ACK for : "+messageId);
		try {
			Document document = coreService.process(input, messageId);
			logger.info("ACK sent successfully  : "+messageId);
			paymentTransaction.setStatus("ACK");
			paymentTransaction.setResponsexml(stringToByte("<ack></ack>"));
			updatePaymentRequest(paymentTransaction, messageId);			
		}catch(Exception ex) {
			logger.error("Severe Error : Failed to Send ACK. Please reconcile manually : "+ex);
		}
	}
	
	/**
	 * 
	 * @param paymentTransaction
	 * @param messageId
	 */
	public void playbackResponse(PaymentTransaction paymentTransaction,String messageId) {
		logger.info("Playing back response : "+messageId);
		try {
			coreService.playbackResponse(paymentTransaction);
			logger.info("Response played back for  : "+messageId);
		}catch(Exception ex) {
			logger.error("Severe Error : Failed to play back response : "+ex);
		}		
	}
	
	/**
	 * 
	 * @param input
	 * @param messageId
	 * @return
	 */
	public PaymentTransaction insertPaymentRequest(iso.std.iso._20022.tech.xsd.pacs_008_001.Document input,String messageId)  {
		logger.info("Inserting Payment Request  : "+messageId);
		PaymentTransaction paymentTransaction = repository.save(new PaymentTransaction(UUIDs.timeBased(), messageId,extractTransactionId(input) , "INIT",stringToByte("<request></request>")));
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
	


}
