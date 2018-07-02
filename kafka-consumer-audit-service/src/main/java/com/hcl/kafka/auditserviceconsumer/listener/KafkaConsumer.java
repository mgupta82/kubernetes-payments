package com.hcl.kafka.auditserviceconsumer.listener;

import com.hcl.kafka.auditserviceconsumer.model.AuditResponse;
import com.hcl.kafka.auditserviceconsumer.repository.AuditRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	@Autowired
	private AuditRepository repository;	


    @KafkaListener(topics = "auditT2", group = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }


    @KafkaListener(topics = "auditT2", group = "group_audit",
            containerFactory = "auditKafkaListenerFactory")
    public void consumeJson(AuditResponse response) {
    	System.out.println("Value of service name and status: " + response.getService() + " --> " + response.getStatusCode() + " --->" + response.getStatusDesc());
        System.out.println("Consumed JSON Message: " + response);
        
        //This AuditResponse needs to be persisted in MongoDB. You can integrate that here.
        repository.insert(response);
    }
}
