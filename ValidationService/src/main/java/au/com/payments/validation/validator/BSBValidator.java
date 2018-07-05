package au.com.payments.validation.validator;

import org.apache.commons.validator.routines.RegexValidator;

public class BSBValidator extends RegexValidator {

	public BSBValidator() {
		super("^[AA]{2}[A-Za-z0-9]*$");
	}

}
