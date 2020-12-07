package com.bolsadeideas.springboot.errores.app.Exceptions;

public class UsuarioException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UsuarioException(String id) {
		super("Usuario con ID: ".concat(id).concat(" no existe en el sistema"));
	}
	
	

}
