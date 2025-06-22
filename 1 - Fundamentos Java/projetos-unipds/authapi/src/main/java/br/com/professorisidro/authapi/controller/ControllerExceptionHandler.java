package br.com.professorisidro.authapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRuntime(RuntimeException ex){
		return ResponseEntity.status(403).body(ex.getMessage());
	}

}
