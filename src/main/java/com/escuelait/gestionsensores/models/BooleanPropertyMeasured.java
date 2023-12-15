package com.escuelait.gestionsensores.models;

public class BooleanPropertyMeasured implements PropertyMeasured{
	
	private String name;
	
	public BooleanPropertyMeasured(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return this.name;
	}


	public Value getValue(String value) throws ValueFormatException {
		if (value != null && (value.equalsIgnoreCase("true") || (value.equalsIgnoreCase("false")))) {		
			return new BooleanValue(Boolean.valueOf(value));
		} else {
			throw new ValueFormatException(value);
		}
	}
	
	

}
