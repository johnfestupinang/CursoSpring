package com.bolsaideas.springboot.di.app.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsaideas.springboot.di.app.Modelos.Servicios.IServicio;
//import com.bolsaideas.springboot.di.app.Modelos.Servicios.MiServicio;

@Controller
public class IndexControlador {
	
	@Autowired
	//@Qualifier("miServicioSimple")
	private IServicio servicio;
	
	@GetMapping({"/","/index",""})
	public String index(Model model) {
		model.addAttribute("objeto", servicio.operacion());
		return "index";
	}
	
	//private MiServicio servicio = new MiServicio();
	
		//Inyeccion por medio de una clase -> Pueden llegar a cambiar
		/*@Autowired
		private MiServicio servicio;*/
	
	/*
	 *Inyeccion por medio de un constructor
	@Autowired -> Se puede dejar si esta anotacion
	public IndexControlador(IServicio servicio) {
		this.servicio = servicio;
	}*/

	//Inyeccion por Setter
	/*@Autowired 
	public void setServicio(IServicio servicio) {
		this.servicio = servicio;
	}	*/
	
	
}