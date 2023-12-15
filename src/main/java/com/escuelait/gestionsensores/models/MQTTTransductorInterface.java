package com.escuelait.gestionsensores.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.escuelait.gestionsensores.services.MqttTransductorInterfaceException;

@Entity
@DiscriminatorValue("MQTTSensorInterface")
public class MQTTTransductorInterface extends TransductorInterface{
	
	private String topic;
	

	public MQTTTransductorInterface() {
		super();
	}

	public MQTTTransductorInterface(String transductorName) {
		super();
		this.setType(TransductorInterfaceType.MQTT);
		this.topic = transductorName;
	}

	public String getTopic() {
		return topic;
	}

	@Override
	public void accept(TransductorInterfaceVisitor transductorInterfaceVisitor) throws MqttTransductorInterfaceException {
		transductorInterfaceVisitor.visit(this);
	}
	
	

}
