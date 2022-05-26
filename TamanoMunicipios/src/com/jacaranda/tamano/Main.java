package com.jacaranda.tamano;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import com.google.gson.Gson;

public class Main {

	public static TamanoMunicipioComunidad p = new TamanoMunicipioComunidad();
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String fichero = leerFichero("fichero/tamanoMunicipioComunidad.json");
		
		p.CargarDatos(fichero);
		System.out.println(p);
		int opc;
		do {
			menu();
			opc = leerInt("Inserta una opcion: ");
			
			switch (opc) {
			case 1:
				int anio = leerInt("Inserte un año: ");
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				System.out.println("Programa finalizado");
				break;
			default:
				System.out.println("Error al insertar una opcion");
			}	
		} while (opc !=5);
		
		
		
	}
	
	
	private static String leerFichero(String nombreFichero) {
		String linea;
		StringBuilder resultado = new StringBuilder();
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while(linea != null) {
				resultado.append(linea);
				//System.out.println(linea);
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (Exception e) {
			System.out.println("No existe el fichero" + nombreFichero);
		}
		return resultado.toString();
	}
	
	
	public static void menu() {
		System.out.println("\n"
				+ "1. Mostrar los datos del año elegido \n"
				+ "2. Mostrar los datos de una comunidad y un año \n"
				+ "3. Añadir un dato \n"
				+ "4. Comprobar que el valor de Total es la suma de todos los valores \n"
				+ "5. Salir ");
	}
	
	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}
	

}
