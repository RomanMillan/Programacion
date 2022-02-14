package ejercicios;

import java.util.Scanner;

public class Ej1 {
	/*
	 * ARealizar un método que reciba dos números y devuelva True si uno es múltiplo del otro.
	 * */

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		
		int num1 = leerInt("Inserte un numero: ");
		int num2 = leerInt("Inserte otro numero: ");
		if (multiplo(num1,num2) == true) {
			System.out.println("Es multiplo");
		}else {
			System.out.println("No es multiplo");
		}
		
		
	}
	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}
	
	public static boolean multiplo(int num1,int num2) {
		boolean multiplo = false;
		if (num1%num2 == 0) {
			multiplo = true;
		}
		return multiplo;
	}
}
