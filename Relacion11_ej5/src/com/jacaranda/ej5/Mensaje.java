package com.jacaranda.ej5;

import java.time.LocalDateTime;

public class Mensaje {

	private String remitente;
	private String mensaje;
	private LocalDateTime fechaEnvio;
	private int codigo;
	private static int codigoSiguente=1;
	
	
	//constructor
	public Mensaje(String remitente, String mensaje, LocalDateTime fechaEnvio) {
		super();
		this.remitente = remitente;
		this.mensaje = mensaje;
		this.fechaEnvio = fechaEnvio;
	}
	
	
	
}
