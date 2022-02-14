package ejercicios;

import java.util.Scanner;

/*
 * Escribe un método que reciba por parámetro el día de la semana 
 * (Lunes, Martes, Miércoles, etc) y devuelva qué asignatura toca a 
 * primera hora ese día.*/

public class Ej2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Ingrese un dia de la semana: ");
		String dia = teclado.nextLine();
		
		switch (dia) {
		case "Lunes": {
			
			System.out.println("Entorno de desarrollo");
			break;
		}
		case "Martes": {
			
			System.out.println("Bases de datos");
			break;
		}
		case "Miercoles": {
	
			System.out.println("FOL");
		}
		case "Jueves": {
			
			System.out.println("FOL");
		}
		case "Viernes": {
			
			System.out.println("Programación");
		}
		default:
			System.out.println("Error al introducir un dia de la semana.");
		}
		teclado.close();
	}

}
