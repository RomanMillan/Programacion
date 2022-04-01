package com.jacaranda.ej5;

import java.time.LocalDateTime;
import java.util.Objects;

public class Mensaje implements Comparable<Mensaje>{

	private String remitente;
	private String mensaje;
	private LocalDateTime fechaEnvio;
	private int codigo;
	private static int codigoSiguente=1;
	
	
	//constructor
	public Mensaje(String remitente, String mensaje) {
		super();
		this.remitente = remitente;
		this.mensaje = mensaje;
		this.fechaEnvio = LocalDateTime.now();
		this.codigo = codigoSiguente++;
	}

	
	public String getMensaje() {
		return mensaje;
	}

	public LocalDateTime getFechaEnvio() {
		return fechaEnvio;
	}

	public int getCodigo() {
		return codigo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensaje other = (Mensaje) obj;
		return codigo == other.codigo;
	}


	@Override
	public String toString() {
		return "Mensaje [remitente=" + remitente + ", mensaje=" + mensaje + ", fechaEnvio=" + fechaEnvio + ", codigo="
				+ codigo + "]";
	}


	@Override
	public int compareTo(Mensaje o) {
		if(o==null) {
			return -1;
		}
		return this.fechaEnvio.compareTo(o.fechaEnvio);
	}
	
	
	
}
