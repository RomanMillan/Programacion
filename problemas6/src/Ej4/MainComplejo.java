package Ej4;

import java.util.Scanner;

public class MainComplejo {
	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		
		double numReal,numImaginario;
		
		//pedimos el numero complejo
		numReal = leerDouble("Inserte el numero real: ");
		numImaginario = leerDouble("Inserte el numero imaginario: ");
		Complejo n1 = new Complejo(numReal, numImaginario);
		
		//pedimos el segundo numero complejo
		numReal = leerDouble("Inserte el numero real: ");
		numImaginario = leerDouble("Inserte el numero imaginario: ");
		Complejo n2 = new Complejo(numReal, numImaginario);
		
		//hacemos la suma de los dos numeros
		System.out.println("El resultado de la suma es: " + n1.suma(n2));
		
		//hacemos la resta de los dos numeros
		System.out.println("El resultado de la resta es: " + n1.resta(n2));
	}
	//metodo que lee double
	public static double leerDouble(String texto) {
		System.out.print(texto);
		return Double.parseDouble(teclado.nextLine());
	}
}
