package Ejercicios;

import java.util.Scanner;

/*
 * Método que pida 15 números y escribir la suma total
 * */

public class Ej19 {
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("La suma total es: " + pedir15numSumar());
		
	}
	
	//metodo que pide 15 num y retorna la suma
	public static double pedir15numSumar() {
		double num,suma = 0;
		for(int i = 0;i<15;i++) {
			num = leerDouble("Inserte un numero para sumar: ");
			suma += num;
		}
		return suma;
	}
	
	// metodo que lee un double
	public static double leerDouble(String texto) {
		System.out.print(texto);
		return Double.parseDouble(teclado.nextLine());
	}
}
