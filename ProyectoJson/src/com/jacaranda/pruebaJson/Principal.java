package com.jacaranda.pruebaJson;

import java.io.BufferedReader;
import java.io.FileReader;import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Principal {

	public static void main(String[] args) {
		String fichero = leerFichero("ficheros/prueba1.json");
		//System.out.println("****************");
		//System.out.println(fichero);
		
		Gson gson = new Gson();
		
		//Persona p1 = gson.fromJson(fichero,Persona.class);
		//System.out.println(p1);
		
		
		ArrayList<Persona> personas =gson.fromJson(fichero,
				(new TypeToken<ArrayList<Persona>>(){}).getType());
		
		for(Persona p:personas) {
			System.out.println(p.toString());
		}
	
		String salida = gson.toJson(personas);
		System.out.println("informacion del string: ");
		System.out.println(salida);
	
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
