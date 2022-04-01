package com.jacaranda.ej5;

public class Alumno  extends Persona{

	public Alumno(String nombre, String dni, int edad) {
		super(nombre, dni,edad);
		
	}

	@Override
	public void enviarMesaje(String mensaje, Persona persona) throws AlumnoException {
	
		if(persona.edad<18) {
			throw new AlumnoException("No pude ser enviado a otro alumno");
		}
		Mensaje m = new Mensaje(persona.nombre, mensaje);
	}

}
