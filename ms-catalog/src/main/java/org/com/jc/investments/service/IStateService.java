package org.com.jc.investments.service;

import java.util.List;

import org.com.jc.investments.dtos.StateDto;
import org.com.jc.investments.entitys.State;

public interface IStateService {

	/**
	 *  Create entity state
	 * @param dto
	 * @return
	 */
	public State create(StateDto dto);
	
	/**
	 * Get all entity state
	 * @return
	 */
	public List<State> getAll();
	
	/**
	 * Get entity state by id
	 * @param idSate
	 * @return
	 */
	public State getById(Integer idSate);
	
	/**
	 * Update state city bi id and dto
	 * @param idSate
	 * @param dto
	 * @return
	 */
	public State actualizar(Integer idSate,StateDto dto);
	
	/**
	 * Delete entity state by id
	 * @param idSate
	 */
	public void eliminar(Integer idSate);
}
