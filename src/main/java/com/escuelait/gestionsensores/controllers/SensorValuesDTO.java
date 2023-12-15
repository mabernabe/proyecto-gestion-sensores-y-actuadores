package com.escuelait.gestionsensores.controllers;

import java.util.ArrayList;
import java.util.List;

import com.escuelait.gestionsensores.models.SensorValue;
import com.escuelait.gestionsensores.models.SensorValues;

public class SensorValuesDTO {
	
	
	private List<SensorValueDTO> values;
	
	private String date;
	
	public SensorValuesDTO(SensorValues values) {
		this.values = new ArrayList<SensorValueDTO>();
		this.date = values.getDate();
		for (SensorValue value: values.getValues()) {
			this.values.add(new SensorValueDTO(value));
		}
	}

	public List<SensorValueDTO> getValues() {
		return values;
	}

	public String getDate() {
		return date;
	}

}
