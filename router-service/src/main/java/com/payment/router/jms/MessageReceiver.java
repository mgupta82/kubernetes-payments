package com.payment.router.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import iso.std.iso._20022.tech.xsd.pacs_008_001.Document;

@Component
public class MessageReceiver {
	
	@JmsListener(destination = "test.queue", containerFactory = "myFactory")
    public void receiveMessage(Document document) {
        System.out.println("Received <" + document + ">");
    }

}
