package com.escuelait.gestionsensores.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.escuelait.gestionsensores.services.MqttTransductorInterfaceException;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDTO errorDTO = ErrorDTO.INVALID_ENTITY;
        errorDTO.setMessage(ex.getLocalizedMessage());
        return new ResponseEntity<>(errorDTO, errorDTO.getHttpStatus());
    }
	
			
	@ExceptionHandler({MqttTransductorInterfaceException.class})
    public ResponseEntity<Object> handleTransductorInterfaceException(
    		MqttTransductorInterfaceException exception) {
		ErrorDTO errorDTO = ErrorDTO.MQTT_INTERFACE_EXCEPTION;
        errorDTO.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorDTO, errorDTO.getHttpStatus());
    }

}

