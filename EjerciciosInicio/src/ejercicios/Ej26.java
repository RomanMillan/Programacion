package ejercicios;

import java.util.Scanner;

/*
 * Crea un programa que permita sumar N números. 
 * El usuario decide cuándo termina de introducir números al indicar la palabra ‘fin’.
 * */

public class Ej26 {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("la suma es: " + sumaNum());
		
	}
	//metodo que permite leer double
	public static double leerDouble(String texto ) {
		System.out.print(texto);
		return Double.parseDouble(teclado.nextLine());
	}
	
	//metodo que permite leer String
	public static String leerString(String texto) {
		System.out.print(texto);
		return teclado.nextLine();
	}
	
	//metodo que permite sumar los numeros isnertados por el usuario
	public static double sumaNum() {
		double num, resultado = 0;
		String terminar;
		do {
			num = leerDouble("Inserte un numero: ");
			resultado += num;
			terminar = leerString("escribe fin si desea finalizar la suma u otra palabra para prosegir: ");
			
		}while(!(terminar.equals("fin")));
		return resultado;
	}
	
}
