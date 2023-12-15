package com.escuelait.gestionsensores.controllers;

public class TransductorDTO {
	
	private String name;
	
	private boolean active;

	public TransductorDTO(String name, boolean active) {
		super();
		this.name = name;
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public boolean isActive() {
		return active;
	}
	
	

}
