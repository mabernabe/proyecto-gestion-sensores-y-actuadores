package com.escuelait.gestionsensores.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("boolean")
public class BooleanValue extends Value{
	
	private boolean value;
	

	public BooleanValue() {
		super();
	}

	public BooleanValue(boolean value) {
		super();
		this.value = value;
	}
	
	public boolean is(boolean value) {
		return this.value == value; 
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}

}
