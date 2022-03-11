package com.jacaranda.alquiler.vehiculos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Vehiculo {

	private String matricula;
	private GamaEnumerado gama;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	
	public Vehiculo(String matricula, String gama, LocalDate fechaSalida) throws VehiculoException {
		super();
		this.matricula = matricula;
		this.gama = GamaEnumerado.valueOf(gama.toUpperCase());
		this.fechaEntrada = LocalDate.now();
		this.fechaSalida = fechaSalida;
		if(fechaSalida!=null ) {
			if(fechaSalida.isBefore(this.fechaEntrada))
				throw new VehiculoException("Fecha salida debe ser posterior ");
			this.fechaSalida = fechaSalida;	
		}else
			this.fechaSalida = null;
		
	}

	public String getGama() {
		return gama.toString();
	}

	public void setGama(String gama) {
		this.gama = GamaEnumerado.valueOf(gama.toUpperCase());
	}

	public String getMatricula() {
		return matricula;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}
	
	
	
	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(matricula, other.matricula);
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", gama=" + gama + ", fechaEntrada=" + fechaEntrada
				+ ", fechaSalida=" + fechaSalida + "]";
	}
	
	public double getPrecio() {
		if(fechaSalida ==null) {
			this.fechaSalida = LocalDate.now();
		}
		double resultado = gama.getPrecio()*(int)fechaSalida.until(fechaEntrada,ChronoUnit.DAYS);
	return resultado;
	}
}
