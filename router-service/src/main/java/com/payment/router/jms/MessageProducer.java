package com.payment.router.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import iso.std.iso._20022.tech.xsd.pacs_002_001.Document;

/**
 * Class for Sending Message in to Response Queue
 *
 */
@Component
public class MessageProducer {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageProducer.class);
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	public void send(Document document) {
		logger.info("Sending Message : "+ document.getFIToFIPmtStsRpt().getGrpHdr().getMsgId());
		this.jmsTemplate.convertAndSend("pacs.002.001.09.response.queue", document);	
		logger.info("Message Sent : "+ document.getFIToFIPmtStsRpt().getGrpHdr().getMsgId());
	}

}
