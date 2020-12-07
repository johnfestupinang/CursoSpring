package com.bolsaideas.springboot.di.app.Modelos.Dominio;

public class Productos {
	private String nombre;
	private Integer precio;
	
	public Productos(String nombre, Integer precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

}
