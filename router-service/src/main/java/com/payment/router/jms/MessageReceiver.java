package com.payment.router.jms;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import com.payment.router.service.OrchestrationService;
import iso.std.iso._20022.tech.xsd.pacs_008_001.Document;
import org.springframework.oxm.XmlMappingException;

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
    public void receiveMessage(Document request) throws XmlMappingException, IOException {
		logger.info("Message Received :" + request);
		service.process(request);
    }
	
/*	@JmsListener(destination = "pacs.008.001.07.request.queue")
    public void receiveMessage(String requestxml) throws XmlMappingException, IOException {
		logger.info("Message Received :" + requestxml);
		service.process(requestxml);
    }*/
	

}
