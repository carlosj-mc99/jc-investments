package org.com.jc.investments.service;

import java.util.List;

import org.com.jc.investments.dtos.UserTypeDto;
import org.com.jc.investments.entitys.UserType;

public interface IUserTypeService {

	/**
	 *  Create entity UserType
	 * @param dto
	 * @return UserType
	 */
	public UserType create(UserTypeDto dto);
	
	/**
	 * Get all entity UserType
	 * @return List
	 */
	public List<UserType> getAll();
	
	/**
	 * Get entity UserType by id
	 * @param idUserType
	 * @return UserType
	 */
	public UserType getById(Integer idUserType);
	
	/**
	 * Update entity UserType by id and dto
	 * @param idUserType
	 * @param dto
	 * @return
	 */
	public UserType actualizar(Integer idUserType,UserTypeDto dto);
	
	/**
	 * Delete entity UserType by id
	 * @param idUserType
	 */
	public void eliminar(Integer idUserType);
}
