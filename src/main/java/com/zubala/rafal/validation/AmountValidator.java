package com.zubala.rafal.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AmountValidator implements ConstraintValidator<PaymentAmount, Double>  {

	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		return (value >= 0D);
	}
}
