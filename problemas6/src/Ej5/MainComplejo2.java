package Ej5;

import java.util.Scanner;

import Ej4.Complejo;

public class MainComplejo2 {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		Complejo n1,n2;
		double real,imaginario;
		int opc;
		do {
			System.out.println(menu());
			opc = leerInt("Inserte una opcion: ");
			switch (opc) {
			case 1: {
				real = leerDouble("Inserte el numero real: ");
				imaginario = leerDouble("Inserte el numero imaginario: ");
				n1 = new Complejo(real, imaginario);
				
				real = leerDouble("Inserte el numero real: ");
				imaginario = leerDouble("Inserte el numero imaginario: ");
				n2 = new Complejo(real, imaginario);
				System.out.println("La suma es: " + n1.suma(n2));
				break;
			}
			case 2:{
				real = leerDouble("Inserte el numero real: ");
				imaginario = leerDouble("Inserte el numero imaginario: ");
				n1 = new Complejo(real, imaginario);
				
				real = leerDouble("Inserte el numero real: ");
				imaginario = leerDouble("Inserte el numero imaginario: ");
				n2 = new Complejo(real, imaginario);
				System.out.println("La resta es: " + n1.resta(n2));
				break;
			}
			case 3:{
				System.out.println("Programa finalizado.");
				break;
			}
			default:
				System.out.println("Error al insertar la opcion.");
			}
		}while(opc !=3);
	}
	
	//metodo que lee double
	public static double leerDouble(String texto) {
		System.out.print(texto);
		return Double.parseDouble(teclado.nextLine());
	}
	
	//metodo que lee int
	public static int leerInt (String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}

	//metodo que muestra menu
	public static String menu() {
		String menu;
		menu = "\n"
				+ "1. Sumar complejos \n"
				+ "2. Restar complejos \n"
				+ "3. Salir \n";
		
		return menu;
	}
}
