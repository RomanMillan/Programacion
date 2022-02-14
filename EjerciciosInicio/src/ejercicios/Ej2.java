package ejercicios;

import java.util.Scanner;

/*
 * Escribe un m�todo que reciba por par�metro el d�a de la semana 
 * (Lunes, Martes, Mi�rcoles, etc) y devuelva qu� asignatura toca a 
 * primera hora ese d�a.*/

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
			
			System.out.println("Programaci�n");
		}
		default:
			System.out.println("Error al introducir un dia de la semana.");
		}
		teclado.close();
	}

}
