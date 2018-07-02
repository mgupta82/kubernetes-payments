package com.payment.router.serviceresponse;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceResponse {

	private String status;
	private String reasonCode;
	private String reasonDesc;

	public ServiceResponse() {

	}

	public ServiceResponse(String status, String reasonCode, String reasonDesc) {
		super();
		this.status = status;
		this.reasonCode = reasonCode;
		this.reasonDesc = reasonDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

}
