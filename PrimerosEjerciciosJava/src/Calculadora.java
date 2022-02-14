/*
 * Calcular 2 numeros introducidos (sumar, restar, multiplicar o dividir)
 * */

import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		double num1, num2, resultado = 0;
		int resp;
		char decision;
		boolean error = false;

		// calculamos primero una operacion y despues preguntamos si desa seguir
		do {
			// pedimos que operación realizar
			System.out.print("Elige la operacion a realizar: 1 sumar, 2 restar, 3 multiplicar, 4 dividir: ");
			resp = Integer.parseInt(teclado.nextLine());

			// pedimos los numeros de la operación a realizar.
			System.out.print("Inserte su primer numero: ");
			num1 = Double.parseDouble(teclado.nextLine());

			System.out.print("Ingrese un segundo numero: ");
			num2 = Double.parseDouble(teclado.nextLine());

			// creamos un menu para cada caso.
			switch (resp) {
			case 1: {

				resultado = num1 + num2;
				break;
			}
			case 2: {

				resultado = num1 - num2;
				break;
			}
			case 3: {

				resultado = num1 * num2;
				break;
			}
			case 4: {
				if (num2 == 0) {
					System.out.println("no se puede dividir entre 0");
				} else {
					resultado = num1 / num2;
				}
				break;
			}

			default:
				System.out.println("Se ha producido un error");
				error = true;

			}
			
			//si no tiene ningun error nos dará el resultado.
			if (error == false) {
				System.out.println("El resultado es: " + resultado);
			}
			
			// preguntamos si desea realizar otra operación.
			System.out.println("¿Desea realizar otra operación? (S/N)");
			decision = teclado.nextLine().charAt(0);

		} while (decision != 'N');
		System.out.println("Fin del programa");
		teclado.close();

	}

}
