package com.escuelait.gestionsensores.controllers;

import java.util.ArrayList;
import java.util.List;

import com.escuelait.gestionsensores.models.Sensor;

public class SensorsDTO {
	
	private ArrayList<SensorDTO> sensors = new ArrayList<SensorDTO>();
	
	public SensorsDTO() {};

	public SensorsDTO(List<Sensor> sensors) {
		for (int i = 0; i < sensors.size(); i++) {
			this.sensors.add(new SensorDTO(sensors.get(i)));
		}
	}

	public ArrayList<SensorDTO> getSensors() {
		return sensors;
	}



}
