package com.uca.capas.tareaLabo5.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public",name="estudiante")
public class Estudiante {
	
	@Id
	@Column(name="c_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer c_usuario;
	
	@Size(message="Nombre no tiene que tener mas de 50 caracteres", max=50)
	@Column(name="nombre")
	@NotEmpty(message="Este campo no puede estar vacio")
	private String nombre;
	
	@Size(message="Apellido no tiene que tener mas de 50 caracteres", max=50)
	@Column(name="apellido")
	@NotEmpty(message="Este campo no puede estar vacio")
	private String apellido;
	
	@Size(message="Carne no tiene que tener mas de 10 caracteres", max=10)
	@Column(name="carne")
	@NotEmpty(message="Este campo no puede estar vacio")
	private String carne;
	
	@Size(message="Carrera no tiene que tener mas de 10 caracteres", max=100)
	@Column(name="carrera")
	@NotEmpty(message="Este campo no puede estar vacio")
	private String carrera;
	
	public Estudiante() {}

	public Integer getC_usuario() {
		return c_usuario;
	}

	public void setC_usuario(Integer c_usuario) {
		this.c_usuario = c_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCarne() {
		return carne;
	}

	public void setCarne(String carne) {
		this.carne = carne;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	
	
}