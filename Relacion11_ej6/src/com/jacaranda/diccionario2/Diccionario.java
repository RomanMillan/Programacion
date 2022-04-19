package com.jacaranda.diccionario2;

import java.util.HashMap;
import java.util.HashSet;

public class Diccionario {

	private HashMap<String,HashSet<String>> palabras;

	//constructor
	public Diccionario() {
		this.palabras = new HashMap<>();
	}

	//metodo que añade palabra
	public boolean anadirPalabra(String palabra, String significado) {
		boolean resultado = true;
		//mirar si la palabra ya está en el diccionario.
		
		HashSet<String> valor = this.palabras.get(palabra);
		
		if(valor== null) {
			//creo el hashSet, le añado el significado y añado al mapa.
			HashSet<String> significados = new HashSet <>();
			significados.add(significado);
			if(this.palabras.put(palabra, significados)==null) {
				resultado = false;
			}
		}else { // En caso de que la palabra ya esté en el diccionario
			resultado = valor.add(significado);
		}
		
		
		return resultado;
	}

	//metodo para borrar la palabra
	public boolean borrarPalabra(String palabra) {
		HashSet<String> valor = this.palabras.get(palabra);
		return palabras.remove(palabra, valor);
	}
	
	//metodo que borra el significado de la palabra
	public boolean borrarSignificadoPalabra(String palabra, String significado) {
		HashSet<String> valor = this.palabras.get(palabra);
		return valor.remove(significado);
	}
	
	//toString
	@Override
	public String toString() {
		return "Diccionario [palabras=" + palabras + "]";
	}
	
	
}
