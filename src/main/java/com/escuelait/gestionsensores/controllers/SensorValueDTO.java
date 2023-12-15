package com.escuelait.gestionsensores.controllers;

import com.escuelait.gestionsensores.models.SensorValue;

public class SensorValueDTO {
	
	private String propertyMeasured;
	
	private String value;
	
	public SensorValueDTO(SensorValue sensorValue) {
		this.value = sensorValue.getValue().toString();
		this.propertyMeasured = sensorValue.getPropertyMeasured().toString();
	}

	public String getPropertyMeasured() {
		return propertyMeasured;
	}

	public String getValue() {
		return value;
	}

}
