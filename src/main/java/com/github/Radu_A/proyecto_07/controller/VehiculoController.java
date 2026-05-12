package com.github.Radu_A.proyecto_07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.Radu_A.proyecto_07.dto.Vehiculo;
import com.github.Radu_A.proyecto_07.service.VehiculoService;

@Controller
@RequestMapping("/vehiculos")
public class VehiculoController {
	
	@Autowired
	private VehiculoService vehiculoService;
	
	@ModelAttribute("titulo")
	public String titulo() {
		return "Vehiculos";
	}
	
	@GetMapping("/{id}")
	public String getVehiculo(Model model, @PathVariable int id) {
		Vehiculo vehiculo = vehiculoService.getVehiculo(id);
		model.addAttribute("cabecera", "Detalle de un vehiculo");
		model.addAttribute("vehiculo", vehiculo);
		return "vehiculos/detalles";
	}
}
