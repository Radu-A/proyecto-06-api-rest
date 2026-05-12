package com.github.Radu_A.proyecto_07.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.Radu_A.proyecto_07.dto.VehiculoDto;

@Service
public class VehiculoService {
	
	private String baseUrl = "https://6a02eb8f0d92f63dd2547eb1.mockapi.io/api/vehiculos/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public VehiculoDto getVehiculo(int id) {
		return restTemplate.getForObject(baseUrl + id, VehiculoDto.class);
	}
	
	public VehiculoDto[] getVehiculoArray() {
		return restTemplate.getForObject(baseUrl, VehiculoDto[].class);
	}
	
	public VehiculoDto postForObject(VehiculoDto vehiculo) {
		return restTemplate.postForObject(baseUrl, vehiculo, VehiculoDto.class);
	}
	
	public void put(VehiculoDto vehiculo) {
		restTemplate.put(baseUrl + vehiculo.getId(), vehiculo);
	}
	
	public void delete(int id) {
		restTemplate.delete(baseUrl + id);
	}

}
