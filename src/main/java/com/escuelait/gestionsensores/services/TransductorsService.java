package com.escuelait.gestionsensores.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.escuelait.gestionsensores.repositories.TransductorsRepository;

@Service
@Transactional
public class TransductorsService {
	
	@Autowired
	private TransductorsRepository transductorsRepository;

	public boolean exist(String name) {
		return transductorsRepository.findById(name).isPresent();
		
	}

}
