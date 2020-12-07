package com.bolsaideas.springboot.web.app.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariableRutaControlador {
	
	@GetMapping("/")
	public String index(Model model) {	
		model.addAttribute("nombre", "Juanita");
		model.addAttribute("apellido", "Jimenez");
		return "variables/index";
	}
	
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model model) {
		model.addAttribute("resultado", "El texto enviado fue: "+texto);
		return "variables/ver";
	}
	
	@GetMapping("/string/{nombre}/{apellido}")
	public String variables(@PathVariable String nombre, @PathVariable String apellido,Model model) {
		model.addAttribute("resultado", "Nombre: "+nombre+" apellido: "+apellido);
		return "variables/ver";
	}
}
