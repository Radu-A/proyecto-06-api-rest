package com.github.Radu_A.proyecto_07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.Radu_A.proyecto_07.dto.VehiculoDto;
import com.github.Radu_A.proyecto_07.service.VehiculoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/vehiculos")
public class VehiculoController {
	
	@Autowired
	private VehiculoService vehiculoService;
	
	@ModelAttribute("titulo")
	public String titulo() {
		return "Vehiculos";
	}
	
	@GetMapping("")
	public String getVehiculoArray(Model model) {
		model.addAttribute("cabecera", "Listado de vehiculos");
		model.addAttribute("vehiculos", vehiculoService.getVehiculoArray());
		model.addAttribute("accion1", "Detalles");
		model.addAttribute("accion2", "Borrar");
		model.addAttribute("accion3", "Actualizar");
		return "vehiculos/menu";
	}
	
	@GetMapping("/{id}")
	public String getVehiculo(Model model, @PathVariable int id) {
		model.addAttribute("cabecera", "Detalle del vehiculo: " + id);
		model.addAttribute("vehiculo", vehiculoService.getVehiculo(id));
		return "vehiculos/detalles";
	}
	
	@GetMapping("/borrar/{id}")
	public String delete(@PathVariable int id) {
		vehiculoService.delete(id);
		return "redirect:/vehiculos";
	}
	
	@GetMapping("/form/{id}")
	public String editar(Model model, @PathVariable int id) {
		VehiculoDto vehiculo = vehiculoService.getVehiculo(id);
		System.out.println(id);
		System.out.println(vehiculo);
		model.addAttribute("cabecera", "Editar");
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("accion", "actualizar");
		return "vehiculos/form";
	}
	
	@PostMapping("/actualizar")
	public String actualizar(VehiculoDto vehiculo) {
		vehiculoService.put(vehiculo);
		return "redirect:/vehiculos";
	}
	
	@GetMapping("/nuevo")
	public String crear(Model model) {
		model.addAttribute("cabecera", "Nuevo cehiculo");
		model.addAttribute("vehiculo", new VehiculoDto());
		model.addAttribute("accion", "guardar");
		return "vehiculos/form";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid VehiculoDto vehiculo, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			vehiculoService.postForObject(vehiculo);
			return "redirect:/vehiculos";
		} else {
			model.addAttribute("cabecera", "Nuevo vehiculo");
			model.addAttribute("accion", "guardar");
			return "/vehiculos/form";
		}
	}
}
