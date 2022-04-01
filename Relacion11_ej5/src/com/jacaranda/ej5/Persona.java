package com.jacaranda.ej5;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public abstract class Persona {

	protected String nombre;
	private String dni;
	protected int edad;
	private List<Mensaje> recibidos;
	private List<Mensaje> enviados;
	
	
	//constructor
	public Persona(String nombre, String dni, int edad) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.recibidos = new LinkedList<>();
		this.enviados = new LinkedList<>();
	}
	
	


	//Metodos
	public void enviarMesaje(String mensaje, Persona persona) throws AlumnoException {	
		Mensaje m = new Mensaje(this.nombre, mensaje);
		//se lo añado a la lista de los que ha enviado este usuario
		enviados.add(m);
		//se lo añado a la lista del usuario que se lo he enviado
		persona.recibidos.add(m);
	}
	
	
	
	public List<Mensaje> getRecibidos() {
		return recibidos;
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




	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ", recibidos=" + recibidos
				+ ", enviados=" + enviados + "]";
	}


}

