package com.bolsaideas.springboot.web.app.Controladores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsaideas.springboot.web.app.Modelos.Usuarios;

/*import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;*/

@Controller
@RequestMapping(value = "/app")
public class IndexControlador {
	
	//@RequestMapping(value="/index", method = RequestMethod.GET)
	@Value("${texto.indexControlador.index.titulo}") private String textoIndex;
	@Value("${texto.indexControlador.perfil.titulo}") private String textoPerfil;
	@Value("${texto.indexControlador.listar.titulo}") private String textoListaUsuarios;
	
	@GetMapping({"/index","/","home"})
	public String index(Model model) { // ModelMap, Map <String, Object>, ModelAndView  funciona igual al actual
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	@GetMapping(value = "/perfil")
	public String perfil(Model model) {
		Usuarios usuario = new Usuarios();
		usuario.setNombres("John");
		usuario.setApellidos("Estupiñan");
		usuario.setEmail("john@gmail.com");
		
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombres()));
		model.addAttribute("usuario", usuario);
		
		return "perfil";
	}
	
	@GetMapping(value = "/listarPerfil")
	public String listarPerfil(Model model) {
		/*List<Usuarios> listaUsuarios = Arrays.asList(
				new Usuarios("Juan","López","juanito@gmail.com"),
				new Usuarios("Camila","Rodriguez",""),
				new Usuarios("Alejandro","Bocanegra","alejo@gmail.com"));*/
		
		
		model.addAttribute("titulo", textoListaUsuarios);
		//model.addAttribute("listaUsuarios", listaUsuarios);
		return "listaUsuarios";
	}
	
	@ModelAttribute("listaUsuarios")
	public List<Usuarios> poblarUsuarios(){
		List<Usuarios> listaUsuarios = Arrays.asList(
				new Usuarios("Juan","López","juanito@gmail.com"),
				new Usuarios("Camila","Rodriguez","camila@gmail.com"),
				new Usuarios("Alejandro","Bocanegra","alejo@gmail.com"));
		
		return listaUsuarios;
	}
}
