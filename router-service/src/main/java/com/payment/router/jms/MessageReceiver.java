package com.payment.router.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.payment.router.model.PaymentTransaction;
import com.payment.router.service.CoreService;
import com.payment.router.service.ErrorCode;
import com.payment.router.service.OrchestrationService;
import iso.std.iso._20022.tech.xsd.pacs_008_001.Document;

/**
 * Class for receiving message from the request queue
 *
 */
@Component
public class MessageReceiver {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageReceiver.class);
	
	@Autowired
	OrchestrationService service;
	
	@JmsListener(destination = "pacs.008.001.07.request.queue", containerFactory = "myFactory")
    public void receiveMessage(Document inputDocument) {
		if(inputDocument!=null 
				&& inputDocument.getFIToFICstmrCdtTrf()!=null 
				&& inputDocument.getFIToFICstmrCdtTrf().getGrpHdr()!=null) {
			String messageId = inputDocument.getFIToFICstmrCdtTrf().getGrpHdr().getMsgId();
			logger.info("Message Received :" + messageId);
			
			//Check Duplicate Message
			try {
				PaymentTransaction paymentTransaction = service.findDuplicateRequest(inputDocument, messageId);
				if(paymentTransaction!=null) {
	        		logger.info("Duplicate Request Received "+messageId);
	        		if(paymentTransaction.getStatus().equals("ACK") 
	        				|| paymentTransaction.getStatus().equals("NACK")) {
	        			service.playbackResponse(paymentTransaction, messageId);
	        		}
	        		return;
				}
			}catch(Exception ex) {
				logger.error("Failed to check duplicate message. Unable to proceed...",ex);
				return;
			}
			
			//Process message in Core
			PaymentTransaction paymentTransaction = null;
	        try {
        		paymentTransaction = service.insertPaymentRequest(inputDocument, messageId);
	        	service.process(inputDocument,messageId);
	        	logger.info("Message Processed Successfully :" + messageId);
	        	service.sendAck(inputDocument, messageId);
	        	paymentTransaction.setStatus("ACK");
	        	service.updatePaymentRequest(paymentTransaction, messageId);
	        }catch(Exception ex) {
	        	logger.error("Failed to Process Message "+messageId, ex);
	        	service.sendNack(inputDocument, messageId, ErrorCode.GENERIC_ERROR);
	        	if(paymentTransaction!=null) {
	        		paymentTransaction.setStatus("NACK");
	        		service.updatePaymentRequest(paymentTransaction, messageId);
	        	}
	        }
	        
		}else {
			logger.error("Message Id missing in Request. Unable to process message");
		}
        
    }

}
