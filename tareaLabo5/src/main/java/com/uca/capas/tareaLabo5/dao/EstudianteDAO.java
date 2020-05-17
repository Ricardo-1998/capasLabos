package com.uca.capas.tareaLabo5.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.tareaLabo5.domain.Estudiante;



public interface EstudianteDAO {
	
	public List<Estudiante> findAll() throws DataAccessException;
	
	public Estudiante findOne(Integer code) throws DataAccessException;
	
	public void save(Estudiante estudiante) throws DataAccessException;
}
