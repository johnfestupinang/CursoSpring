package com.bolsadeideas.springboot.errores.app.Controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bolsadeideas.springboot.errores.app.Exceptions.UsuarioException;

@ControllerAdvice
public class ErrorHandlerController {
	
	@ExceptionHandler({ArithmeticException.class})//Puede ser para varias
	public String arimeticaError(ArithmeticException ex, Model model) {
		model.addAttribute("error", "error de aritmetica");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/generica";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String formatoNumeroExcepcion(NumberFormatException ex, Model model) {
		model.addAttribute("error", "Error: Formato numero invalido.!");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/numero-formato";
	}
	
	@ExceptionHandler(UsuarioException.class)
	public String excepcionUsuario(UsuarioException ex, Model model) {
		model.addAttribute("error", "Error: usuario no encontrado");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/usuario";
	}
}
