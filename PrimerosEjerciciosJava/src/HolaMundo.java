import java.util.Scanner;

public class HolaMundo {

	public static void main(String[] args) {
		
		//para identar automaticamente Ctrl + Mays  + f
		
		Scanner teclado = new Scanner(System.in);

		int a;
		char opc;
		double real, result;
		System.out.println("¿Quieres calcular la suma(S/N)");
		opc = teclado.nextLine().charAt(0);
		System.out.println("Inserte un numero: ");
		a = Integer.parseInt(teclado.nextLine());

		System.out.println("Inserte un real: ");
		real = Double.parseDouble(teclado.nextLine());

		result = a + real;

		System.out.println("El valor de sumar " + a + " + " + real + " = " + result);
		System.out.println("la opcion elegida es: " + opc);

		int num1 = 5, num2 = 2;

		result = (double) num1 / num2;

		System.out.println("la division es: " + result);
		
		/*
		 * 
		 * Ejrcicio programa que calcule una caulculadora 
		 * y otro donde diga si un numero es mayor o menor */

	}
}
