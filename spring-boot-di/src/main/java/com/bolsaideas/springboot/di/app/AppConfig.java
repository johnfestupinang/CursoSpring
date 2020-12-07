package com.bolsaideas.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bolsaideas.springboot.di.app.Modelos.Dominio.ItemsFactura;
import com.bolsaideas.springboot.di.app.Modelos.Dominio.Productos;
import com.bolsaideas.springboot.di.app.Modelos.Servicios.IServicio;
import com.bolsaideas.springboot.di.app.Modelos.Servicios.MiServicio;

@Configuration
public class AppConfig {
	
	@Bean("miServicioComplejo")
	public IServicio registrarMiServicio () {
		return new MiServicio();
	}
	
	@Bean("itemsFactura")
	@Primary
	public List<ItemsFactura> registrarItems(){
		Productos camara = new Productos("Camara Sony",100);
		Productos cama = new Productos("cama",150);
		Productos bicicleta = new Productos("bicicleta",200);	
		
		ItemsFactura item1 = new ItemsFactura(camara, 5);
		ItemsFactura item2 = new ItemsFactura(cama, 2);
		ItemsFactura item3 = new ItemsFactura(bicicleta, 1);
		
		return Arrays.asList(item1, item2,item3);
	}
	
	@Bean("itemsOficina")
	//@Primary
	public List<ItemsFactura> registrarItemsOficina(){
		Productos monitor = new Productos("Monitor LG LCD ",2500);
		Productos portatil = new Productos("Portatil Asus",750);
		Productos impresora = new Productos("Impresora",150);	
		Productos escritorio = new Productos("Escritorio Oficina en L",850);	
		
		ItemsFactura item1 = new ItemsFactura(monitor, 1);
		ItemsFactura item2 = new ItemsFactura(portatil, 1);
		ItemsFactura item3 = new ItemsFactura(impresora, 1);
		ItemsFactura item4 = new ItemsFactura(escritorio, 1);
		
		return Arrays.asList(item1, item2,item3,item4);
	}


}
