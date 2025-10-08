package org.com.jc.investments.service;

import java.util.List;

import org.com.jc.investments.dtos.CityDto;
import org.com.jc.investments.entitys.City;

public interface ICityService {

	/**
	 *  Create entity city
	 * @param dto
	 * @return
	 */
	public City create(CityDto dto);
	
	/**
	 * Get all entity city
	 * @return
	 */
	public List<City> getAll();
	
	/**
	 * Get entity city by id
	 * @param idCity
	 * @return
	 */
	public City getById(Integer idCity);
	
	/**
	 * Update entity city by id and dto
	 * @param idCity
	 * @param dto
	 * @return
	 */
	public City actualizar(Integer idCity,CityDto dto);
	
	/**
	 * Delete entity city by id
	 * @param idCity
	 */
	public void eliminar(Integer idCity);
}
