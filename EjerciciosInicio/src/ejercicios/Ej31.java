package ejercicios;

import java.util.Scanner;

/*
 * Elabora un programa que codifique una cadena, de tal modo que en el resultado se 
 * inviertan cada 2 caracteres. 
 * Los caracteres intercambiados no pueden volver a intercambiarse. 
 * 
 * Ejemplo:
 * Entrada -> Hola mundo
 * Salida -> oHalm nuod
 * */

public class Ej31 {

	public static Scanner teclado = new Scanner(System.in);

	// metodo principal(MAIN)
	public static void main(String[] args) {
		String cadena = leerString("Ingese una frase: ");
		System.out.println(inver2Caract(cadena));
	}

	// metodo que lee una cadena
	public static String leerString(String texto) {
		System.out.print(texto);
		return teclado.nextLine();
	}

	// metodo que invierte cada 2 caracteres
	public static String inver2Caract(String cadena) {
		String cadInver = "";
		int cont1 = 1,cont2 = 0;
		cadInver += cadena.charAt(1);
		cadInver += cadena.charAt(0);
		
		for (int i = 0;i<cadena.length()-3;i+=2) {
				
					cadInver += cadena.charAt(cont1 +=2);	

					cadInver += cadena.charAt(cont2+=2);
					
		}
		if (cadena.length()%2 !=0) {
			cadInver += cadena.charAt(cadena.length()-1);
		}
		
		return cadInver;
	}

}
