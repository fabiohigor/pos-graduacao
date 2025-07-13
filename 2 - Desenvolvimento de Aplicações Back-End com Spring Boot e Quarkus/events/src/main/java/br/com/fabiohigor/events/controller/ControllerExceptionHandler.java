package br.com.fabiohigor.events.controller;

import br.com.fabiohigor.events.dto.ErrorDTO;
import br.com.fabiohigor.events.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(exception = NotFoundException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundException(NotFoundException ex) {
        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage());
        return ResponseEntity.status(404).body(errorDTO);

    }
}
