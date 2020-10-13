
package com.jose.crudangularPrimeNG.app.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "fecha_vencimiento")
	private LocalDate fechaVencimiernto;
	@Column(name = "fecha_creacion")
	private LocalDate fechaCreacion;
	@Column(name = "cantidad")
	private Long cantidad;
	
	@PrePersist
	public void prePersist() {
		this.fechaCreacion = LocalDate.now();
	}
	
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
