package com.bolsaideas.springboot.form.app.Ediciones;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bolsaideas.springboot.form.app.Servicios.IPaiseServicio;

@Component
public class PaisPropiedadeseditores extends PropertyEditorSupport {
	
	@Autowired
	private IPaiseServicio paisService;
	
	@Override
	public void setAsText(String idString) throws IllegalArgumentException {
		System.out.println("---- "+idString);
		if(idString != null && idString.length() > 0) {
			try {
				Integer id = Integer.parseInt(idString);				
				this.setValue(paisService.obtenerPorId(id));
			} catch (NumberFormatException e) {
				setValue(null);
			}
		}else {
			System.out.println("Entro al else prisproedadesesditores");
			setValue(null);
		}
		
	}
	
}
