package ejercicios;

import java.util.Scanner;

/*
 * Pedir números hasta que se teclee uno negativo, y mostrar cuántos números 
 * se han introducido.
 * */

public class Ej23 {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(contNumeros());
	}

	// metodo que lee un double.
	public static double leeDouble(String texto) {
		System.out.println(texto);
		return Double.parseDouble(teclado.nextLine());
	}

	// metodo que cuenta cuantos numeros insertados
	public static int contNumeros() {
		double num;
		int contador = 0;
		do {
			num = leeDouble("Inserte un numero (salir <0)");
			if (num > 0) {
				contador++;
			}
		} while (num >0);
		return contador;
	}
}
