package com.bolsaideas.springboot.web.app.Modelos;

public class Usuarios {
	private String nombres;
	private String apellidos;
	private String email;
	
	public Usuarios () {}
	
	public Usuarios (String nombres, String apellidos, String email) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
