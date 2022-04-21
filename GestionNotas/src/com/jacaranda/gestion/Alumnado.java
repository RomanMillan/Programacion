package com.jacaranda.gestion;

import java.util.Objects;

public class Alumnado {

	private String nombre;
	private String dni;
	private String correoE;
	
	//constructores
	public Alumnado(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}
	public Alumnado(String nombre, String dni, String correoE) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.correoE = correoE;
	}
	
	//getter and setter
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreoE() {
		return correoE;
	}
	public void setCorreoE(String correoE) {
		this.correoE = correoE;
	}
	public String getDni() {
		return dni;
	}
	
	//hashCode
	
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumnado other = (Alumnado) obj;
		return Objects.equals(dni, other.dni);
	}
	@Override
	public String toString() {
		return "Alumnado [nombre=" + nombre + ", dni=" + dni + ", correoE=" + correoE + "]";
	}
	
	
}
