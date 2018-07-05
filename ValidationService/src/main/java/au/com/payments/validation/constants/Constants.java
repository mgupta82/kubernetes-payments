package au.com.payments.validation.constants;

public final class Constants {

	public static final String SUCC_CODE = "0000";
	public static final String PARSING_ERROR_CODE = "0002";
	public static final String INVALID_BSB_ERROR_CODE = "0003";
	public static final String INVALID_TXN_AMT_ERROR_CODE = "0004";
	public static final String SUCC_MESSAGE = "SUCCESS";
	public static final String SUCC_DESC = "Successful Validation";
	public static final String FAILURE_MESSAGE = "FAILURE";
	public static final String PARSING_ERROR_MESSAGE = "JSON Parsing error";
	public static final String INVALID_BSB_ERROR_MESSAGE = "Invalid BSB";
	public static final String INVALID_TXN_AMT_ERROR_MESSAGE = "Invalid Transaction Amount";
	public static final double MIN_TXN_AMOUNT = 1d;
	public static final double MAX_TXN_AMOUNT = 999999999d;

}
