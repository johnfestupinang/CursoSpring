package com.bolsaideas.springboot.form.app.validaciones;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



public class ApellidoRequeridoValidador implements ConstraintValidator<ApellidoRequerido, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		//if(value.isEmpty() || value.isBlank() || value == null) {
		if(value.isEmpty() || !org.springframework.util.StringUtils.hasText(value)) {
			return false;
		}
		return true;
	}



}
