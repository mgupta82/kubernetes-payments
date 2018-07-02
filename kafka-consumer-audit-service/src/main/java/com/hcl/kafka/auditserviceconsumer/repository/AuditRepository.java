package com.hcl.kafka.auditserviceconsumer.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hcl.kafka.auditserviceconsumer.model.AuditResponse;

public interface AuditRepository extends MongoRepository<AuditResponse, String> {

    public List<AuditResponse> findByService(String Service);
    public List<AuditResponse> findByStatusCode(String statusCode);

}
