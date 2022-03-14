package com.jacaranda.notas;

import java.time.LocalDateTime;
import java.util.Objects;

public class Nota implements Comparable <Nota>{

	private static int codigoSiguiente = 0;
	private int codigo;
	private String texto;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaUltimaModificacion;
	
	//constructor
	public Nota(String texto) {
		super();
		this.texto = texto;
		fechaCreacion = LocalDateTime.now();
		codigo += ++codigoSiguiente;
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
		if (texto.isEmpty())
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
		this.fechaUltimaModificacion = LocalDateTime.now();
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


	protected void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	protected void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	protected void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

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

	@Override
	public int compareTo(Nota o) {
		int resultado;
		if(o == null) {
			resultado = -1;
		}else {
			resultado = this.texto.compareToIgnoreCase(o.texto);
			if (resultado == 0) {
				resultado = this.fechaCreacion.compareTo(o.fechaCreacion);
			}
		}
		return resultado;
	}

}
