package com.jacaranda.alquiler.vehiculos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Coche extends Vehiculo {

	private CarburanteEnum carburante;

	//constructor
	public Coche(String matricula, String gama, LocalDate fechaSalida, 
			String carburante) throws VehiculoException {
		super(matricula, gama, fechaSalida);
		this.carburante = CarburanteEnum.valueOf(carburante.toUpperCase());
	}

	//getter and setter
	public CarburanteEnum getCarburante() {
		return carburante;
	}

	public void setCarburante(String carburante) {
		this.carburante = CarburanteEnum.valueOf(carburante.toUpperCase());
	}

	//toString
	@Override
	public String toString() {
		return "Coche [carburante=" + carburante + "] " + super.toString();
	}
	
	//metodos
	@Override
	public double getPrecio() {
		return (super.getPrecio()  + this.carburante.getPrecio()) *
				this.getFechaSalida().until(getFechaEntrada(),ChronoUnit.DAYS);
	}
	
}
