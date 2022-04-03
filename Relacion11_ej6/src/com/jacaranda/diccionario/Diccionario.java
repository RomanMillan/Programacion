package com.jacaranda.diccionario;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Diccionario {

	private Set<Palabra> palabras;

	//constructor
	public Diccionario() {
		super();
		palabras = new HashSet<>();
	}
	
	//metodos
	public void agregarPalabra(Palabra palabra) {
		palabras.add(palabra);
	}
	
	public void borrarPalabra(String nombre) {
		Iterator<Palabra> p = palabras.iterator();
		Palabra aux;
		boolean encontrado = false;
		
		while(p.hasNext()&& !encontrado) {
			aux = p.next();
			if(aux.getPalabra().equalsIgnoreCase(nombre)) {
				encontrado = true;
				palabras.remove(aux);
			}
		}
	}

	public String buscarPalabra(String nombre) {
		StringBuilder p = new StringBuilder();
		Palabra aux;
		boolean encontrado = false;
		
		
		Iterator<Palabra> pApuntador = palabras.iterator();
		while(pApuntador.hasNext()&& !encontrado) {
			aux = pApuntador.next();
			if(aux.getPalabra().equalsIgnoreCase(nombre)) {
				encontrado = true;
				p.append(aux.toString());
			}
		}
		return p.toString();
	}
	
	public String listaInicio(String inicial) {
		StringBuilder pInicial = new StringBuilder();
		for(Palabra p: palabras) {
			if(p.getPalabra().startsWith(inicial)) {
				pInicial.append(p.getPalabra()+"\n");
			}
		}
		return pInicial.toString();
	}
	
	//toString
	@Override
	public String toString() {
		return "Diccionario [palabras=" + palabras + "]";
	}
	
	
}
