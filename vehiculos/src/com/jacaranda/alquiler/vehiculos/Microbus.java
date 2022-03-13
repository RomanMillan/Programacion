package com.jacaranda.alquiler.vehiculos;

import java.time.LocalDate;

public class Microbus extends Vehiculo{
	
	private int numPlazas;
	private final double precioPlaza =5;
	
	//constructor
	public Microbus(String matricula, String gama, LocalDate fechaSalida, 
			int numPlazas) throws VehiculoException {
		super(matricula, gama, fechaSalida);
		this.numPlazas = numPlazas;
	}

	//getter and setter
	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	public double getPrecioPlaza() {
		return precioPlaza;
	}

	//metodos
	@Override
	public double getPrecio() {
		return super.getPrecio() + (getNumPlazas()*precioPlaza);
	}
	
	//toString
	@Override
	public String toString() {
		return "Microbus [numPlazas=" + numPlazas + ", precioPlaza=" + precioPlaza + "]";
	}
	
	
}
