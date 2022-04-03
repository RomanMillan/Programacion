package com.jacaranda.diccionario;

import java.util.Scanner;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		
		int opc;
		String palabra, significado;
		Palabra p;
		Diccionario d = new Diccionario();
		
		do {
			menu();
			opc = leerInt("Inserta una opcion: ");
			
			switch (opc) {
			//añadir palabra en el diccionario
			case 1: {
				palabra = leerString("Inserte el nombre de la palabra: ");
				significado = leerString("Inserte el significado de la palabra: ");
				p = new Palabra(palabra, significado);
				d.agregarPalabra(p);
				break;
			}
			
			//buscar palabra en el diccionario
			case 2: {
				palabra = leerString("Inerte la palabra a buscar: ");
				System.out.println(d.buscarPalabra(palabra));
				break;
			}
			
			//borrar una palabra del diccionario
			case 3: {
				palabra = leerString("Inserte la palabra a borrar: ");
				d.borrarPalabra(palabra);
				break;
			}
			
			//listado de palabras que empiecen por ...
			case 4: {
				palabra = leerString("Inserta la inicial a buscar: ");
				System.out.println(d.listaInicio(palabra));
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
				+ "1. Añadir palabra.\n"
				+ "2. Buscar palabra en diccionario\n"
				+ "3. Borrar una palabra del diccionario\n"
				+ "4. Listado de palabras que empiecen por …\n"
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
