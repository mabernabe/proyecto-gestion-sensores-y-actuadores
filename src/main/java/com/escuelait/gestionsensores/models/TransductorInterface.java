package com.escuelait.gestionsensores.models;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.escuelait.gestionsensores.services.MqttTransductorInterfaceException;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="interface_type")
public abstract class TransductorInterface {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	private TransductorInterfaceType type;

	public TransductorInterface() {
		super();
	}

	public int getId() {
		return id;
	}

	public TransductorInterfaceType getType() {
		return type;
	}

	public void setType(TransductorInterfaceType type) {
		this.type = type;
	}

	public abstract void accept(TransductorInterfaceVisitor transductorInterfaceVisitor) throws MqttTransductorInterfaceException;
	
	

}
