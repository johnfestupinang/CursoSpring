package com.bolsadeideas.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.Cliente;
import com.bolsadeideas.springboot.app.models.service.IClienteService;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String listar (Model model) {
		model.addAttribute("titulo", "Listado de Clientes");
		model.addAttribute("clientes", clienteService.findAll());
		return "listar";
	}
	
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("titulo", "Formulario de Cliente");
		model.put("cliente", cliente); //cliente en la primera posicion es como lo pasamos a la vista
		return "form";
	}
	
	
	
	@RequestMapping(value="/form", method= RequestMethod.POST)
	public String guardar(@Valid /*@ModelAttribute("cliente")*/ Cliente cliente, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {// el ModelAttribute ayuda a pasar el objeto a la vista si este no se mapea con el nombre igual en este caso se llama igual, pero en caso de que no en el model attribute se especifica el nombre
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");			
			return "form";
		}
		String mensajeflash = (cliente.getId() != null)? "Cliente editado con exito" : "Cliente guardado exitosamente";
		clienteService.save(cliente);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeflash);
		return "redirect:listar";
		
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") long id, Map<String, Object>model,RedirectAttributes flash) {
		
		Cliente cliente = null;
		if(id>0) {
			cliente = clienteService.findOne(id);
			if(cliente == null) {
				flash.addFlashAttribute("error", "El cliente no existe en BD");
			}
		}else {
			flash.addFlashAttribute("error", "El ID del cliente no puede ser 0");
			return "redirect:listar";
		}
		model.put("titulo", "Editar Cliente");
		model.put("cliente", cliente);
		return "form";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id,RedirectAttributes flash) {
		if(id > 0) {
			clienteService.delete(id);
			flash.addFlashAttribute("success", "Cliente eliminado exitosamente");
		}
		return "redirect:/listar";
	}
}
