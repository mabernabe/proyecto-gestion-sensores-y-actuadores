package com.escuelait.gestionsensores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escuelait.gestionsensores.models.Sensor;

@Repository
public interface SensorsRepository extends JpaRepository<Sensor, String>{
	
	

}
