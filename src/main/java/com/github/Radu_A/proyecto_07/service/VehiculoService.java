package com.github.Radu_A.proyecto_07.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.Radu_A.proyecto_07.dto.Vehiculo;

@Service
public class VehiculoService {
	
	private String baseUrl = "https://6a02eb8f0d92f63dd2547eb1.mockapi.io/api/vehiculos/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Vehiculo getVehiculo(int id) {
		return restTemplate.getForObject(baseUrl + id, Vehiculo.class);
	}
	
	public Vehiculo[] getVehiculoArray() {
		return restTemplate.getForObject(baseUrl, Vehiculo[].class);
	}
	
	public Vehiculo postForObject(Vehiculo vehiculo) {
		return restTemplate.postForObject(baseUrl, vehiculo, Vehiculo.class);
	}
	
	public void put(Vehiculo vehiculo) {
		restTemplate.put(baseUrl + vehiculo.getId(), vehiculo);
	}
	
	public void delete(int id) {
		restTemplate.delete(baseUrl + id);
	}

}
