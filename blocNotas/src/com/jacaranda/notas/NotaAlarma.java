package com.jacaranda.notas;

import java.time.LocalDateTime;

public class NotaAlarma extends Nota implements Activable {

	private LocalDateTime fechaAlarma;
	private static final int MINUTOS_REPETIR_POR_DEFECTO = 5;
	private int minutosRepetir;
	private boolean activado;
	
	//constructores
	public NotaAlarma(String texto,LocalDateTime fecha,boolean activado) throws NotaAlarmaExecption {
		super(texto);
		setFechaAlarma(fecha);
		this.activado = activado;
		minutosRepetir = MINUTOS_REPETIR_POR_DEFECTO;
	}

	public NotaAlarma(String texto, LocalDateTime fechaAlarma, int minutosRepetir) {
		super(texto);
		this.fechaAlarma = fechaAlarma;
		this.minutosRepetir = minutosRepetir;
		this.activado = true;
	}

	//getter and setter
	public static int getMINUTOS_REPETIR_POR_DEFECTO() {
		return MINUTOS_REPETIR_POR_DEFECTO;
	}

	private void setFechaAlarma(LocalDateTime fechaAlarma) throws NotaAlarmaExecption {
		if(fechaAlarma == null) {
			throw new NotaAlarmaExecption("La fecha de alarma no puede ser nula");
		}
		if(super.getFechaCreacion().isAfter(fechaAlarma)) {
			throw new NotaAlarmaExecption("La fecha de alarma no es valida.");
		}else {
			this.fechaAlarma = fechaAlarma;	
		}
	}

	//metodos 
	@Override
	public void activar() {
		this.activado = true;
	}
	
	@Override
	public void desactivar() {
		this.activado = false;
	}
	
	public boolean isActivado() {
		return activado;
	}

	@Override
	public String toString() {
		return super.toString() + "NotaAlarma [fechaAlarma=" + fechaAlarma + ", minutosRepetir=" 
	+ minutosRepetir + ", activado="
				+ activado + "]";
	}

	@Override
	public NotaAlarma clone() throws CloneNotSupportedException {
		NotaAlarma nueva = null;
		try {
			nueva = new NotaAlarma(getTexto(), fechaAlarma, activado);
			nueva.setCodigo(getCodigo());
			nueva.setFechaCreacion(getFechaCreacion());
			nueva.setFechaUltimaModificacion(getFechaUltimaModificacion());
		} catch (NotaAlarmaExecption e) {
			throw new CloneNotSupportedException("Imposible clonar");
		}
		return nueva;
	}

}
