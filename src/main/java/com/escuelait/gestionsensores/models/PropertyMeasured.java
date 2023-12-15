package com.escuelait.gestionsensores.models;

public interface PropertyMeasured {
	

	public String toString();
	
	public Value getValue(String value) throws ValueFormatException;

}
