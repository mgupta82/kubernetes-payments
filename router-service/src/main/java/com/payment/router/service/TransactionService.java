package com.payment.router.service;
import com.payment.router.model.Transaction;

public interface TransactionService {
	
	public Transaction insertPaymentRequest(iso.std.iso._20022.tech.xsd.pacs_008_001.Document request,String messageId,String transactionId,String requestxml);
	
	public Transaction updatePaymentRequest(Transaction transaction,String messageId);
	
	public Transaction findExistingRequest(String messageId,String transactionId);

}
