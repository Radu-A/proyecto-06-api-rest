package com.github.Radu_A.proyecto_07.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.Radu_A.proyecto_07.dto.LibroDto;

@Service
public class LibroService {
	
	private String baseUrl = "http://localhost:8080/api/libros/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public LibroDto[] getLibroArray() {
		return restTemplate.getForObject(baseUrl, LibroDto[].class);
	}
	
	public LibroDto getLibro(Long id) {
		return restTemplate.getForObject(baseUrl + id, LibroDto.class);
	}
	
	public void delete(Long id) {
		restTemplate.delete(baseUrl + id);
	}
}
