package com.bolsaideas.springboot.di.app.Modelos.Dominio;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
@RequestScope
//@SessionScope
//@ApplicationScope
public class Facturas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Value("${factura.descripcion}")
	private String descripcion;
	@Autowired
	private Clientes cliente;
	
	@Autowired
	//@Qualifier("itemsOficina")
	private List<ItemsFactura> items;
	
	@PostConstruct
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat(" David"));
		descripcion = descripcion.concat(" del cliente "+cliente.getNombre()); 
	}
	
	@PreDestroy
	public void destruir() {
		System.out.println("Factura destruida ".concat(descripcion));
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public List<ItemsFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemsFactura> items) {
		this.items = items;
	}

}
