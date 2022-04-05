package com.example.SpringMVC_Postgresql.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String>{

	public void initialize(Phone paramA) {
		
	}
	
	public boolean isValid(String phoneNo, ConstraintValidatorContext constraintValidatorContext) {
		if(phoneNo == null) {
			return false;
		}
		
		return phoneNo.matches("\\d{10}");
	}
}
