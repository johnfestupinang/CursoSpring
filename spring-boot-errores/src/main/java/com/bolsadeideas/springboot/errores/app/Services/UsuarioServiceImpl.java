package com.bolsadeideas.springboot.errores.app.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.errores.app.Models.Usuarios;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	private List<Usuarios> lista;
	
	
	
	public UsuarioServiceImpl() {
		this.lista = new ArrayList<>();
		this.lista.add(new Usuarios(1,"John","Gomez"));
		this.lista.add(new Usuarios(2,"Andrea","Fuentes"));
		this.lista.add(new Usuarios(3,"Camila","Lozano"));
		this.lista.add(new Usuarios(4,"Daniel","Osorio"));
	}

	@Override
	public List<Usuarios> listarUsuario() {
		return this.lista;
	}

	@Override
	public Usuarios obtenerUsuarioPorId(Integer id) {
		Usuarios resultado = null;
		for (Usuarios usuario: this.lista) {
			if(usuario.getId().equals(id)) {
				resultado = usuario;
			}
		}
		return resultado;
	}

	@Override
	public Optional<Usuarios> obtenerUsuarioPorIdOptional(Integer id) {
		Usuarios usuario = this.obtenerUsuarioPorId(id);		
		return Optional.ofNullable(usuario);//Convierte el objeto usuario en un objeto independientemente si es de tipo Usuarios o Null
	}

}
