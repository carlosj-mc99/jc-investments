package org.com.jc.investments.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(content = Include.NON_NULL)
public class UserTypeDto {

	private Integer idUserType;
	private String name;
	private boolean enabled;
}
