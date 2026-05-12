package com.github.Radu_A.proyecto_07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.Radu_A.proyecto_07.service.LibroService;

@Controller
@RequestMapping("/libros")
public class LibroController {
	
	@Autowired
	private LibroService libroService;
	
	@ModelAttribute("titulo")
	public String titulo() {
		return "Libros";
	}
	
	@GetMapping("")
	public String getLibroArray(Model model) {
		model.addAttribute("cabecera", "Listado de libros");
		model.addAttribute("vehiculos", libroService.getLibroArray());
		model.addAttribute("accion1", "Detalles");
		model.addAttribute("accion2", "Borrar");
		model.addAttribute("accion3", "Actualizar");
		return "libros/menu";
	}
}
