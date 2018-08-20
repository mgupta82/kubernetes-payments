package com.payment.router.jms;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.support.JmsMessageHeaderAccessor;
import org.springframework.oxm.XmlMappingException;
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
	
	@JmsListener(destination = "pacs.008.001.07.request.queue?consumer.prefetchSize=5", containerFactory = "myFactory",concurrency="10-100")
    public void receiveMessage(Document request,JmsMessageHeaderAccessor jmsMessageHeaderAccessor) throws XmlMappingException, IOException {
		logger.info("Message Received :" + request);
		logger.info("Correlation ID in received message :" + jmsMessageHeaderAccessor.getCorrelationId());
		service.process(request,jmsMessageHeaderAccessor.getCorrelationId());
    }
	
/*	@JmsListener(destination = "pacs.008.001.07.request.queue")
    public void receiveMessage(String requestxml) throws XmlMappingException, IOException {
		logger.info("Message Received :" + requestxml);
		service.process(requestxml);
    }*/
	

}
