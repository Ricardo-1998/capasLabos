package com.uca.capas.tareaLabo5.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.tareaLabo5.domain.Estudiante;
import com.uca.capas.tareaLabo5.dto.EstudianteDTO;

public interface EstudianteService {
	public List<Estudiante> findAll() throws DataAccessException;
	
	public Estudiante findOne(Integer code) throws DataAccessException;
	
	public void save(Estudiante estudiante) throws DataAccessException;
	
	public void delete(Integer code) throws DataAccessException;
	
	public List<Estudiante> filtrarPor(String cadena) throws DataAccessException;

	public List<Estudiante> empiezaCon(String cadena) throws DataAccessException;
	
	public List<EstudianteDTO> dtoPrueba() throws DataAccessException;
	
	void update(Estudiante estudiante) throws DataAccessException;
}