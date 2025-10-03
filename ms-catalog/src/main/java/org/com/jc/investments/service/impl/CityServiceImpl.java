package org.com.jc.investments.service.impl;

import java.util.List;

import org.com.jc.investments.dtos.CityDto;
import org.com.jc.investments.entitys.City;
import org.com.jc.investments.repository.ICityRepository;
import org.com.jc.investments.service.ICityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements ICityService{

	private final ICityRepository repo;
	private final ModelMapper mapper;
	
	@Override
	public City create(CityDto dto) {
		return repo.save(convertToEntity(dto));
	}

	@Override
	public List<City> getAll() {
		return repo.findAll();
	}

	@Override
	public City getById(Integer idCity) {
		return repo.findById(idCity).orElse(new City());
	}

	@Override
	public City actualizar(Integer idCity, CityDto dto) {
		City city = repo.findById(idCity).orElse(null);
		
		if(city == null) {
			return new City();
		}
		
		city.setEnabled(dto.isEnabled());
		city.setName(dto.getName());
		
		return repo.save(city);
	}

	@Override
	public void eliminar(Integer idCity) {
		repo.deleteById(idCity);
	}
	
	private City convertToEntity(CityDto dto) {
		return mapper.map(dto, City.class);
	}
}
