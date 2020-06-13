package com.uca.capas.tareaLabo5.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.tareaLabo5.domain.Estudiante;
import com.uca.capas.tareaLabo5.dto.EstudianteDTO;
import com.uca.capas.tareaLabo5.repositories.EstudianteRepo;

@Service
public class EstudianteServiceImpl implements EstudianteService{
	
	@Autowired
	EstudianteRepo estudianteRepo;
	//EstudianteDAO estudianteDao;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		//return estudianteRepo.findAll();
		return estudianteRepo.mostrarTodos();
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.getOne(code);
		
	}

	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteRepo.save(estudiante);
	}

	@Override
	@Transactional
	public void delete(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteRepo.deleteById(code);
	}
	
	
	@Override
	public List<Estudiante> filtrarPor(String cadena) throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.mostrarPorNombre(cadena);
	}
	
	@Override
	public List<Estudiante> empiezaCon(String cadena) throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.findByApellidoStartingWith(cadena);
	}
	
	@Override
	public List<EstudianteDTO> dtoPrueba() throws DataAccessException {
		// TODO Auto-generated method stub
		List<EstudianteDTO>estudiantes= estudianteRepo.pruebaDto().stream().map(obj->{
			EstudianteDTO e = new EstudianteDTO();
			e.setNombre(obj[0].toString());
			e.setApellido(obj[1].toString());
			return e;
		}).collect(Collectors.toList());
		return estudiantes;
	}
	
	@Transactional
	public void update(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteRepo.save(estudiante);
	}
}
