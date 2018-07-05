package au.com.payments.validation.controller;

import static au.com.payments.validation.constants.Constants.FAILURE_MESSAGE;
import static au.com.payments.validation.constants.Constants.INVALID_TXN_AMT_ERROR_CODE;
import static au.com.payments.validation.constants.Constants.INVALID_TXN_AMT_ERROR_MESSAGE;
import static au.com.payments.validation.constants.Constants.PARSING_ERROR_CODE;
import static au.com.payments.validation.constants.Constants.PARSING_ERROR_MESSAGE;
import static au.com.payments.validation.constants.Constants.SUCC_CODE;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.payments.validation.request.PACS008Request;
import au.com.payments.validation.response.ValidationResponse;
import au.com.payments.validation.service.ValidationService;

/**
 * Validation Controller
 * 
 * @author
 *
 */
@RestController
@RequestMapping("/pacs")
public class ValidationController {

	@Autowired
	ValidationService validationService;

	@PostMapping("/validate")
	public ResponseEntity<ValidationResponse> validate(@RequestBody PACS008Request message) {
		if (null != message) {
			ValidationResponse response = validationService.validateMessage(message);
			if (null != response && StringUtils.equals(SUCC_CODE, response.getReasonCode())) {
				return new ResponseEntity<ValidationResponse>(response, HttpStatus.OK);
			} else {
				return new ResponseEntity<ValidationResponse>(response, HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<ValidationResponse>(
					new ValidationResponse(FAILURE_MESSAGE, PARSING_ERROR_CODE, PARSING_ERROR_MESSAGE),
					HttpStatus.BAD_REQUEST);
		}
	}

	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<ValidationResponse> formatException(final NumberFormatException e) {
		return new ResponseEntity<ValidationResponse>(
				new ValidationResponse(FAILURE_MESSAGE, INVALID_TXN_AMT_ERROR_CODE, INVALID_TXN_AMT_ERROR_MESSAGE),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ValidationResponse> generalException(final Exception e) {
		return new ResponseEntity<ValidationResponse>(
				new ValidationResponse(FAILURE_MESSAGE, PARSING_ERROR_CODE, PARSING_ERROR_MESSAGE),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
