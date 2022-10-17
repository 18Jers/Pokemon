package com.id.spring.app.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Pokemon {
	@NotEmpty (message = "no dejar en blanco")
	@Size(min = 3, max = 150)
	private String nombre;
	
	@NotEmpty (message = "no dejar en blanco")
	private String categoria;
	
	@NotEmpty (message = "no dejar en blanco")
	private String tipo;
	
	@NotEmpty (message = "no dejar en blanco")
	private String habilidad;
	
	@NotEmpty (message = "no dejar en blanco")
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
