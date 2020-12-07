package com.bolsaideas.springboot.di.app.Modelos.Servicios;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Service("miServicioComplejo")
//@Primary
public class MiServicioComplejo implements IServicio{
	
	
	@Override
	public String operacion() {
		return "ejecutando algun proceso importante COMPLICADO.... ";
	}
}
