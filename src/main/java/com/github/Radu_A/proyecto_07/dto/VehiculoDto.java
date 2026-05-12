package com.github.Radu_A.proyecto_07.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class VehiculoDto {
	
	private int id;
	@NotBlank(message = "{vehiculo.marca.notblank}")
	@Size(min = 2, max = 50, message = "{vehiculo.marca.size}")
	private String marca;
	@NotBlank(message = "{vehiculo.modelo.notblank}")
	@Size(min = 2, max = 50, message = "{vehiculo.modelo.size}")
	private String modelo;
	@NotBlank(message = "{vehiculo.matricula.notblank}")
	@Size(min = 7, max = 7, message = "{vehiculo.modelo.size}")
	private String matricula;
	@NotNull(message = "{vehiculo.anio.notnull}")
	@Min(value = 1950, message = "{vehiculo.anio.min}")
	private Integer anio;
	@NotNull(message = "{vehiculo.kilometros.notnull}")
	@Min(value = 0, message = "{vehiculo.kilometros.min}")
	private Integer kilometros;
	
	public VehiculoDto() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Integer getKilometros() {
		return kilometros;
	}
	public void setKilometros(Integer kilometros) {
		this.kilometros = kilometros;
	}
}
