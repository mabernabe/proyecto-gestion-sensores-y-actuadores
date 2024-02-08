package com.escuelait.gestionsensores.controllers;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.escuelait.gestionsensores.models.MQTTTransductorInterface;
import com.escuelait.gestionsensores.models.PropertyMeasuredEnum;
import com.escuelait.gestionsensores.models.Sensor;

public class NewMqttSensorDTO {
	
	@NotBlank
	private String name;
	
	@NotEmpty
	private List<PropertyMeasuredEnum> propertiesMeasured;

	public NewMqttSensorDTO(String name, List<PropertyMeasuredEnum> propertiesMeasured) {
		super();
		this.name = name;
		this.propertiesMeasured = propertiesMeasured;
	}


	public Sensor getSensor() {
		MQTTTransductorInterface sensorInterface = new MQTTTransductorInterface(name);
		return new Sensor(name, propertiesMeasured, sensorInterface);
	}

	

	
	

}
