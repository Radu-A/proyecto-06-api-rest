package com.github.Radu_A.proyecto_07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.Radu_A.proyecto_07.dto.Vehiculo;

@Service
public class VehiculoService {
	
	private String url = "https://6a02eb8f0d92f63dd2547eb1.mockapi.io/api/vehiculos/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Vehiculo getVehiculo(int id) {
		String url = this.url + id;
		Vehiculo vehiculo = restTemplate.getForObject(url, Vehiculo.class);
		return vehiculo;
	}

}
