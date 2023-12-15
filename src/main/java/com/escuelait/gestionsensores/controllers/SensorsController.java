package com.escuelait.gestionsensores.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.escuelait.gestionsensores.models.Sensor;
import com.escuelait.gestionsensores.services.MqttTransductorInterfaceException;
import com.escuelait.gestionsensores.services.SensorsService;
import com.escuelait.gestionsensores.services.TransductorsService;


@RestController
@RequestMapping("${sensors.uri}")
public class SensorsController {
	
	@Autowired
	private SensorsService sensorsService;
	
	@Autowired
	private TransductorsService transductorsService;
		
	@RequestMapping(value="/", method = RequestMethod.GET)
	public SensorsDTO getAllSensors() {
		return new SensorsDTO(sensorsService.getAllSensors());					
	}
	
	@RequestMapping(value="/mqttsensors/", method = RequestMethod.POST)
	public ResponseEntity<Object> newMqttSensor(@Valid @RequestBody NewMqttSensorDTO newMqttSensorDTO) throws MqttTransductorInterfaceException   {
		Sensor sensor = newMqttSensorDTO.getSensor();
		if (transductorsService.exist(sensor.getName())) {
			ErrorDTO error = ErrorDTO.TRANSDUCTOR_ALREADY_EXIST;
			return new ResponseEntity<>(error, error.getHttpStatus());

		};
		sensorsService.newSensor(sensor);
		return new ResponseEntity<>(null, HttpStatus.CREATED);	
	}

}
