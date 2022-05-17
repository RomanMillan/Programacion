package Ejercicios;

import java.util.Scanner;

/*
 * Método que pida 5 números e indica si alguno es múltiplo de 3.
 * */
public class Ej20 {
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		multi3();
		
	}
	
	//metodo que imprimer si un numero es mulp de 3
	public static void multi3() {
		int num;
		for (int i = 0;i<5;i++) {
			num = leerInt("Inserte un numero: ");
			if (num%3 == 0) {
				System.out.println(num + " es multiplo de 3");
			}
		}
		
	}
	//metodo que lee un entero
	public static int leerInt (String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}
}
