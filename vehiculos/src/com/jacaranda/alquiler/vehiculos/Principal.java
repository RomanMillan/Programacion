package com.jacaranda.alquiler.vehiculos;

public class Principal {

	public static void main(String[] args) {
	Vehiculo v = null;
	try {
		v = new Vehiculo("4567gpz", "Baja", null);	
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	System.out.println(v);
	

	}

}
