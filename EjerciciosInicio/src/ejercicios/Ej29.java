package ejercicios;

import java.util.Scanner;

/*
 * Realiza un programa que pida un número por teclado y que luego muestre ese 
 * número al revés. 
 * Utilizar cadenas para facilitar la tarea
 * */

public class Ej29 {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int num = leerInt("Inserte un numero: ");
		System.out.println(numReves(num));

	}
	//metodo que lee entro
	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}

	//metodo que reversa un numero
	public static String numReves(int num) {
		String numC ="",nuevoN = "";
		numC += num;
		
		for (int i = numC.length()-1;i>-1;i--){
			nuevoN += numC.charAt(i);
		}
		return nuevoN;
	}
}


