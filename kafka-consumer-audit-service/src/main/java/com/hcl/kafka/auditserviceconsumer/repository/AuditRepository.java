package com.hcl.kafka.auditserviceconsumer.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.payment.router.model.AuditMessage;

public interface AuditRepository extends MongoRepository<AuditMessage, String> {

    public List<AuditMessage> findByService(String Service);
    public List<AuditMessage> findByStatusCode(String statusCode);

}
