package org.com.jc.investments.controller;

import java.util.List;

import org.com.jc.investments.dtos.CityDto;
import org.com.jc.investments.entitys.City;
import org.com.jc.investments.service.ICityService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	private ResponseEntity<CityDto> create(@RequestBody CityDto dto){
		
		City createCity= icityService.create(dto);
		
		return new ResponseEntity<CityDto>(convertToDto(createCity),HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	private ResponseEntity<List<CityDto>> getAll(){
		
		return new ResponseEntity<List<CityDto>>(icityService.getAll().stream().map(this::convertToDto).toList(),HttpStatus.ACCEPTED);
	}

	@GetMapping("/{id}")
	private ResponseEntity<CityDto> getById(@PathVariable Integer id){
		
		return new ResponseEntity<CityDto>(convertToDto(icityService.getById(id)),HttpStatus.ACCEPTED);
	}

	@PutMapping("/{id}")
	private ResponseEntity<CityDto> update(@PathVariable Integer id,@RequestBody CityDto dto){
		
		return new ResponseEntity<CityDto>(convertToDto(icityService.actualizar(id, dto)),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<String> delete(@PathVariable Integer id){
		
		icityService.eliminar(id);
		
		return new ResponseEntity<String>("Se elimino correctamente...",HttpStatus.NO_CONTENT);
	}
	
	private CityDto convertToDto(City city) {
		return mapper.map(city, CityDto.class);
	}
}
