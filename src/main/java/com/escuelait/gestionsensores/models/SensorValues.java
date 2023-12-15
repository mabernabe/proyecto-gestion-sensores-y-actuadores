package com.escuelait.gestionsensores.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SensorValues {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<SensorValue> values;
	
	private String date;
	
	public SensorValues() {
		super();
	}

	public SensorValues(List<SensorValue> values, String date) {
		super();
		this.values = values;
		this.date = date;
	}


	public List<SensorValue> getValues() {
		return values;
	}


	public String getDate() {
		return date;
	}


	public void add(SensorValue sensorValue) {
		this.values.add(sensorValue);	
	}	

}
