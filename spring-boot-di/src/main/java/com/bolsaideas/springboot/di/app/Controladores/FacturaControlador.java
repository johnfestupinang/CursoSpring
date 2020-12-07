package com.bolsaideas.springboot.di.app.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsaideas.springboot.di.app.Modelos.Dominio.Facturas;

@Controller
@RequestMapping("/factura")
public class FacturaControlador {
	
	@Autowired
	private Facturas factura;
	
	@GetMapping("/ver")
	public String ver(Model model) {
		model.addAttribute("factura", factura);
		model.addAttribute("titulo", "Factura");
		return "factura/ver";
	}
}
