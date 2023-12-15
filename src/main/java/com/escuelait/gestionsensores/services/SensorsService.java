package com.escuelait.gestionsensores.services;

import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escuelait.gestionsensores.models.MQTTTransductorInterface;
import com.escuelait.gestionsensores.models.Sensor;
import com.escuelait.gestionsensores.models.SensorValues;
import com.escuelait.gestionsensores.models.TransductorInterface;
import com.escuelait.gestionsensores.models.TransductorInterfaceVisitor;
import com.escuelait.gestionsensores.mqtt.MQTTTransductorsController;
import com.escuelait.gestionsensores.repositories.SensorsRepository;


@Service
@Transactional
public class SensorsService implements TransductorInterfaceVisitor{
	
	@Autowired
	ApplyRulesService applyRulesService;
	
	@Autowired
	private SensorsRepository sensorsRepository;
	
	@Autowired
	private MQTTTransductorsController mqttTransductorsController;
	
	public List<Sensor> getAllSensors() {
		return sensorsRepository.findAll();
	}
	
	public void update(String sensorName, SensorValues values) {
		Sensor sensor = sensorsRepository.getOne(sensorName);
		assert(sensor!=null);
		sensor.setValues(values);
		sensor.setActive();
		sensorsRepository.saveAndFlush(sensor);
		applyRulesService.control(sensorName, values);	
	}

	public void newSensor(Sensor sensor) throws MqttTransductorInterfaceException  {
		setUpSensorInterface(sensor.getSensorInterface());
		sensorsRepository.save(sensor);
	}

	public void setUpSensorInterface(TransductorInterface sensorInterface) throws MqttTransductorInterfaceException {
		sensorInterface.accept(this);
	}
	

	@Override
	public void visit(MQTTTransductorInterface mqttTransductorInterface) throws MqttTransductorInterfaceException {
		try {
			mqttTransductorsController.subscribe(mqttTransductorInterface);
		} catch (MqttException e) {
			throw new MqttTransductorInterfaceException(e.getMessage());
		}
		
	}
	
	
	
	//public Sensor getByName(String sensorName) Java Optional??

}
