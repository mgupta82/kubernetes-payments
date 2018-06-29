package com.payment.router.model;

import java.nio.ByteBuffer;
import java.sql.Blob;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class PaymentTransaction {
	
	@PrimaryKey
	private UUID id;
	
	private String  messageId;
	
	private String transactionId;
	
	private String status;
	
	private ByteBuffer  requestxml;
	
	private ByteBuffer  responsexml;
	
	public PaymentTransaction() {
		
	}

	public PaymentTransaction(UUID id, String messageId, String transactionId, String status,ByteBuffer requestxml) {
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
	
	public ByteBuffer getRequestxml() {
		return requestxml;
	}

	public void setRequestxml(ByteBuffer requestxml) {
		this.requestxml = requestxml;
	}

	public ByteBuffer getResponsexml() {
		return responsexml;
	}

	public void setResponsexml(ByteBuffer responsexml) {
		this.responsexml = responsexml;
	}

	@Override
	public String toString() {
		return "PaymentTransaction [id=" + id + ", messageId=" + messageId + ", transactionId=" + transactionId
				+ ", status=" + status + "]";
	}

}
