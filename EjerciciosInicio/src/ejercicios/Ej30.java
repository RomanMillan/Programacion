package ejercicios;

import java.util.Scanner;

/*
 * Realizar un método que dada una cadena de entrada, comprueba si es una 
 * contraseña FUERTE o DÉBIL. 
 * Se considera que una contraseña es fuerte:
 *- contiene 8 o más caracteres, 
 *- una mayúscula, 
 *- una minúscula, 
 *- un signo de puntuación 
 *- un dígito.
 * */

public class Ej30 {

	public static Scanner teclado = new Scanner(System.in);

	// metodo principal(MAIN)
	public static void main(String[] args) {
		boolean fuerte;
		String contrasena;

		contrasena = leerString("Inserte una contraseña: ");
		fuerte = compContrasena(contrasena);

		// imprimir si es debil o fuerte la contraseña
		if (fuerte == true) {
			System.out.println("Contraseña fuerte");
		} else {
			System.out.println("Contraseña débil");
		}

	}

	// metodo que lee una cadena
	public static String leerString(String texto) {
		System.out.print(texto);
		return teclado.nextLine();
	}

	// metodo que comprueba una contraseña
	public static boolean compContrasena(String contrasena) {
		boolean fuerte = false, mayus = false, minus = false, punt = false, digi = false;
		
		if (contrasena.length() >= 8) {
			int cont = 0;
			while ((cont < contrasena.length()) && (mayus == false || minus == false || punt == false || digi == false)) {
				
				//sacar el ascii de cada caracter
				int charC = contrasena.charAt(cont);
				
				// comprobar si tiene mayuscula
				if (charC >= 65 && charC <= 90 && mayus == false) {
					mayus = true;
				}
				// comprobar si tiene minuscula
				if (charC >= 97 && charC <= 122 && minus == false) {
					minus = true;
				}
				// comprobar si tiene signo de puntacion
				if (charC == 46 && punt == false) {
					punt = true;
				}
				// comprobar si tiene un digito
				if (charC >= 48 && charC <= 57 && digi == false) {
					digi = true;
				}
				cont++;
			}
			if(mayus==true && minus == true && punt == true && digi== true) {
				fuerte = true;
			}
		}
		return fuerte;
	}
}
