package com.jacaranda.pruebaJson;

import java.io.BufferedReader;
import java.io.FileReader;

public class Principal {

	public static void main(String[] args) {
		String fichero = leerFichero("ficheros/prueba1.json");
		System.out.println("****************");
		System.out.println(fichero);
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
				System.out.println(linea);
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (Exception e) {
			System.out.println("No existe el fichero" + nombreFichero);
		}
		return resultado.toString();
	}

}
