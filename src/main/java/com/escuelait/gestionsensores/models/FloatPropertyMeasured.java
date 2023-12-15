package com.escuelait.gestionsensores.models;

public class FloatPropertyMeasured implements PropertyMeasured{
	
	private String name;
	
	private String unit;
	
	private float minimum;
	
	private float maximum;

	public FloatPropertyMeasured(String name, String unit, float minimum, float maximum) {
		this.name = name;
		this.unit = unit;
		this.minimum = minimum;
		this.maximum = maximum;
	}

	@Override
	public String toString() {
		return this.name + " " + this.unit;
	}

	public String getUnit() {
		return unit;
	}

	public float getMinimum() {
		return minimum;
	}

	public float getMaximum() {
		return maximum;
	}


	
	@Override
	public Value getValue(String value) throws ValueFormatException{
		try {
			return new FloatValue(Float.parseFloat(value));
		} catch(  NullPointerException | NumberFormatException e) {
			throw new ValueFormatException(value);
		}		
	}
	
	

	
	

}
