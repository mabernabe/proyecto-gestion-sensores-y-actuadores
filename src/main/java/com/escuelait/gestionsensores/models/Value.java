package com.escuelait.gestionsensores.models;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="value_type")
public abstract class Value {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

}
