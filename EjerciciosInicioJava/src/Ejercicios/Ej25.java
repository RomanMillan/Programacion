package Ejercicios;

import java.util.Scanner;

/*
 * Realiza un programa que vaya pidiendo números hasta que se introduzca un número negativo
 * y nos diga:
 * - Cuantos números se han introducido.
 * - La media de los impares.
 * - El mayor de los pares. 
 * El número negativo sólo se utiliza para indicar el final de la introducción
 * de datos pero no se incluye en el cómputo.
 * */

public class Ej25 {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int num, cont = 0, mayor = -1, suma = 0, contImpar = 0;
		do {
			num = leerInt("Inserte un numero entero positivo (salir <0): ");
			// compruebo que el num es >= 0
			if (num >= 0) {
				cont++;
				// miro si el num es par
				if (sacarPar(num) == true) {
					// miro si el num es mayor.
					if (num > mayor) {
						mayor = num;
					}
				//contabilizo los impares para hacer la media
				} else {
					suma += num;
					contImpar++;
				}
			}
		} while (num >= 0);

		// mostrar los resultados
		System.out.println("Cantidad de numeros introducidos: " + cont);
		System.out.println("El mayor de los pares es: " + mayor);
		System.out.println("La media de los impares es: " + sacarMedia(suma, contImpar));

	}

	// metodo que lee enteros
	public static int leerInt(String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}

	// metodo para sacar los numeros pares:
	public static boolean sacarPar(int num) {
		boolean par = false;
		if (num % 2 == 0) {
			par = true;
		}
		return par;
	}

	// metodo que realiza una media de enteros
	public static double sacarMedia(int suma, int cantidad) {
		double media;
		media = suma / cantidad;
		return media;
	}

}
