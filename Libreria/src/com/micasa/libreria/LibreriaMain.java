package com.micasa.libreria;

import java.time.LocalDate;

public class LibreriaMain {

	public static void main(String[] args) {
		//creo dos libros de tipo libros
		Libro l1= new Libro("El quijote", "miguel de cervantes");
		Libro l2= new Libro("Alatriste", "arturo perez");
		
		//modifico las fechas
		l1.setFechaEdicion(LocalDate.of(2022, 11, 20));
		l2.setFechaEdicion(LocalDate.of(2022, 11, 15));
	
		//miro la diferencias de dias entre los libros publicados
		System.out.println(l1.diferenciaDias(l2));
		
		//miro el isbn de uno de los libros
		System.out.println(l1.getIsbn());
		
		//creo dos libros mas de diferentes tipos
		Libro l3 = null;
		try {
			l3 = new LibroDigital("los miserables", "victor hugo", "Arial", 20, "epub");
		} catch (LibroDigitalExption e) {
			System.out.println(e.getMessage());
		}
		
		Libro l4 = null;
		l4 = new LibroPapel("cementerio de animales", "stephen king", "Amaya", 0.80, 15);
		
		//compruebo que libro es mas barato
		if(((LibroPapel) l4).getPrecio()>(((LibroDigital)l3).getPrecio())){
			System.out.println("El libro " + l4.getTitulo() + " es mas caro que " + l3.getTitulo());
		}else {
			System.out.println("El libro " + l4.getTitulo() + " es mas barato que " + l3.getTitulo());
		}
		
		
		
	}

}
