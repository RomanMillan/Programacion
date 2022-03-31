package com.jacaranda.ej5;

import java.util.Objects;

public abstract class Persona {

	private String nombre;
	private String dni;
	private int edad;
	
	
	//constructor
	public Persona(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}


	//Metodos
	public void enviarMesaje(Mensaje mensaje, String nombre) {
		
	}
	
	
	//hashCode and Equals (dni)
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
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}


}
