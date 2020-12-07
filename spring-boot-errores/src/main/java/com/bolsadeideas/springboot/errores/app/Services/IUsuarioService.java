package com.bolsadeideas.springboot.errores.app.Services;

import java.util.List;
import java.util.Optional;

import com.bolsadeideas.springboot.errores.app.Models.Usuarios;

public interface IUsuarioService {
	public List<Usuarios> listarUsuario();
	public Usuarios obtenerUsuarioPorId(Integer id); 
	public Optional<Usuarios> obtenerUsuarioPorIdOptional(Integer id); 
}
