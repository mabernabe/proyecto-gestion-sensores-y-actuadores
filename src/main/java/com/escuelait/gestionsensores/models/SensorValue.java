package com.escuelait.gestionsensores.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sensorvalue")
public class SensorValue {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@Enumerated(EnumType.STRING)
	private PropertyMeasuredEnum propertyMeasured;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Value value;
		
	public SensorValue() {
		super();
	}


	public SensorValue(PropertyMeasuredEnum propertyMeasured, Value value) {
		super();
		this.propertyMeasured = propertyMeasured;
		this.value = value;
	}


	public PropertyMeasuredEnum getPropertyMeasured() {
		return propertyMeasured;
	}


	public Value getValue() {
		return value;
	}


}
