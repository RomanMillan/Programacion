package Ejercicios;

import java.util.Scanner;

public class Ej22 {

	/*
	 * Leer un número y mostrar su cuadrado, repetir el proceso hasta que se
	 * introduzca un número negativo.
	 */

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int num;
		do {
			num = leerInt("Inserte un numero entero (salir <0): ");
			if (num>0) {
				System.out.println(Math.pow(num, 2));	
			}
		} while (num >= 0);
	}

	// metodo que lee entero
	public static int leerInt(String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}
}
