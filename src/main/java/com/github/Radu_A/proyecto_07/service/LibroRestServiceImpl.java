package com.github.Radu_A.proyecto_07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.Radu_A.proyecto_07.model.Libro;
import com.github.Radu_A.proyecto_07.repository.LibrosRepository;

@Service
public class LibroRestServiceImpl implements ILibroRestService {
	
	@Autowired
	private LibrosRepository librosRepository;

	@Override
	public List<Libro> findAll() {
		return librosRepository.findAll();
	}

	@Override
	public Libro findById(Long id) {
		return librosRepository.findById(id).orElse(null);
	}

	@Override
	public Libro save(Libro libro) {
		return librosRepository.save(libro);
	}

	@Override
	public void delete(Long id) {
		librosRepository.deleteById(id);
	}

}
