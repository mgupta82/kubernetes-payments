package com.payment.router.model;

public class AuditMessage {

	private String messageId;
	private String service;
	private String statusCode;
	private String statusDesc;
	private String timestamp;


	public AuditMessage(String messageId, String service, String statusCode, String statusDesc, String timestamp) {
		super();
		this.messageId = messageId;
		this.service = service;
		this.statusCode = statusCode;
		this.statusDesc = statusDesc;
		this.timestamp = timestamp;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

}
