package com.github.Radu_A.proyecto_07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.Radu_A.proyecto_07.model.Libro;

public interface LibrosRepository extends JpaRepository<Libro, Long> {
	
}
