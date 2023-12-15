package com.escuelait.gestionsensores.models;

import com.escuelait.gestionsensores.services.MqttTransductorInterfaceException;

public interface TransductorInterfaceVisitor {
	
	public void visit(MQTTTransductorInterface mqttTransductorInterface) throws MqttTransductorInterfaceException;
	

}
