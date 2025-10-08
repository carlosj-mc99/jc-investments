package org.com.jc.investments.configuration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HttpStatusCodeInvestment {

	OK(200),BAD_REQUEST(400),INTERNAL_SERVER_ERROR(500),CREATED(201),NO_CONTENT(204),UNAUTHORIZED(401),NOT_FOUND(404);
	
	private final int code;
}
