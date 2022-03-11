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
	}

	public NotaAlarma(String texto, LocalDateTime fechaAlarma, int minutosRepetir) {
		super(texto);
		this.fechaAlarma = fechaAlarma;
		this.minutosRepetir = minutosRepetir;
		this.activado = true;
	}

	//getter and setter
	public static int getMinutosRepetirPorDefecto() {
		return MINUTOS_REPETIR_POR_DEFECTO;
	}

	private void setFechaAlarma(LocalDateTime fechaAlarma) throws NotaAlarmaExecption {
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
		return super.toString() + "NotaAlarma [fechaAlarma=" + fechaAlarma + ", minutosRepetir=" + minutosRepetir + ", activado="
				+ activado + "]";
	}
	
//	public NotaAlarma clone() {
//		Nota resultado = super.clone();
//		NotaAlarma n2 = new NotaAlarma(super.getTexto());
//	}
}
