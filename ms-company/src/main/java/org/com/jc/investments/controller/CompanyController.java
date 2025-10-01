package org.com.jc.investments.controller;

import org.com.jc.investments.dtos.CompanyDto;
import org.com.jc.investments.entitys.Company;
import org.com.jc.investments.service.ICompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class CompanyController {
	
	private final ICompanyService iCompanyService;
	private final ModelMapper mapper;

	@PostMapping("/")
	private ResponseEntity<CompanyDto> create(@RequestBody CompanyDto dto){
		
		Company createComapny= iCompanyService.create(dto);
		
		return new ResponseEntity<CompanyDto>(convertToDto(createComapny),HttpStatus.CREATED);
	}
	
	private CompanyDto convertToDto(Company company) {
		return mapper.map(company, CompanyDto.class);
	}
	
}
