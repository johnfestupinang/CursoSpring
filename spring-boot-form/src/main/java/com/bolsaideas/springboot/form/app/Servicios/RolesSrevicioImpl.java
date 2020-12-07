package com.bolsaideas.springboot.form.app.Servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsaideas.springboot.form.app.Modelos.Roles;

@Service
public class RolesSrevicioImpl implements IRolServicio {

	private List<Roles> roles;
	public RolesSrevicioImpl() {
	roles = new ArrayList<>();
	this.roles.add(new Roles(1,"Administrador","ROL_ADMIN"));
	this.roles.add(new Roles(2,"Usuario","ROL_USER"));
	this.roles.add(new Roles(4,"Moderador","ROL_MODERATOR"));
	}

	@Override
	public List<Roles> listar() {
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public Roles obtenerRolPorId(Integer id) {
		Roles resultado = null;
		for(Roles rol: roles) {
			if(id == rol.getId()) {
				resultado = rol;
				break;
			}
		}
		return  resultado;
	}

}
