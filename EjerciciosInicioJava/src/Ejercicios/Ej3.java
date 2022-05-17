package Ejercicios;

import java.util.Scanner;

/*
 *Escribir un método que reciba un carácter y devuelva el tipo que es. 
 *Debe devolver una de las se imprimir los siguientes mensajes según corresponda.
 *      ◦ Letra mayúscula
        ◦ Letra minúscula
        ◦ Dígito entre 0 y 9
        ◦ Signo de puntuación
        ◦ Espacio en blanco
        ◦ Paréntesis () o llaves {}
        ◦ Otro carácter
 * */

public class Ej3 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		// preguntar por un caracter
		System.out.print("Inserte un caracter: ");
		char carac = teclado.nextLine().charAt(0);

		// sacar el codigo ascii de un caracter
		int codAscii = (int) carac;

		// mirar donde coincide el numero del codigo ascii
		if (codAscii >= 65 && codAscii <= 90) {
			System.out.println("El caracter " + carac + " es: Letra mayúscula.");
		} else if (codAscii >= 97 && codAscii <= 122) {
			System.out.println("El caracter " + carac + " es: Letra minuscula.");
		} else if (codAscii >= 48 && codAscii <= 57) {
			System.out.println("El caracter " + carac + " es: Dígito numérico.");
		} else if (codAscii == 46) {
			System.out.println("El caracter " + carac + " es: Signo de puntación.");
		} else if (codAscii == 32) {
			System.out.println("El caracter " + carac + " es: Espacio en blanco.");
		} else if (codAscii == 123 || codAscii == 125 || codAscii == 40 || codAscii == 41) {
			System.out.println("El caracter " + carac + " es: Paréntesis () o llaves {}.");
		} else {
			System.out.println("El caracter " + carac + " es: Otro caracter.");
		}
		teclado.close();

	}

}
