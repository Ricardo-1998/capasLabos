package com.uca.capas.tareaLabo3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tareaLabo3.domain.Product;

@Controller
public class ProductController {
	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/compraProducto")
	public ModelAndView compraProducto() {
		
		ModelAndView mav = new ModelAndView();
		productos.add(new Product(0,"GTA5",60));
		productos.add(new Product(1,"MINECRAFT",20));
		productos.add(new Product(2,"WOW",10));
		productos.add(new Product(3,"COD",8));
		productos.add(new Product(4,"LOLSITO",20));
		
		mav.setViewName("productos");
		mav.addObject("product", new Product());
		mav.addObject("producto",productos);
		return mav;
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product, @RequestParam Integer cantidad) {
		String mensaje;
		ModelAndView mav = new ModelAndView();
		mav.addObject("product", product);
		if(cantidad>productos.get(product.getId()).getCantidad()) {
			mensaje="El producto "+ productos.get(product.getId()).getNombre()+" no se puede adquirir.";
			mav.addObject("mensaje",mensaje);
			mav.setViewName("error");
			return mav;
		}
		mensaje="El producto "+ productos.get(product.getId()).getNombre()+" se adquirio.";
		mav.addObject("mensaje",mensaje);
		mav.setViewName("compra");
		
		return mav;
	}
}