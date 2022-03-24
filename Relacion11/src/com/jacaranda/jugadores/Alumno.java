package com.jacaranda.jugadores;

import java.util.Objects;

public class Alumno {

	private String nombre;
	private String dni;
	
	//constructor
	public Alumno(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}

	//getter and setter
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	
	
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
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni);
	}

	//toString
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", dni=" + dni + "]";
	}
	
	
	
}
