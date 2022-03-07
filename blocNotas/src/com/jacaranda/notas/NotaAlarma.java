package com.jacaranda.notas;

import java.time.LocalDateTime;

public class NotaAlarma extends Nota {

	private LocalDateTime fechaAlarma;
	private static final int MINUTOS_REPETIR_POR_DEFECTO = 5;
	private int minutosRepetir;
	private boolean activado;
	
	public NotaAlarma(String texto,LocalDateTime fecha,boolean activado) {
		super(texto);
		
	}

}
