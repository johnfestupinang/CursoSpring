package com.bolsaideas.springboot.form.app.Modelos;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.bolsaideas.springboot.form.app.validaciones.ApellidoRequerido;
import com.bolsaideas.springboot.form.app.validaciones.IdentificadorRegex;

public class Usuarios {
	
	//@Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
	@IdentificadorRegex
	private String identificador;
	
	@NotBlank
	@Size(min = 3, max = 8)
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty
	@Email(message = "El correo no tiene el formato correcto")
	private String email;
	
	//@NotEmpty(message = "El nombre no puede estar vacio")
	private String nombres;
	
	//@NotEmpty
	@ApellidoRequerido
	private String apellidos;
	
	@NotNull
	@Min(5)
	@Max(5000)
	private Integer cuenta;
	
	@NotNull
	private Paises pais;
	
	@NotEmpty
	private List<Roles> roles;
	
	private Boolean habilitar;

	@NotEmpty
	private String genero;
	
	private String valorSecreto;

	public Paises getPais() {
		return pais;
	}
	public void setPais(Paises pais) {
		this.pais = pais;
	}

	public Integer getCuenta() {
		return cuenta;
	}
	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public List<Roles> getRoles() {
		return roles;
	}
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	public Boolean getHabilitar() {
		return habilitar;
	}
	public void setHabilitar(Boolean habilitar) {
		this.habilitar = habilitar;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getValorSecreto() {
		return valorSecreto;
	}
	public void setValorSecreto(String valorSecreto) {
		this.valorSecreto = valorSecreto;
	}

		
}