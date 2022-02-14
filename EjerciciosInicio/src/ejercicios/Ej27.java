package ejercicios;

import java.util.Scanner;

/*
 * Pedir 10 sueldos. 
 *- Mostrar su suma 
 * - cuantos hay mayores de 1000€.
 * */

public class Ej27 {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println(sueldos());

	}
	//metodo que lee double
	public static double leeDouble(String texto) {
		System.out.println(texto);
		return Double.parseDouble(teclado.nextLine());
	}
	
	//metodo que pide los sueldos y muestra 
	public static String sueldos() {
		double sueldo,suma = 0,cont = 0;
		String resultado = "";
		for (int i = 0;i<10;i++) {
			sueldo = leeDouble("Inserte el sueldo: ");
			suma += sueldo;
			if (sueldo >1000) {
				cont ++;
			}
		}
		resultado +=  "Total: " + suma+ " € //" +" Cantidad de sueldos mayor de 1000€: " + (int) cont;
		return resultado;
	}
}
