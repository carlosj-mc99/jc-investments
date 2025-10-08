package org.com.jc.investments.service.impl;

import java.util.List;

import org.com.jc.investments.dtos.CityDto;
import org.com.jc.investments.dtos.StateDto;
import org.com.jc.investments.entitys.City;
import org.com.jc.investments.entitys.State;
import org.com.jc.investments.repository.IStateRepository;
import org.com.jc.investments.service.IStateService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StateServiceImpl implements IStateService {
	
	private final IStateRepository repo;
	private final ModelMapper mapper;

	@Override
	public State create(StateDto dto) {
		return repo.save(convertToEntity(dto));
	}

	@Override
	public List<State> getAll() {
		return repo.findAll();
	}

	@Override
	public State getById(Integer idSate) {
		return repo.findById(idSate).orElse(null);
	}

	@Override
	public State actualizar(Integer idSate, StateDto dto) {
		State state = repo.findById(idSate).orElse(null);
		
		if(state == null) {
			return state;
		}
		
		CityDto city = dto.getCity();
		
		state.setCity(convertToEntityCity(city));
		state.setEnabled(dto.isEnabled());
		state.setName(dto.getName());
		
		return repo.save(state);
	}

	@Override
	public void eliminar(Integer idSate) {
		repo.deleteById(idSate);

	}
	
	private State convertToEntity(StateDto dto) {
		return mapper.map(dto, State.class);
	}
	
	private City convertToEntityCity(CityDto dto) {
		return mapper.map(dto, City.class);
	}

}
