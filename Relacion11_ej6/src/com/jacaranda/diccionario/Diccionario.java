package com.jacaranda.diccionario;


import java.util.ArrayList;
import java.util.List;

public class Diccionario {

	private List<PalabrasEmpiezan> palabrasEmpiezan;
	
	
	//constructor
	public Diccionario() {
		super();
		palabrasEmpiezan = new ArrayList<>();
	}
	
	public void addListaPalabrasEmpiezan(Character caracter){
		for (int i = 65; i < 90; i++) {
			PalabrasEmpiezan aux = new PalabrasEmpiezan((char) i);
			this.palabrasEmpiezan.add(aux);
		}
		
	}

	public void addPalabra( String palabra, String significado) {
		PalabrasEmpiezan aux  = new PalabrasEmpiezan ( palabra.charAt(0));
		this.palabrasEmpiezan.get(this.palabrasEmpiezan.indexOf(aux)).addPalabra(palabra, significado);
	}
	
	
}
