package com.escuelait.gestionsensores.controllers;

import java.util.ArrayList;
import java.util.List;

import com.escuelait.gestionsensores.models.PropertyMeasuredEnum;
import com.escuelait.gestionsensores.models.Sensor;

public class SensorDTO extends TransductorDTO{
	
	private SensorValuesDTO sensorValues;
	
	private List<String> propertiesMeasured;

	public SensorDTO(Sensor sensor) {
		super(sensor.getName(), sensor.isActive());
		this.sensorValues = sensor.isActive() ? new SensorValuesDTO(sensor.getValues()) : null;
		this.propertiesMeasured = new ArrayList<String>();
		for (PropertyMeasuredEnum property : sensor.getPropertiesMeasured()) {
			this.propertiesMeasured.add(property.toString());
		}
	}

	public SensorValuesDTO getSensorValues() {
		return sensorValues;
	}

	public List<String> getProperties() {
		return propertiesMeasured;
	}

}
