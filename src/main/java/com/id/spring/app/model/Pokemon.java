package com.id.spring.app.model;

import javax.validation.constraints.NotEmpty;


public class Pokemon {
	@NotEmpty (message = "rellenar nombre")
	private String nombre;
	
	
	private String categoria;
	
	@NotEmpty (message = "rellenar tipo")
	private String tipo;
	
	@NotEmpty (message = "rellenar habilidad")
	private String habilidad;
	

	@NotEmpty (message = "rellenar nivel de poder")
	private String nivelPoder;
 

	private String urlimagen;
	
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getUrlimagen() {
		return urlimagen;
	}

	public void setUrlimagen(String urlimagen) {
		this.urlimagen = urlimagen;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getHabilidad() {
		return habilidad;
	}
	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}
	public String getNivelPoder() {
		return nivelPoder;
	}
	public void setNivelPoder(String nivelPoder) {
		this.nivelPoder = nivelPoder;
	}
}
