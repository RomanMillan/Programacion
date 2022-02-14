import java.util.Scanner;

/*
 * Comprueba si el numero es mayor o menor */

public class MayorOmenor {
	public static void main(String [] args) {
		Scanner teclado = new Scanner(System.in);
		
		double num1, num2;
		
		System.out.println("Inserte un numero: ");
		num1 = Double.parseDouble(teclado.nextLine());
		
		System.out.println("Inserte un segundo numero: ");
		num2 = Double.parseDouble(teclado.nextLine());
		
		if (num1 > num2) {
			System.out.println(num1 + " es mayor que " + num2);
		}else if (num2 > num1) {
			System.out.println(num1 + " es menor que " + num2);
		}else {
			System.out.println("Ambos numeros son iguales.");
		}
	}
}