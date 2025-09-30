package org.com.jc.investments.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(content = Include.NON_NULL)
public class CompanyDto {

	private Integer idCompany;
	private String name;
	private Integer idAddres;
	private Integer phone;
	private String email;
}
