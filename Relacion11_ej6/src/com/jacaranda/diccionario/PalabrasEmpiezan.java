package com.jacaranda.diccionario;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PalabrasEmpiezan {

	private Character letra;
	private List listaPalabras;
	
	//constructor
	public PalabrasEmpiezan(char letra) {
		super();
		this.letra = letra;
		this.listaPalabras = new LinkedList<>();
	}
	
	public void addPalabra(String palabra, String significado) {
		if(palabra.startsWith(letra.toString(), 0)){	
			//mirar si la palabra esta
//			Iterator<Palabra> puntero = listaPalabras.iterator();
//			Palabra aux = null;
//			boolean salir = false;
//			while(puntero.hasNext()&&!salir) {
//				aux = puntero.next();
//				if(aux.getPalabra().equals(palabra)) {
//					salir = true;
//				}
//			}
//			if(salir == false) {
//				Palabra p = new Palabra(palabra,significado);
//				listaPalabras.add(p);
//			}else {
//				aux.setSignificado(significado);
//			}
			Palabra aux = new Palabra(palabra,significado);
			int pos = listaPalabras.indexOf(aux);
			if(pos == -1) {
				listaPalabras.add(aux);
			}else {
				((Palabra) listaPalabras.get(listaPalabras.indexOf(aux))).setSignificado(significado);
			}
		}
	}
	
	public void delPalabra(String palabra) {
		Iterator<Palabra> puntero = listaPalabras.iterator();
		Palabra aux = null;
		boolean salir = false;
		
		//mirar si la palabra esta y borrarla
		while(puntero.hasNext()&&!salir) {
			aux = puntero.next();
			if(aux.getPalabra().equals(palabra)) {
				salir = true;
				listaPalabras.remove(aux);
			}
		}	
	}

	@Override
	public String toString() {
		return "PalabrasEmpiezan [letra=" + letra + ", listaPalabras=" + listaPalabras + "]";
	}	
}
