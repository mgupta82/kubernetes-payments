package au.com.payments.validation.validator;

import org.apache.commons.validator.routines.RegexValidator;

public class BSBValidator extends RegexValidator {

	public BSBValidator() {
		super("^[01]{2}\\d{1}[-]\\d{3}$");
	}

}
