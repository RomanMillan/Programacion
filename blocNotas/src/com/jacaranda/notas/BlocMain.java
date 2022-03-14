package com.jacaranda.notas;

import java.time.LocalDateTime;


public class BlocMain {

	public static void main(String[] args) {
		//crear un par de notas
		Nota n1 = new Nota("Salir a pasear");
		Nota n2 = null;
		Nota n3 = new Nota("Cocinar la cena");
		
		try {
			n2 = new NotaAlarma("comprar comida",LocalDateTime.now(), false);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//mostramos la informacion de la notas
		System.out.println(n1.toString());
		System.out.println(n2.toString());
		
		//agregamos las notas a un bloc
		Bloc b1 = new Bloc("Tareas del hogar");
		try {
			b1.agregarNota(n1);
			b1.agregarNota(n2);
			b1.agregarNota(n3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//activamos la alarma a una nota de tipo alarma
		try {
			b1.activa(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(n2.toString());
		
		//intentamos activar la alarma de una nota sin tipo alarma
		try {
			b1.activa(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//mostramos el bloc sin ordenar
		System.out.println(b1.toString());
		
		//Ordenamos y mostramos el bloc
		System.out.println(b1.ordenaBloc());

	}
	

}
