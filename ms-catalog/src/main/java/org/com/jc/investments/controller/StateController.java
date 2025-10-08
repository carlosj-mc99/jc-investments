package org.com.jc.investments.controller;

import java.util.List;

import org.com.jc.investments.configuration.HttpResponseInvestment;
import org.com.jc.investments.configuration.HttpStatusCodeInvestment;
import org.com.jc.investments.dtos.StateDto;
import org.com.jc.investments.entitys.State;
import org.com.jc.investments.service.IStateService;
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
@RequestMapping("/states")
public class StateController {



	private final IStateService iStateService;
	private final ModelMapper mapper;

	@PostMapping("/")
	private HttpResponseInvestment<StateDto> create(@RequestBody StateDto dto){
		
		State createStatus= iStateService.create(dto);
		
		return new HttpResponseInvestment<StateDto>( HttpStatusCodeInvestment.CREATED.getCode(),
				HttpStatus.CREATED,convertToDto(createStatus));
	}
	
	@GetMapping("/")
	private HttpResponseInvestment<List<StateDto>> getAll(){
		
		return new HttpResponseInvestment<List<StateDto>>(HttpStatusCodeInvestment.OK.getCode(),HttpStatus.ACCEPTED
				,iStateService.getAll().stream().map(this::convertToDto).toList());
	}

	@GetMapping("/{id}")
	private HttpResponseInvestment<StateDto> getById(@PathVariable Integer id){
		
		State getState=iStateService.getById(id);
		
		if(getState != null) {
			
			return new HttpResponseInvestment<StateDto>(HttpStatusCodeInvestment.OK.getCode(),HttpStatus.ACCEPTED
					,convertToDto(getState));
		}else {
			return new HttpResponseInvestment<StateDto>(HttpStatusCodeInvestment.NOT_FOUND.getCode(),HttpStatus.NOT_FOUND,null);
			
		}
		
	}

	@PutMapping("/{id}")
	private HttpResponseInvestment<StateDto> update(@PathVariable Integer id,@RequestBody StateDto dto){
		
		
		State getState=iStateService.actualizar(id, dto);
		
		if(getState != null) {
			
			return new HttpResponseInvestment<StateDto>(HttpStatusCodeInvestment.OK.getCode(),HttpStatus.ACCEPTED
					,convertToDto(getState));
		}else {
			return new HttpResponseInvestment<StateDto>(HttpStatusCodeInvestment.NOT_FOUND.getCode(),HttpStatus.NOT_FOUND, null);
			
		}
	}
	
	@DeleteMapping("/{id}")
	private HttpResponseInvestment<String> delete(@PathVariable Integer id){
		
		iStateService.eliminar(id);
		
		return new HttpResponseInvestment<String>(HttpStatusCodeInvestment.NO_CONTENT.getCode()
				,HttpStatus.NO_CONTENT,"Se elimino correctamente...");
	}
	
	private StateDto convertToDto(State state) {
		return mapper.map(state, StateDto.class);
	}

}
