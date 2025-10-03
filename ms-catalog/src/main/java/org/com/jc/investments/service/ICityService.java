package org.com.jc.investments.service;

import java.util.List;

import org.com.jc.investments.dtos.CityDto;
import org.com.jc.investments.entitys.City;

public interface ICityService {

	public City create(CityDto dto);
	
	public List<City> getAll();
	
	public City getById(Integer idCity);
	
	public City actualizar(Integer idCity,CityDto dto);
	
	public void eliminar(Integer idCity);
}
