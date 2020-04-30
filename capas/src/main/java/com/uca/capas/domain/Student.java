package com.uca.capas.domain;

public class Student {
	
	private String apellido;
	private String fEntrada;
	private String carrera;
	private Boolean estado;
	private String nombre;
	
	public Student() {
		
	}
	public Student(String nombre,String apellido, String carrera, String fEntrada, Boolean estado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.carrera = carrera;
		this.fEntrada = fEntrada;
		this.estado = estado;
		
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
	public String getfEntrada() {
		return fEntrada;
	}
	public void setfEntrada(String fEntrada) {
		this.fEntrada = fEntrada;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public String delegateEstado() {
		return estado ? "Activo":"Inactivo";
	}
	
}
