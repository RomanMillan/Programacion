package com.jacaranda.gestion;

public class Modulo {
	private String nombre;
	private int codigo;
	private static int codigoSiguiente = 0;
	private int numHorasSemanales;
	private int creditos;
	
	//constructores
	public Modulo(String nombre, int numHorasSemanales, int creditos) {
		super();
		this.nombre = nombre;
		this.numHorasSemanales = numHorasSemanales;
		this.creditos = creditos;
		codigo = ++codigoSiguiente;
	}
	public Modulo(String nombre) {
		super();
		this.nombre = nombre;
		codigo = ++codigoSiguiente;
		
	}

	//getter and setter
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public static int getCodigoSiguiente() {
		return codigoSiguiente;
	}
	public static void setCodigoSiguiente(int codigoSiguiente) {
		Modulo.codigoSiguiente = codigoSiguiente;
	}
	public int getNumHorasSemanales() {
		return numHorasSemanales;
	}
	public void setNumHorasSemanales(int numHorasSemanales) {
		this.numHorasSemanales = numHorasSemanales;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public int getCodigo() {
		return codigo;
	}
	
	
	
	//toString
	@Override
	public String toString() {
		return "Modulos [nombre=" + nombre + ", codigo=" + codigo + ", numHorasSemanales=" + numHorasSemanales
				+ ", creditos=" + creditos + "]";
	}
	
	
	
}
