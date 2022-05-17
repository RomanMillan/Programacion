package Ejercicios;

import java.util.Scanner;

/*
 * Realiza un programa que sume los 100 números siguientes a un número entero y 
 * positivo introducido por teclado. 
 * 
 * Se debe comprobar que el dato introducido es correcto (que es un número positivo).
 * */
public class Ej21 {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int num;

		// comprobar que inserta correctamente el num requerido.
		do {
			num = leerInt("Inserte un numero positivo");
			if (num <= 0) {
				System.out.println("Error tiene que ser un numero positivo.");
			}
		} while (num <= 0);

		System.out.println("la suma es: " + siguente100num(num));
	}

	// metodo que lee un entero.
	public static int leerInt(String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}

	// metodo que suma los 100 siguentes num al insertado
	public static int siguente100num(int num) {
		int total = num;
		for (int i = 0; i < 100; i++) {
			total += ++num;
		}
		return total;
	}
}
