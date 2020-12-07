package com.bolsaideas.springboot.form.app.Servicios;

import java.util.List;

import com.bolsaideas.springboot.form.app.Modelos.Roles;

public interface IRolServicio {
	public List<Roles> listar();
	public Roles obtenerRolPorId(Integer id);
}
