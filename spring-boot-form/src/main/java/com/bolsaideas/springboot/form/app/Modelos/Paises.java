package com.bolsaideas.springboot.form.app.Modelos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Paises {
	
	
	private Integer id;
	
	//@NotEmpty
	private String codigo;
	private String nombre;

	public Paises(Integer id, String codigo, String nombre) {
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return this.id.toString();
	}

	public Paises() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNoimbre(String nombre) {
		this.nombre = nombre;
	}

}
