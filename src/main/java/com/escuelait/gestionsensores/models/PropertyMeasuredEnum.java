package com.escuelait.gestionsensores.models;


public enum PropertyMeasuredEnum {
	TEMPERATURE_CENTIGRADES(new FloatPropertyMeasured("Temperature", "C", -273, 1000)),
	TEMPERATURE_KELVIN(new FloatPropertyMeasured("Temperature", "K", 0, 1000)),
	HUMIDITY_PERCENTAGE(new FloatPropertyMeasured("Humidity", "%", 0, 100)),
	MOTION(new BooleanPropertyMeasured("Motion"));
	
	private PropertyMeasured propertyMeasured;

	private PropertyMeasuredEnum(PropertyMeasured propertyMeasured) {
		this.propertyMeasured = propertyMeasured;
	}

	public PropertyMeasured getPropertyMeasured() {
		return propertyMeasured;
	}

	public static PropertyMeasuredEnum getInstance(String string) {
		PropertyMeasuredEnum propertyMeasuredEnum= null;
		for (PropertyMeasuredEnum propertyMeasured : PropertyMeasuredEnum.values()) { 
			if (propertyMeasured.toString().equals(string)) {
				propertyMeasuredEnum = propertyMeasured;
			}; 
		}
		return propertyMeasuredEnum;
	}

	

}
