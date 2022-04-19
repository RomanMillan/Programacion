package com.jacaranda.diccionario2;

public class Principal {

	public static void main(String[] args) {
		Diccionario d = new Diccionario();
		d.anadirPalabra("Hola", "adfdfdf");
		d.anadirPalabra("Hola", "ddddds");
		System.out.println(d.toString());

		d.borrarSignificadoPalabra("Hola", "ddddds");
		System.out.println(d.toString());
		
		d.borrarPalabra("Hola");
		System.out.println(d.toString());

		
	}

}
