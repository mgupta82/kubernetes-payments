package com.payment.router.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
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
			//TODO : Save Request XML pay load in Database
			
	        try {
	        	service.process(inputDocument,messageId);
	        	logger.info("Message Processed Successfully :" + messageId);
	        	
	        	//TODO : Save Success Response XML pay load in Database
	        	
	        }catch(Exception ex) {
	        	logger.error("Failed to Process Message "+messageId, ex);
	        	//TODO : Send and Save Failure Response XML pay load in Database
	        }
		}else {
			logger.error("Message Id missing in Request. Unable to process message");
		}
        
        
    }

}
