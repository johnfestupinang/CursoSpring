package com.bolsaideas.springboot.form.app.Servicios;

import java.util.List;

import com.bolsaideas.springboot.form.app.Modelos.Paises;

public interface IPaiseServicio {
	public List<Paises> listar();
	public Paises obtenerPorId(Integer id);
}
