package org.com.jc.investments.service.impl;

import org.com.jc.investments.dtos.CompanyDto;
import org.com.jc.investments.entitys.Company;
import org.com.jc.investments.repository.ICompanyRepository;
import org.com.jc.investments.service.ICompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements ICompanyService {
	
	private final ICompanyRepository repo;
	private final ModelMapper mapper;
	
	@Override
	public Company create(CompanyDto dto) {
		
		return repo.save(convertToEntity(dto));
	}
	
	private Company convertToEntity(CompanyDto dto) {
		return mapper.map(dto, Company.class);
	}

}
