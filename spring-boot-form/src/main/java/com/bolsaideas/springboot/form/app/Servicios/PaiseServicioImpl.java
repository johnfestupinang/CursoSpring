package com.bolsaideas.springboot.form.app.Servicios;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bolsaideas.springboot.form.app.Modelos.Paises;

@Component
public class PaiseServicioImpl implements IPaiseServicio {

	private List<Paises> lista;
	
	public PaiseServicioImpl() {
		this.lista = Arrays.asList(
				new Paises (1,"CO","Colombia"),
				new Paises (2,"ES","España"),
				new Paises (3,"MX","Mexico"),
				new Paises (4,"CL","Chile"));
	}
	
	@Override
	public List<Paises> listar() {
		return lista;
	}

	@Override
	public Paises obtenerPorId(Integer id) {
		System.out.println("Emntro aqui");
		Paises rptaPais = null;
		for(Paises pais: this.lista) {
			if(id == pais.getId()) {
				rptaPais = pais;
				break;
			}
		}
		return rptaPais;
	}

	

}
