package com.bolsaideas.springboot.form.app.Controladores;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsaideas.springboot.form.app.Ediciones.NombreMayusculaEditor;
import com.bolsaideas.springboot.form.app.Ediciones.PaisPropiedadeseditores;
import com.bolsaideas.springboot.form.app.Ediciones.RolesEditor;
import com.bolsaideas.springboot.form.app.Modelos.Paises;
import com.bolsaideas.springboot.form.app.Modelos.Roles;
import com.bolsaideas.springboot.form.app.Modelos.Usuarios;
import com.bolsaideas.springboot.form.app.Servicios.IPaiseServicio;
import com.bolsaideas.springboot.form.app.Servicios.IRolServicio;
import com.bolsaideas.springboot.form.app.validaciones.UsuarioValidaciones;

@Controller
@SessionAttributes("usuarios")
public class FormularioControlador {

	@Autowired
	private UsuarioValidaciones validacionesU;
	
	@Autowired
	private IPaiseServicio paisService;
	
	@Autowired
	private IRolServicio rolService;
	
	@Autowired
	private PaisPropiedadeseditores paisEditor;
	
	@Autowired
	private RolesEditor rolEditor;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validacionesU); // Agrega las validaciones por dfecto de spring + las validaciones
												// customizadas
		/*
		 * SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		 * formatoFecha.setLenient(false); binder.registerCustomEditor(Date.class, new
		 * CustomDateEditor(formatoFecha,false));
		 */
		// binder.registerCustomEditor(String.class, new NombreMayusculaEditor());//
		// forma general
		binder.registerCustomEditor(String.class, "nombres", new NombreMayusculaEditor());// forma especifica
		binder.registerCustomEditor(String.class, "apellidos", new NombreMayusculaEditor());// forma especifica
		binder.registerCustomEditor(Paises.class, "pais", paisEditor);// forma especifica
		binder.registerCustomEditor(Roles.class, "roles", rolEditor);// forma especifica
	}
	
	@ModelAttribute("genero")
	public List<String> genero(){
		
		return Arrays.asList("Hombre","Mujer");
	}

	@ModelAttribute("listaPaises")
	public List<Paises> listaPaises (){
		return paisService.listar();
	}
	
	@ModelAttribute("listaRoles")
	public List<Roles> listaRoles(){
		return rolService.listar();
	}
	
	@ModelAttribute("listaRolesString")
	public List<String> listaRolesString(){
		List<String> roles = new ArrayList<>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		roles.add("ROLE_MODERATOR");
		return roles;
	}
	
	@ModelAttribute("listaRolesMap")
	public Map<String, String> listaRolesMap() {
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("ROLE_ADMIN", "Administrador");
		roles.put("ROLE_USER", "Usuario");
		roles.put("ROLE_MODERATOR", "Moderador");
	
		return roles;
	}

	/*@ModelAttribute("paises")
	public List<String> paises() {
		return Arrays.asList("Colombia", "España", "Mexico", "Chile");
	}*/

	/*@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap() {
		Map<String, String> paises = new HashMap<String, String>();
		paises.put("COL", "Colombia");
		paises.put("ES", "España");
		paises.put("MX", "Mexico");
		paises.put("CL", "Chile");

		return paises;
	}*/

	@GetMapping("/form")
	public String form(Model model) {
		Usuarios usuario = new Usuarios();
		usuario.setNombres("John");
		usuario.setApellidos("Doe");
		usuario.setIdentificador("12.456.789-K");
		usuario.setHabilitar(true);
		usuario.setValorSecreto("Algun valor secreto ***");
		usuario.setPais(new Paises (1,"CO","Colombia"));
		usuario.setRoles(Arrays.asList(new Roles(2,"Usuario","ROL_USER")));
		
		model.addAttribute("titulo", "Formulario Usuarios");
		model.addAttribute("usuarios", usuario);

		return "form";
	}

	@PostMapping("/form")
	public String procesarFormulario(@Valid Usuarios usuario, BindingResult result, Model model) {

		// validacionesU.validate(usuario, result);

		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Resultado del formulario");
			return "form";
		}

		/*
		 * if(result.hasErrors()) { Map<String, String> errores = new HashMap<>();
		 * result.getFieldErrors().forEach(err -> { errores.put(err.getField(),
		 * "El campo: ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage(
		 * ))); }); model.addAttribute("error",errores); return "form"; }
		 */
	

		
		return "redirect:/ver";
	}
	
	@GetMapping("/ver")
	public String ver(@SessionAttribute(name = "usuarios", required = false) Usuarios usuarios, Model model,SessionStatus status) {
		if(usuarios == null) {
			return "redirect:/form";
		}
		
		model.addAttribute("titulo", "Resultado del formulario");
		
		status.setComplete();
		return "resultado";
	}

	/*
	 * @PostMapping("/form") public String procesarFormulario(Model
	 * model, @RequestParam String username, @RequestParam String
	 * password, @RequestParam String email) {
	 * 
	 * Usuarios usuario1 = new Usuarios(); usuario1.setUsername(username);
	 * usuario1.setPassword(password); usuario1.setEmail(email);
	 * 
	 * model.addAttribute("usuario", usuario1);
	 * 
	 * model.addAttribute("titulo", "Resultado del formulario");
	 * 
	 * 
	 * return "resultado"; }
	 */
}
