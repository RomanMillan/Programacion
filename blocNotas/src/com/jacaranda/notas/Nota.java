package com.jacaranda.notas;

import java.time.LocalDateTime;
import java.util.Objects;

public class Nota implements Comparable {

	private static int codigoSiguiente;
	private int codigo =0;
	private String texto;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaUltimaModificacion;
	
	//constructor
	public Nota(String texto) {
		super();
		this.texto = texto;
		fechaCreacion = LocalDateTime.now();
		codigoSiguiente += ++codigo;
	}

	//metodos
	/**
	 * Mira si fecha ultima modificacion está vacía.
	 * @return
	 */
	public boolean isModificado() {
		boolean modificado = false;
		if (fechaUltimaModificacion != null) 
			modificado = true;
		return modificado;
	}
	
	/**
	 * miramos si tenemos el texto vacío
	 * @return
	 */
	public boolean isEmpty() {
		boolean empty = false;
		if (texto.equals(""))
			empty = true;
		return empty;
	}
	
	public boolean isCreadoAnterior(Nota notaAmirar){
		boolean anterior = false;
		if(this.fechaCreacion.isBefore(notaAmirar.fechaCreacion))
			anterior = true;
		return anterior;
	}

	public boolean isModificadoAnterior(Nota notaAmirar) {
		boolean modificadoAnterior = false;
		if(this.fechaUltimaModificacion.isBefore(notaAmirar.fechaUltimaModificacion))
			modificadoAnterior = true;
		return modificadoAnterior;
	}
	
	//getter and setter
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getCodigo() {
		return codigo;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDateTime getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public int compareTo(Object nota) {
		int resultado = 0;
		Nota notaAcomparar = (Nota) nota;
		if(this.codigo>notaAcomparar.getCodigo()) {
			resultado = 1;
		}else if(this.codigo<notaAcomparar.getCodigo()) {
			resultado = -1;
		}
		return resultado;
	}
	
//	public int compareTo(Object nota) {
//		int resultado = 0;
//		Nota notaAcomparar = (Nota) nota;
//		if(this.texto.equalsIgnoreCase(notaAcomparar.getTexto())) {
//			resultado = 1;
//		}else if(this.codigo<notaAcomparar.getCodigo()) {
//			resultado = -1;
//		}
//		return resultado;
//	}
//	
	//hashCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(fechaCreacion, texto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(fechaCreacion, other.fechaCreacion) && Objects.equals(texto, other.texto);
	}

	//toString
	@Override
	public String toString() {
		return "Nota [ codigo=" + codigo + ", texto=" + texto
				+ ", fechaCreacion=" + fechaCreacion + ", fechaUltimaModificacion=" + fechaUltimaModificacion + "]";
	}
	
	//TODO PREGUNTAR QUE HAY QUE HACER
	public int compareTo(Nota notaAcomparar) {
		return -1;
	}
	
}
