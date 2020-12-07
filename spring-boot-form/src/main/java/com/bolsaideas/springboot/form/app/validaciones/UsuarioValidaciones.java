package com.bolsaideas.springboot.form.app.validaciones;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bolsaideas.springboot.form.app.Modelos.Usuarios;

@Component
public class UsuarioValidaciones implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuarios.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Usuarios usuario = (Usuarios)target;
		/*
		 * nombres -> es el nombre del atributo en la Clase Usuarios
		 * */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombres", "NotEmpty.usuarios.nombres");
		
		/*if(!usuario.getIdentificador().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")) {
			errors.rejectValue("identificador", "Pattern.usuarios.identificador");
		}*/

	}

}
