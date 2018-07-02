package au.com.payments.validation.service;

import au.com.payments.validation.request.PACS008Request;
import au.com.payments.validation.response.ValidationResponse;

public interface ValidationService {
	
	ValidationResponse validateMessage(PACS008Request message);

}
