package com.escuelait.gestionsensores.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Float")
public class FloatValue extends Value{
	
	public float value;
	

	public FloatValue() {
		super();
	}

	public FloatValue(float value) {
		super();
		this.value = value;
	}
	
	public boolean is(String operator, float value) {
		//TODO
		return false;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}

}
