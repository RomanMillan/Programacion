package com.jacaranda.ej5;

import java.util.ArrayList;

public class Pricipal {

	public static void main(String[] args) {
		Persona p1 = new Profesor("Juan", "165df",60);
		
		Persona p2 = new Alumno("Draculilla", "51454f", 17);
		Persona p3 = new Alumno("Vela", "dfd15", 17);
		
		try {
			p1.enviarMesaje("no vienes a clase", p2);
		} catch (AlumnoException e) {
			e.getMessage();
		}
		
		System.out.println(p2.toString());
		
		try {
			p3.enviarMesaje("Quedamos en el bar", p2);
		} catch (AlumnoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			p2.enviarMesaje("Las clases son importantes", p1);
		} catch (AlumnoException e) {
			System.out.println(e.getMessage());
		}
		
		ArrayList<Mensaje> lista = new ArrayList<>();
		lista.add(new Mensaje("Juan", "HOla"));
		
	}

}
