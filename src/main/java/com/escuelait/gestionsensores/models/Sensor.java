package com.escuelait.gestionsensores.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@DiscriminatorValue("Sensor")
public class Sensor extends Transductor{
	
	@OneToOne(cascade=CascadeType.ALL)
	private SensorValues values;
	
	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	@Enumerated(EnumType.STRING)
	private List<PropertyMeasuredEnum> propertiesMeasured;
	
	@OneToOne(cascade=CascadeType.ALL)
	private TransductorInterface sensorInterface;

	public Sensor() {
		super();
	}

	public Sensor(String name, List<PropertyMeasuredEnum> properties, TransductorInterface sensorInterface) {
		super(name);
		this.values = null;
		this.propertiesMeasured = properties;
		this.sensorInterface = sensorInterface;
	}

	public SensorValues getValues() {
		return values;
	}

	public List<PropertyMeasuredEnum> getPropertiesMeasured() {
		return propertiesMeasured;
	}

	public TransductorInterface getInterface() {
		return sensorInterface;
	}

	public void setValues(SensorValues values) {
		this.values = values;
	}

}
