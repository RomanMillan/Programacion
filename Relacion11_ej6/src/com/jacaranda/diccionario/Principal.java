package com.jacaranda.diccionario;

import java.util.Scanner;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		
		int opc;
		String palabra;
		PalabrasEmpiezan pE = null;
		Diccionario d = new Diccionario();
		
		do {
			menu();
			opc = leerInt("Inserta una opcion: ");
			
			switch (opc) {
			//anadir palabra en el diccionario
			case 1: {
				
				d.addListaPalabrasEmpiezan('A');
				pE.addPalabra("Andar", "noser esnf");
				pE.addPalabra("Andar", "mmmmmm");
				pE.addPalabra("Anchoa", "bla bla");
				d.addListaPalabrasEmpiezan('B');
				pE.addPalabra("Boca", "bla bla");
				System.out.println(pE.toString());
				
				break;
			}
			
			//buscar palabra en el diccionario
			case 2: {

				break;
			}
			
			//borrar una palabra del diccionario
			case 3: {
				palabra = leerString("Inserte la palabra a borrar: ");
				pE.delPalabra(palabra);
				System.out.println(pE.toString());
				break;
			}
			
			//listado de palabras que empiecen por ...
			case 4: {
				
				break;
			}
			
			//Salir.
			case 5: {
				System.out.println("Programa finalizado");
				break;
			}
			default:
				System.out.println("Error al insertar una opcion.");
			}
			
		}while(opc !=5);

	}
	
	public static void menu() {
		System.out.println("\n"
				+ "1. A�adir palabra.\n"
				+ "2. Buscar palabra en diccionario\n"
				+ "3. Borrar una palabra del diccionario\n"
				+ "4. Listado de palabras que empiecen por �\n"
				+ "5. Salir");
	}

	public static String leerString(String texto) {
		System.out.print(texto);
		return teclado.nextLine();
	}

	public static int leerInt(String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}
}
