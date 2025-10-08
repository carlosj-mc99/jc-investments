package org.com.jc.investments.controller;

import java.util.List;

import org.com.jc.investments.configuration.HttpResponseInvestment;
import org.com.jc.investments.configuration.HttpStatusCodeInvestment;
import org.com.jc.investments.dtos.CityDto;
import org.com.jc.investments.entitys.City;
import org.com.jc.investments.service.ICityService;
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
@RequestMapping("/citys")
public class CityController {

	private final ICityService icityService;
	private final ModelMapper mapper;

	@PostMapping("/")
	private HttpResponseInvestment<CityDto> create(@RequestBody CityDto dto){
		
		City createCity= icityService.create(dto);
		
		return new HttpResponseInvestment<CityDto>( HttpStatusCodeInvestment.CREATED.getCode(),
				HttpStatus.CREATED,convertToDto(createCity));
	}
	
	@GetMapping("/")
	private HttpResponseInvestment<List<CityDto>> getAll(){
		
		return new HttpResponseInvestment<List<CityDto>>(HttpStatusCodeInvestment.OK.getCode(),HttpStatus.ACCEPTED
				,icityService.getAll().stream().map(this::convertToDto).toList());
	}

	@GetMapping("/{id}")
	private HttpResponseInvestment<CityDto> getById(@PathVariable Integer id){
		
		City getCity=icityService.getById(id);
		
		if(getCity != null) {
			
			return new HttpResponseInvestment<CityDto>(HttpStatusCodeInvestment.OK.getCode(),HttpStatus.ACCEPTED
					,convertToDto(getCity));
		}else {
			return new HttpResponseInvestment<CityDto>(HttpStatusCodeInvestment.NOT_FOUND.getCode(),HttpStatus.NOT_FOUND
					,null);
			
		}
		
	}

	@PutMapping("/{id}")
	private HttpResponseInvestment<CityDto> update(@PathVariable Integer id,@RequestBody CityDto dto){
		
		
		City getCity=icityService.actualizar(id, dto);
		
		if(getCity != null) {
			
			return new HttpResponseInvestment<CityDto>(HttpStatusCodeInvestment.OK.getCode(),HttpStatus.ACCEPTED
					,convertToDto(getCity));
		}else {
			return new HttpResponseInvestment<CityDto>(HttpStatusCodeInvestment.NOT_FOUND.getCode(),HttpStatus.NOT_FOUND, null);
			
		}
	}
	
	@DeleteMapping("/{id}")
	private HttpResponseInvestment<String> delete(@PathVariable Integer id){
		
		icityService.eliminar(id);
		
		return new HttpResponseInvestment<String>(HttpStatusCodeInvestment.NO_CONTENT.getCode()
				,HttpStatus.NO_CONTENT,"Se elimino correctamente...");
	}
	
	private CityDto convertToDto(City city) {
		return mapper.map(city, CityDto.class);
	}
}
