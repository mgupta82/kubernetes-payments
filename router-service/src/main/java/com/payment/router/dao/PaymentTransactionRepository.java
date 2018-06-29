package com.payment.router.dao;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.payment.router.model.PaymentTransaction;

public interface PaymentTransactionRepository extends CrudRepository<PaymentTransaction, String> {
	
	@Query("select * from paymenttransaction where messageid=?0")
	PaymentTransaction findExistingRequest(String messageId,String transactionId);
	

}
