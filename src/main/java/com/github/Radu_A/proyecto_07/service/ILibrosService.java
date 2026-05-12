package com.github.Radu_A.proyecto_07.service;

import java.util.List;

import com.github.Radu_A.proyecto_07.model.Libro;

public interface ILibrosService {
	
	List<Libro> findAll();
	Libro findById(Long id);
	Libro save(Libro libro);
	void delete(Long id);
}
