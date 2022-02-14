package ejercicios;

import java.util.Scanner;

/*
 * Escribe un programa que muestre los n primeros términos de la serie de Fibonacci.
 *  El primer término de la serie de Fibonacci es 0, el segundo es 1 y el resto 
 *  se calcula sumando los dos anteriores, por lo que tendríamos que los términos 
 *  son 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144… 
 *  El número n se debe introducir por teclado.
 * */

public class Ej28 {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int num = leerInt("¿Cuantos numeros deseas mostrar?: ");
		System.out.println(numFibonacci(num));
	}

	// metodo que lee entero
	public static int leerInt(String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}

	// metodo que retorna lista fibonacci
	public static String numFibonacci(int num) {
		int num1 = 0, num2 = 1, cont = 3;
		String result = "";
		if (num <= 2) {
			if (num == 1) {
				result += num1 + ", ";
			} else {
				result += num1 + ", ";
				result += num2 + ", ";
			}
		}else if (num%2 == 0) {
			result += num1 + ", ";
			result += num2 + ", ";

			for (int i = 0; i < ((num /2)-1 ); i++) {
				num1 += num2;
				result += num1 + ", ";
				num2 += num1;
				result += num2 + ", ";
			}
		}else {
			if (num == 3) {
				result += num1 + ", ";
				result += num2 + ", ";
				num1 += num2;
				result += num1 + ", ";
			}else {
				result += num1 + ", ";
				result += num2 + ", ";

				for (int i = 0; i < (num /2); i++) {
					num1 += num2;
					result += num1 + ", ";
					if (cont<= num) {
						num2 += num1;
						result += num2 + ", ";	
					}
					cont +=3;
				}
			}
		}
		return result;
	}
}
