package com.jose.crudangulaPrimeNG.app.modelDTO;

import java.io.Serializable;
import java.time.LocalDate;

public class ProductoDTO implements Serializable{
	
	private Long id;
	private String nombre;
	private LocalDate fechaVencimiernto;
	private LocalDate fechaCreacion;
	private Long cantidad;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaVencimiernto() {
		return fechaVencimiernto;
	}
	public void setFechaVencimiernto(LocalDate fechaVencimiernto) {
		this.fechaVencimiernto = fechaVencimiernto;
	}
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
