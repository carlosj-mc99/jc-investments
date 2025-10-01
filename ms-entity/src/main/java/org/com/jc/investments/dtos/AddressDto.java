package org.com.jc.investments.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(content = Include.NON_NULL)
public class AddressDto {

	private Integer idAddress;
	private String street;
	private String internalNumber;
	private String externalNumber;
	private String suburb;
	private boolean enabled;
	private StateDto state;
	private String postalCode;
}
