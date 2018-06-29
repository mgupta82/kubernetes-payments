package com.payment.router.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.payment.router.model.Transaction;


@Service
public class OrchestrationService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrchestrationService.class);
	
	@Autowired
	ResponseService responseService;	
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	MarshallingService marshallingService;
	
	public void process(String requestxml) {
		iso.std.iso._20022.tech.xsd.pacs_008_001.Document request = parseXml(requestxml);
		if(request!=null) {
			process(request,requestxml);
		}
	}
	
	public void process(iso.std.iso._20022.tech.xsd.pacs_008_001.Document request) {
		String requestxml = parseObject(request);
		if(requestxml!=null) {
			process(request,requestxml);
		}
		
	}
	
	public void process(iso.std.iso._20022.tech.xsd.pacs_008_001.Document request,String requestXml) {
		
		//Extract Message ID
		String messageId = extractMessageId(request);
		if(messageId == null) {
			logger.error("Message Id missing in Request. Unable to process message");
			return;
		}
		
		//Check for duplicate request
		if(processIfDuplicateRequest(request,messageId)) {
			return;
		}
		
		Transaction transaction = null;
		try {
			//Save Request XML 
			transaction = transactionService.insertPaymentRequest(request, messageId,extractTransactionId(request),requestXml);
			
			//TODO : Step 1: Call Transformation Service
			
			//TODO : Step 2: Audit Service for Transformation
			
			//TODO : Step 3: Call Persistence Service
			
			//TODO : Step 4: Audit Service for Persistence
			
			//TODO : Step 5: Call Validation Service
			
			//TODO : Step 6: Audit Service Validation 
			
			//TODO : Step 7: Call Core Service

			//TODO : Step 8: Audit Service for Core
			
			//Send positive ACK
			responseService.sendAck(request, messageId,transaction);			
			logger.info("Message Processed Successfully :" + messageId);			
		}catch(Exception ex) {
        	logger.error("Failed to Process Message "+messageId, ex);
        	responseService.sendNack(request, messageId, ErrorCode.GENERIC_ERROR,transaction);		
		}
	}
	
	private iso.std.iso._20022.tech.xsd.pacs_008_001.Document parseXml(String requestxml) {
		try {
			iso.std.iso._20022.tech.xsd.pacs_008_001.Document request = marshallingService.unmarshallXml(requestxml);
			logger.info("XML parsed Successfully " + request);
			return request;
		} catch (Exception e) {
			logger.error("Invalid XML format. Unable to process message ", e);
		}
		return null;
	}
	
	private String parseObject(iso.std.iso._20022.tech.xsd.pacs_008_001.Document request) {
		try {
			String requestXml = marshallingService.marshallXml(request);
			logger.info("Object parsed Successfully " + request);
			return requestXml;
		} catch (Exception e) {
			logger.error("Invalid Object format. Unable to process message ", e);
		}
		return null;
	}	
	
	/**
	 * Extract Message Id from the Request XML
	 * @param request
	 * @return
	 */
	private String extractMessageId(iso.std.iso._20022.tech.xsd.pacs_008_001.Document request) {
		if(request!=null 
				&& request.getFIToFICstmrCdtTrf()!=null 
				&& request.getFIToFICstmrCdtTrf().getGrpHdr()!=null) {
			return request.getFIToFICstmrCdtTrf().getGrpHdr().getMsgId();
		}
		return null;
		
	}
	
	/**
	 * Extract Message Id from the Request XML
	 * @param request
	 * @return
	 */
	private String extractTransactionId(iso.std.iso._20022.tech.xsd.pacs_008_001.Document request) {
		String transactionId = "";
		if(request.getFIToFICstmrCdtTrf().getCdtTrfTxInf()!=null 
				&& request.getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0)!=null 
				&& request.getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0).getPmtId()!=null) {
			transactionId = request.getFIToFICstmrCdtTrf().getCdtTrfTxInf().get(0).getPmtId().getTxId();
		}		
		return transactionId;
	}	
	
	/**
	 * 
	 * @param request
	 * @param messageId
	 * @return
	 */
	public boolean processIfDuplicateRequest(iso.std.iso._20022.tech.xsd.pacs_008_001.Document request,String messageId) {
		logger.info("Checking duplicate request  : "+messageId);
		try {
			Transaction transaction = transactionService.findExistingRequest(messageId, extractTransactionId(request));
			if(transaction != null) {
	    		logger.info("Duplicate Request Received "+messageId);
	    		if(transaction.getStatus().equals("ACK") 
	    				|| transaction.getStatus().equals("NACK")) {
	    			responseService.playbackResponse(transaction, messageId);
	    		}
	    		return true;
			}
		}catch(Exception ex) {
			logger.error("Failed to check duplicate message. Unable to proceed...",ex);
			return true;
		}
		return false;
	}	
}
