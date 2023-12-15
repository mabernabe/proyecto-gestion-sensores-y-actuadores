package com.escuelait.gestionsensores.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Actuator")
public class Actuator extends Transductor{
	

	public Actuator() {
		super();
	}

	public Actuator(String name) {
		super(name);
	}

}
