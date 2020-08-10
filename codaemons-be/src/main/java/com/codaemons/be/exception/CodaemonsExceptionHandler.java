package com.codaemons.be.exception;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CodaemonsExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value= {CodaemonsResourceException.class})
	public final ResponseEntity<ErrorResponse> handleCodaemonsResourceException(CodaemonsResourceException ex, WebRequest request){
		ErrorResponse errorResponse = new ErrorResponse(ex.getLocalizedMessage(), new ArrayList<>());
		return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
}
