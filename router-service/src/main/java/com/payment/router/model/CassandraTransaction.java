package com.payment.router.model;

import java.nio.ByteBuffer;
import java.util.UUID;

import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Profile("cassandra")
public class CassandraTransaction implements Transaction {
	
	@PrimaryKey
	private UUID id;
	
	private String  messageId;
	
	private String transactionId;
	
	private String status;
	
	private ByteBuffer  requestxml;
	
	private ByteBuffer  responsexml;
	
	public CassandraTransaction() {
		
	}

	public CassandraTransaction(UUID id, String messageId, String transactionId, String status,String requestxml) {
		super();
		this.id = id;
		this.messageId = messageId;
		this.transactionId = transactionId;
		this.status = status;
		this.requestxml = stringToByte(requestxml);
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
		return byteToString(requestxml);
	}

	public void setRequestxml(String requestxml) {
		this.requestxml = stringToByte(requestxml);
	}

	public String getResponsexml() {
		return byteToString(responsexml);
	}

	public void setResponsexml(String responsexml) {
		this.responsexml = stringToByte(responsexml);
	}

	public void setRequestxml(ByteBuffer requestxml) {
		this.requestxml = requestxml;
	}

	public void setResponsexml(ByteBuffer responsexml) {
		this.responsexml = responsexml;
	}

	@Override
	public String toString() {
		return "PaymentTransaction [id=" + id + ", messageId=" + messageId + ", transactionId=" + transactionId
				+ ", status=" + status + "]";
	}
	
	private String byteToString(ByteBuffer request ) {
		try {
			byte[] data = new byte[request.remaining()];
			return new String(request.get(data).array());
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}	
	
	private ByteBuffer stringToByte(String input)  {
		return ByteBuffer.wrap(input.getBytes());
	}	

}
