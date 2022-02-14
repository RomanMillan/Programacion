package ejercicios;

import java.util.Scanner;

/*
 * Programa que reciba 10 números y nos indique cuál de ellos es el máximo (el mayor).
 * */

public class Ej24 {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("El numero mayor es: " + numMayor());

	}
	//metodo que lee enteros
	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}
	
	//metodo que indica que numero es mayor.
	public static int numMayor() {
		int num,mayor= -99999;
		for (int i= 0;i<10;i++) {
			num = leerInt("Inserte un numero entero: ");
			if (num>mayor) {
				mayor = num;
			}
		}
		
		return mayor;
	}
	
}
