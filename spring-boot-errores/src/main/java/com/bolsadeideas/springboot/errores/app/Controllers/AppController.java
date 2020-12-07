package com.bolsadeideas.springboot.errores.app.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bolsadeideas.springboot.errores.app.Exceptions.UsuarioException;
import com.bolsadeideas.springboot.errores.app.Models.Usuarios;
import com.bolsadeideas.springboot.errores.app.Services.IUsuarioService;

@Controller
public class AppController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@SuppressWarnings("unused")
	@GetMapping("/index")
	public String index(){
		
		Integer valor = 100/0;
		//Integer valor = Integer.parseInt("10X");
		return "index";
	}
	
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable Integer id, Model model) {
		
		//Usuarios usuario = usuarioService.obtenerUsuarioPorId(id);
		/*if(usuario==null) {
			throw new UsuarioException(id.toString());
		}*/
		
		Usuarios usuario = usuarioService.obtenerUsuarioPorIdOptional(id).orElseThrow(() -> new UsuarioException(id.toString()));//Personalizacion de la excepcion
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombre()));
		return "ver";
	}
}
