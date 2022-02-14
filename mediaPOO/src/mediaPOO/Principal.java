package mediaPOO;

import java.util.Scanner;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Media m1;
		int numero1, numero2;

		numero1 = leerInt("Inserte un numero: ");
		numero2 = leerInt("Inserte un segundo numero: ");
		m1 = new Media(numero1, numero2);

		System.out.println("La media es: " + m1.mediaN());
	
	}

	// metodo que lee enteros
	public static int leerInt(String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}
}
