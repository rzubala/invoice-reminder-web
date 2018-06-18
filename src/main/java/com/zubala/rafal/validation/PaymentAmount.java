package com.zubala.rafal.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = AmountValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface PaymentAmount {
	public String message() default "must be positive number";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default {};
}

