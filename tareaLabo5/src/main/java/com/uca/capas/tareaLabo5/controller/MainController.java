package com.uca.capas.tareaLabo5.controller;




import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.uca.capas.tareaLabo5.domain.Estudiante;
import com.uca.capas.tareaLabo5.dto.EstudianteDTO;
import com.uca.capas.tareaLabo5.service.EstudianteService;



@Controller
public class MainController {
	
	@Autowired
	EstudianteService estudianteService;
	
	@RequestMapping("/inicio")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = new Estudiante();
		mav.addObject("estudiante",estudiante);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/formEstudiante")
	public ModelAndView inicio2(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("index");
		}else {
			Estudiante student = new Estudiante();
			mav.addObject("estudiante",student);
			estudianteService.save(estudiante);
			mav.setViewName("index");
		}
		
		
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView lista() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudiantes =  estudianteService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("listado");
	
		return mav;
		
	}
	
	@RequestMapping(value="/borrarEstudiante", method= RequestMethod.POST)
	public ModelAndView delete(@RequestParam(value="codigo") int id) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		
		try {
			estudianteService.delete(id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			estudiantes = estudianteService.findAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("listado");
		return mav;
	}
	
	@PostMapping(value="/filtrar")
	public ModelAndView filtro(@RequestParam(value="nombre") String cadena) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		
		try {
			estudiantes=estudianteService.filtrarPor(cadena);
			//estudiantes= estudianteService.empiezaCon(cadena);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("listado");
		return mav;
	}
	
	@PostMapping(value="/mostrarDTO")
	public ModelAndView mostrarDTO() {
		ModelAndView mav = new ModelAndView();
		List<EstudianteDTO> estudiantes = null;
		
		try {
			estudiantes=estudianteService.dtoPrueba();
			//estudiantes= estudianteService.empiezaCon(cadena);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("muestraDTO");
		return mav;
	}
	
	 @RequestMapping("/actualizarEstudiante")
		public ModelAndView buscar(@RequestParam Integer id) {
			ModelAndView mav = new ModelAndView();
			Estudiante estudiante = estudianteService.findOne(id);
			mav.addObject("estudiante", estudiante);
			mav.setViewName("actualizar");
			return mav;
		}
	    
	    @RequestMapping("/actualizar")
	 	public ModelAndView guardarCliente(@ModelAttribute Estudiante estudiante) {
	 		ModelAndView mav = new ModelAndView();
	 		estudianteService.update(estudiante);
	 		mav.setViewName("index");
	 		return mav;
	 	}
	
}
