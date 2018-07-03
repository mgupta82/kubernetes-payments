package com.payment.router.util;

import java.io.IOException;
import java.util.Calendar;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment.router.model.AuditMessage;
import com.payment.router.serviceresponse.ServiceResponse;

public class OrchestrationUtils {
	
	public static AuditMessage convertResponseToAuditMessage(String response,String msgId,String service) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		AuditMessage message = null;
		ServiceResponse serviceResponse=null;
		if("Transformation".equals(service)) {		
			message = new AuditMessage(msgId, service, "0000", "Transformation Successful", Calendar.getInstance().getTime().toString());
		}
		else {
			serviceResponse=mapper.readValue(response,ServiceResponse.class);
			message = new AuditMessage(msgId, service, serviceResponse.getReasonCode(), serviceResponse.getReasonDesc(), Calendar.getInstance().getTime().toString());
		}
		return message;
	}

}
