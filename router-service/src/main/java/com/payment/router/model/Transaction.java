package com.payment.router.model;

import java.util.UUID;

public interface Transaction {
	
	public UUID getId() ;

	public void setId(UUID id);

	public String getMessageId();

	public void setMessageId(String messageId);

	public String getTransactionId();

	public void setTransactionId(String transactionId);

	public String getStatus();

	public void setStatus(String status);

	public String getRequestxml();

	public void setRequestxml(String requestxml);

	public String getResponsexml();

	public void setResponsexml(String responsexml);

}
