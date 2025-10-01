package org.com.jc.investments.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(content = Include.NON_NULL)
public class CompanyDto {

	private Integer idCompany;
	private String name;
	private AddressDto address;
	private Integer phone;
	private String email;
}
