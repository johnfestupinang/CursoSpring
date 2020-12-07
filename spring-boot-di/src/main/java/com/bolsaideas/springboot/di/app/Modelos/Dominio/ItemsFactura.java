package com.bolsaideas.springboot.di.app.Modelos.Dominio;

public class ItemsFactura {
	private Productos producto;
	private Integer cantidad;
	

	public ItemsFactura(Productos producto, Integer cantidad) {
		
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Integer calcularImporte() {
		return cantidad * producto.getPrecio();
	}

}
