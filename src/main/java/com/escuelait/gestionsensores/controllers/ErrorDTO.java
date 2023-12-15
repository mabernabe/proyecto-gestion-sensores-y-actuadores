package com.escuelait.gestionsensores.controllers;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorDTO {
	TRANSDUCTOR_ALREADY_EXIST("Sensor or actuator with that name already exist", HttpStatus.UNPROCESSABLE_ENTITY),
	INVALID_ENTITY("", HttpStatus.BAD_REQUEST),
	MQTT_INTERFACE_EXCEPTION("", HttpStatus.INTERNAL_SERVER_ERROR);
	
	private String message;
	
	private final HttpStatus httpStatus;

	private ErrorDTO(String message, HttpStatus httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}
	
	public String getError() {
		return httpStatus.getReasonPhrase();
	}
	
	public int getStatus() {
		return httpStatus.value();
	}

	@JsonIgnore
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setMessage(String string) {
		this.message = string;	
	}
}
