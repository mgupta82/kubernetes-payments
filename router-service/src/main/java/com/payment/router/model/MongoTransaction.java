package com.payment.router.model;

import java.util.UUID;

import org.springframework.context.annotation.Profile;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MongoTransaction implements Transaction {
	
	@Id
	private UUID id;
	
	private String messageId;
	
	private String transactionId;
	
	private String status;
	
	private String requestxml;
	
	private String responsexml;
	
	public MongoTransaction() {
		super();
	}

	public MongoTransaction(UUID id,String messageId, String transactionId, String status, String requestxml) {
		super();
		this.id = id;
		this.messageId = messageId;
		this.transactionId = transactionId;
		this.status = status;
		this.requestxml = requestxml;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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

	@Override
	public String toString() {
		return "MongoTransaction [id=" + id + ", messageId=" + messageId + ", transactionId=" + transactionId
				+ ", status=" + status + "]";
	}

}
