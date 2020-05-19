package com.uca.capas.tareaLabo5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.tareaLabo5.dao.EstudianteDAO;
import com.uca.capas.tareaLabo5.domain.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService{
	
	@Autowired
	EstudianteDAO estudianteDao;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteDao.findAll();
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteDao.findOne(code);
	}

	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteDao.save(estudiante);
	}

	@Override
	@Transactional
	public void delete(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteDao.delete(code);
	}

}
