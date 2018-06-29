package com.payment.router.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Transaction {
	
	@Id
	private int id;
	
	private String messageId;
	
	private String transactionId;
	
	private String status;
	
	private String requestxml;
	
	private String responsexml;
	
	public Transaction() {
		super();
	}

	public Transaction(String messageId, String transactionId, String status, String requestxml) {
		super();
		this.messageId = messageId;
		this.transactionId = transactionId;
		this.status = status;
		this.requestxml = requestxml;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequestxml() {
		return requestxml;
	}

	public void setRequestxml(String requestxml) {
		this.requestxml = requestxml;
	}

	public String getResponsexml() {
		return responsexml;
	}

	public void setResponsexml(String responsexml) {
		this.responsexml = responsexml;
	}
	
	
	
	

}
