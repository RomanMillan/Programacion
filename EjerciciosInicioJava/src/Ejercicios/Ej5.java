package Ejercicios;

import java.util.Scanner;

/*
 * Realiza un método que reciba una hora por parámetro y que muestre 
 * luego buenos días, buenas tardes o buenas noches según la hora. 
 * Se utilizarán los tramos de 6 a 12, de 13 a 20 y de 21 a 5. respectivamente. 
 * Sólo se tienen en cuenta las horas.
 * */

public class Ej5 {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int hora;

		hora = leerInt("Inserte la hora: ");
		System.out.println(tramoHorario(hora));
		
	}

	// metodo para leer un entero
	public static int leerInt(String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}

	// metodo para saber el tramo horario.
	public static String tramoHorario(int hora) {
		String saludo;
		if (hora >= 6 && hora <= 12) {
			saludo = "buenas tardes";
		} else if (hora <= 20) {
			saludo = "buenas tardes";
		} else {
			saludo = "buenas noches";
		}
		return saludo;
	}

}
