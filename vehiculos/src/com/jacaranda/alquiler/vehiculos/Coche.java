package com.jacaranda.alquiler.vehiculos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Coche extends Vehiculo {

	private CarburanteEnum carburante;

	public Coche(String matricula, String gama, LocalDate fechaSalida, String carburante)
			throws VehiculoException {
		super(matricula, gama, fechaSalida);
		this.carburante = CarburanteEnum.valueOf(carburante.toUpperCase(null));
	}

	public CarburanteEnum getCarburante() {
		return carburante;
	}

	public void setCarburante(String carburante) {
		this.carburante = CarburanteEnum.valueOf(carburante.toUpperCase());
	}

	@Override
	public String toString() {
		return "Coche [carburante=" + carburante + "] " + super.toString();
	}
	
	@Override
	public double getPrecio() {
		return super.getPrecio()  + this.carburante.getPrecio() *
				this.getFechaEntrada().until(getFechaSalida(),ChronoUnit.DAYS);
	}
	
}
