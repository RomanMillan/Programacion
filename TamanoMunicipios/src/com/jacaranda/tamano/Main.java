package com.jacaranda.tamano;

import java.io.BufferedReader;
import java.io.FileReader;

import com.google.gson.Gson;

public class Main {

	public static TamanoMunicipioComunidad p = new TamanoMunicipioComunidad();
	
	public static void main(String[] args) {
		
		String fichero = leerFichero("fichero/tamanoMunicipioComunidad.json");
		//System.out.println(fichero);
		
		p.CargarDatos(fichero);
		System.out.println(p);
		//System.out.println(t);
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

}
