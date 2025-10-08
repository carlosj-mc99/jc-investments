package org.com.jc.investments.controller;

import java.util.List;

import org.com.jc.investments.configuration.HttpResponseInvestment;
import org.com.jc.investments.configuration.HttpStatusCodeInvestment;
import org.com.jc.investments.dtos.UserTypeDto;
import org.com.jc.investments.entitys.UserType;
import org.com.jc.investments.service.IUserTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users-types")
public class UserTypeController {

	private final IUserTypeService iUserTypeService;
	private final ModelMapper mapper;

	@PostMapping("/")
	private HttpResponseInvestment<UserTypeDto> create(@RequestBody UserTypeDto dto){
		
		UserType createUserType= iUserTypeService.create(dto);
		
		return new HttpResponseInvestment<UserTypeDto>( HttpStatusCodeInvestment.CREATED.getCode(),
				HttpStatus.CREATED,convertToDto(createUserType));
	}
	
	@GetMapping("/")
	private HttpResponseInvestment<List<UserTypeDto>> getAll(){
		
		return new HttpResponseInvestment<List<UserTypeDto>>(HttpStatusCodeInvestment.OK.getCode(),HttpStatus.ACCEPTED
				,iUserTypeService.getAll().stream().map(this::convertToDto).toList());
	}

	@GetMapping("/{id}")
	private HttpResponseInvestment<UserTypeDto> getById(@PathVariable Integer id){
		
		UserType getUserType=iUserTypeService.getById(id);
		
		if(getUserType != null) {
			
			return new HttpResponseInvestment<UserTypeDto>(HttpStatusCodeInvestment.OK.getCode(),HttpStatus.ACCEPTED
					,convertToDto(getUserType));
		}else {
			return new HttpResponseInvestment<UserTypeDto>(HttpStatusCodeInvestment.NOT_FOUND.getCode(),HttpStatus.NOT_FOUND,null);
			
		}
		
	}

	@PutMapping("/{id}")
	private HttpResponseInvestment<UserTypeDto> update(@PathVariable Integer id,@RequestBody UserTypeDto dto){
		
		UserType updateUserType=iUserTypeService.actualizar(id, dto);
		
		if(updateUserType != null) {
			
			return new HttpResponseInvestment<UserTypeDto>(HttpStatusCodeInvestment.OK.getCode(),HttpStatus.ACCEPTED
					,convertToDto(updateUserType));
		}else {
			return new HttpResponseInvestment<UserTypeDto>(HttpStatusCodeInvestment.NOT_FOUND.getCode(),HttpStatus.NOT_FOUND, null);
			
		}
	}
	
	@DeleteMapping("/{id}")
	private HttpResponseInvestment<String> delete(@PathVariable Integer id){
		
		iUserTypeService.eliminar(id);
		
		return new HttpResponseInvestment<String>(HttpStatusCodeInvestment.NO_CONTENT.getCode()
				,HttpStatus.NO_CONTENT,"Se elimino correctamente...");
	}
	
	private UserTypeDto convertToDto(UserType city) {
		return mapper.map(city, UserTypeDto.class);
	}

}
