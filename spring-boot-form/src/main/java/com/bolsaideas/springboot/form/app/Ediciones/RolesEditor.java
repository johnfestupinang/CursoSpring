package com.bolsaideas.springboot.form.app.Ediciones;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bolsaideas.springboot.form.app.Servicios.IRolServicio;

@Component
public class RolesEditor extends PropertyEditorSupport {

	@Autowired
	private IRolServicio service;
	@Override
	public void setAsText(String id) throws IllegalArgumentException {
		try {
			Integer Id =  Integer.parseInt(id);
			setValue(service.obtenerRolPorId(Id));
		} catch (NumberFormatException e) {
			setValue(null);
		}
	}
	
}
