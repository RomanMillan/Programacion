package com.jacaranda.alquiler.vehiculos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Furgoneta extends Vehiculo{

	private double pMA;
	private final double PRECIO_PESO = 0.5;
	
	public Furgoneta(String matricula, String gama, LocalDate fechaSalida, double pMA) throws VehiculoException {
		super(matricula, gama, fechaSalida);
		this.pMA = pMA;
	}

	public double getpMA() {
		return pMA;
	}

	public void setpMA(double pMA) {
		this.pMA = pMA;
	}

	public double getPRECIO_PESO() {
		return PRECIO_PESO;
	}
	//TODO TERMINAR ESTO
	/*
	@Override
	public double getPrecio() {
		return super.getPrecio()  + pMA * PRECIO_PESO
				this.getFechaEntrada().until(getFechaSalida(),ChronoUnit.DAYS);
	}
	*/
	@Override
	public String toString() {
		return "Furgoneta [pMA=" + pMA + ", PRECIO_PESO=" + PRECIO_PESO + "]";
	}
	
	
	
}
