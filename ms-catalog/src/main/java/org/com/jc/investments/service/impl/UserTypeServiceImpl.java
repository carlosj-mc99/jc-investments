package org.com.jc.investments.service.impl;

import java.util.List;

import org.com.jc.investments.dtos.UserTypeDto;
import org.com.jc.investments.entitys.UserType;
import org.com.jc.investments.repository.IUserTypeRepository;
import org.com.jc.investments.service.IUserTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserTypeServiceImpl implements IUserTypeService {

	private final IUserTypeRepository repo;
	private final ModelMapper mapper;
	
	@Override
	public UserType create(UserTypeDto dto) {
		return repo.save(convertToEntity(dto));
	}

	@Override
	public List<UserType> getAll() {
		return repo.findAll();
	}

	@Override
	public UserType getById(Integer idUserType) {
		return repo.findById(idUserType).orElse(null);
	}

	@Override
	public UserType actualizar(Integer idUserType, UserTypeDto dto) {
		
		UserType userType =repo.findById(idUserType).orElse(null);
		
		if(userType == null) {
			return userType;
		}
		
		userType.setEnabled(dto.isEnabled());
		userType.setName(dto.getName());
		
		return repo.save(userType);
	}

	@Override
	public void eliminar(Integer idUserType) {
		repo.deleteById(idUserType);

	}
	
	private UserType convertToEntity(UserTypeDto dto) {
		return mapper.map(dto, UserType.class);
	}

}
