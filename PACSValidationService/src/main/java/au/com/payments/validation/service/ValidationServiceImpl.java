package au.com.payments.validation.service;

import static au.com.payments.validation.constants.Constants.FAILURE_MESSAGE;
import static au.com.payments.validation.constants.Constants.INVALID_BSB_ERROR_CODE;
import static au.com.payments.validation.constants.Constants.INVALID_BSB_ERROR_MESSAGE;
import static au.com.payments.validation.constants.Constants.INVALID_TXN_AMT_ERROR_CODE;
import static au.com.payments.validation.constants.Constants.INVALID_TXN_AMT_ERROR_MESSAGE;
import static au.com.payments.validation.constants.Constants.MAX_TXN_AMOUNT;
import static au.com.payments.validation.constants.Constants.MIN_TXN_AMOUNT;
import static au.com.payments.validation.constants.Constants.SUCC_CODE;
import static au.com.payments.validation.constants.Constants.SUCC_DESC;
import static au.com.payments.validation.constants.Constants.SUCC_MESSAGE;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import au.com.payments.validation.request.PACS008Request;
import au.com.payments.validation.response.ValidationResponse;
import au.com.payments.validation.validator.BSBValidator;
import au.com.payments.validation.validator.TransactionAmtValidator;

@Service
public class ValidationServiceImpl implements ValidationService {

	@SuppressWarnings("static-access")
	@Override
	public ValidationResponse validateMessage(PACS008Request message) {
		String bsb = readBSB(message);
		Double trnAmt = readTransactionAmt(message);
		BSBValidator validator = new BSBValidator();
		TransactionAmtValidator tranValidator = new TransactionAmtValidator();
		if (StringUtils.isBlank(bsb) || !validator.isValid(bsb)) {
			return new ValidationResponse(FAILURE_MESSAGE, INVALID_BSB_ERROR_CODE, INVALID_BSB_ERROR_MESSAGE);
		}

		if (trnAmt == null || !tranValidator.isInRange(trnAmt, MIN_TXN_AMOUNT, MAX_TXN_AMOUNT)) {
			return new ValidationResponse(FAILURE_MESSAGE, INVALID_TXN_AMT_ERROR_CODE, INVALID_TXN_AMT_ERROR_MESSAGE);
		}

		return new ValidationResponse(SUCC_MESSAGE, SUCC_CODE, SUCC_DESC);
	}

	private String readBSB(PACS008Request message) {
		if (message.getDocument() != null && message.getDocument().getFIToFICstmrCdtTrf() != null
				&& message.getDocument().getFIToFICstmrCdtTrf().getGrpHdr() != null
				&& message.getDocument().getFIToFICstmrCdtTrf().getGrpHdr().getInstgAgt() != null
				&& message.getDocument().getFIToFICstmrCdtTrf().getGrpHdr().getInstgAgt().getFinInstnId() != null
				&& message.getDocument().getFIToFICstmrCdtTrf().getGrpHdr().getInstgAgt().getFinInstnId()
						.getBICFI() != null) {
			return message.getDocument().getFIToFICstmrCdtTrf().getGrpHdr().getInstgAgt().getFinInstnId().getBICFI();
		}
		return null;
	}

	private Double readTransactionAmt(PACS008Request message) {
		if (message.getDocument() != null && message.getDocument().getFIToFICstmrCdtTrf() != null
				&& message.getDocument().getFIToFICstmrCdtTrf().getCdtTrfTxInf() != null
				&& message.getDocument().getFIToFICstmrCdtTrf().getCdtTrfTxInf().getIntrBkSttlmAmt() != null
				&& message.getDocument().getFIToFICstmrCdtTrf().getCdtTrfTxInf().getIntrBkSttlmAmt()
						.getAmount() != null) {
			return Double.parseDouble(
					message.getDocument().getFIToFICstmrCdtTrf().getCdtTrfTxInf().getIntrBkSttlmAmt().getAmount());
		}
		return null;
	}

}
