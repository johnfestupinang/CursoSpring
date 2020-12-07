package com.bolsaideas.springboot.web.app.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControlador {

	@GetMapping("/")
	public String home() {
		//return "redirect:/app/index"; Cargar la vista reibniciando el request
		//return "redirect:https://www.google.com"; //
		return "forward:/app/index";
	}
}
