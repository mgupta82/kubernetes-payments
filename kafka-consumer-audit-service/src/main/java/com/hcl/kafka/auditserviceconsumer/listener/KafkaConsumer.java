package com.hcl.kafka.auditserviceconsumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.hcl.kafka.auditserviceconsumer.repository.AuditRepository;
import com.payment.router.model.AuditMessage;

import net.bull.javamelody.MonitoredWithSpring;

@Service
public class KafkaConsumer {
	
	@Autowired
	private AuditRepository repository;	

    @KafkaListener(topics = "${audit.kafka.topic}")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }


    @MonitoredWithSpring
    @KafkaListener(topics = "${audit.kafka.topic}",
            containerFactory = "auditKafkaListenerFactory")
    public void consumeJson(AuditMessage response) {
    	System.out.println("Value of service name and status: " + response.getService() + " --> " + response.getStatusCode() + " --->" + response.getStatusDesc());
        System.out.println("Consumed JSON Message: " + response);
        
        //This AuditResponse needs to be persisted in MongoDB. You can integrate that here.
        repository.insert(response);
    }
}
