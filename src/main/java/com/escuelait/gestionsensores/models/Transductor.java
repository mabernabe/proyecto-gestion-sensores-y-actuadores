package com.escuelait.gestionsensores.models;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="transductor_type")
public class Transductor {
	
	@Id
	protected String name;
	
	protected boolean active;

	public Transductor() {
		super();
	}

	public Transductor(String name) {
		super();
		this.name = name;
		this.active = false;
	}

	public String getName() {
		return name;
	}

	public boolean isActive() {
		return active;
	}
	
	public void setActive() {
		this.active = true;
	}
	
}
