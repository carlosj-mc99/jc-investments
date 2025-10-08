package org.com.jc.investments.configuration;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class HttpResponseInvestment<T> {

	private final int httpStatusCode;
	private final HttpStatus httpStatus;
	private final T body;
}
