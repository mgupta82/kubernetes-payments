package com.payment.router.service;

public enum ErrorCode {
	
	PERSISTENCE_ERROR("0001"),PARSING_ERROR("0002"),INVALID_BSB("0003"),INVALID_AMOUNT("0004"),DUPLICATE_REQUEST("0005"),GENERIC_ERROR("9999");
	
	private String reasonCode;
	
	

	private ErrorCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	
	

}
