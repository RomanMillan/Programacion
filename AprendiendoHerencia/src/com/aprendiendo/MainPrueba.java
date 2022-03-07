package com.aprendiendo;

public class MainPrueba {

	public static void main(String[] args) {

		//crear camion 
		Camion camion = new Camion(40.4);
		
		System.out.println(camion.dime_asientos());
		System.out.println(camion.velocidadC());
		
		System.out.println(camion.toString());
		
		Coche listaCoches [] = new Coche [5];
		Coche furgoneta1 = new Furgoneta(15,20);
		
		listaCoches [0] = camion;
		listaCoches [1] = furgoneta1;
		
		System.out.println(listaCoches[0].velocidadC());
		System.out.println(listaCoches[1].velocidadC());

	}

}
