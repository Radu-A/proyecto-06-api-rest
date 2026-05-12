package com.github.Radu_A.proyecto_07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.Radu_A.proyecto_07.model.Libro;
import com.github.Radu_A.proyecto_07.service.LibrosServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/libros")
@Tag(name = "libros", description = "API para la gestión de libros en la biblioteca")
public class LibrosRestController {
	
	@Autowired
	private LibrosServiceImpl libroService;
	
	@GetMapping("")
	@Operation(summary = "Obtener todos los libros", description = "Retorna una lista de todos los libros disponibles")
	public List<Libro> findAll() {
		return libroService.findAll();
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Buscar libro por ID", description = "Proporciona el ID del libro para obtener sus detalles")
	public Libro findById(@PathVariable Long id) {
		return libroService.findById(id);
	}
	
	@PostMapping("")
	@Operation(summary = "Crear un nuevo libro", description = "Añade un libro a la base de datos")
	public Libro save(@RequestBody Libro libro) {
		return libroService.save(libro);
	}
	
	@PutMapping("")
	@Operation(summary = "Actualizar un libro", description = "Modifica los datos de un libro existente")
	public Libro update(@RequestBody Libro libro) {
		return libroService.save(libro);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Eliminar libro", description = "Borra físicamente el libro de la base de datos mediante su ID")
	public String deleteById(@PathVariable Long id) {
		libroService.delete(id);
		return String.format("El libro con id %d ha sido eliminado", id);
	}
}
