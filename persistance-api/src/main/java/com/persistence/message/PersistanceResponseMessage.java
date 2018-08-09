package com.persistence.message;

public class PersistanceResponseMessage {

	private String reasonCode;
	private String reasonDesc;
	private String status;
	
	public PersistanceResponseMessage() {
		super();
	}
	

	public PersistanceResponseMessage(String msgId, String statusCode, String statusMessage) {
		super();
		this.reasonCode = msgId;
		this.reasonDesc = statusCode;
		this.status = statusMessage;
	}


	public String getReasonCode() {
		return reasonCode;
	}


	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}


	public String getReasonDesc() {
		return reasonDesc;
	}


	public void setReasonDesc(String reasonDesc) {
		this.reasonDesc = reasonDesc;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	

}
