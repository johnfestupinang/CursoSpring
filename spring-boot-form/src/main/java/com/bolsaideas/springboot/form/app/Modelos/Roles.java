package com.bolsaideas.springboot.form.app.Modelos;

public class Roles {
	private Integer id;
	private String nombre;
	private String role;

	public Roles() {
	}

	public Roles(Integer id, String nombre, String role) {
		this.id = id;
		this.nombre = nombre;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Roles)) {
			return false;
		}
		Roles rol = (Roles)obj;
		return this.id != null && this.id.equals(rol.getId());
	}
	
	

}
