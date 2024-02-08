package com.escuelait.gestionsensores.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.escuelait.gestionsensores.models.Sensor;
import com.escuelait.gestionsensores.repositories.SensorsRepository;

@Service
public class StartService  implements CommandLineRunner{
	
	@Autowired
	private SensorsRepository sensorsRepository;
	
	@Autowired
	private SensorsService sensorsService;

	@Override
	public void run(String... args) throws Exception {
		List<Sensor> sensors = sensorsRepository.findAll();
		for(Sensor sensor: sensors ) {
			sensorsService.setUpSensorInterface(sensor.getInterface());
		}
	}
	
	

}
