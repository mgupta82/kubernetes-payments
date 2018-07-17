package com.hcl.kafka.auditserviceproducer.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.router.model.AuditMessage;

@RestController
@RequestMapping("audit")
public class AuditMessageResource {

    @Autowired
    private KafkaTemplate<String, AuditMessage> kafkaTemplate;

    private static final String TOPIC = "audit_test";

    @GetMapping("/producer/{serviceName}")
    public String post(@PathVariable("serviceName") final String serviceName) {

        kafkaTemplate.send(TOPIC, new AuditMessage("30000L", serviceName, "ABCD12", "Error code for " + serviceName, "12:00:18 PM"));

        return "Audit Message sent successfully";
    }
}
