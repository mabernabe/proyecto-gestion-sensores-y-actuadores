package com.escuelait.gestionsensores.models;

public class ValueFormatException extends Exception {
	
	private static final long serialVersionUID = 1483306031357214783L;

	public ValueFormatException(String value) {
		super("Value: " + value + "has invalid format");
	}

	
	
}
