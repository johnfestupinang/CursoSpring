package com.bolsaideas.springboot.di.app.Modelos.Dominio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
@RequestScope
//@SessionScope
public class Clientes {
	@Value("${cliente.nombre}")
	private String nombre;
	@Value("${cliente.apellido}")
	private String apellido;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
