package com.jacaranda.utilities;

public class Principal {

	public static void main(String[] args) {
		
		//crear provincia. (PI_01)
		Provincia pr1=null;
		try {
			pr1 = new Provincia("sevilla", "55");
		} catch (ProvinciaException e1) {
			System.out.println(e1.getMessage());
		}
		
		//crear provincia, nombre null (PI_02)
		try {
			Provincia pr2 = new Provincia(null,"55");
		} catch (ProvinciaException e) {
			System.out.println(e.getMessage());
		}
		
		//crear provincia, codigo null (PI_03)
		try {
			Provincia pr2 = new Provincia("sevilla",null);
		} catch (ProvinciaException e) {
			System.out.println(e.getMessage());
		}
				
		//crear provincia, codigo 1 caracter (PI_04)
		try {
			Provincia pr2 = new Provincia("sevilla","1");
		} catch (ProvinciaException e) {
			System.out.println(e.getMessage());
		}
		
		//crear provincia, codigo 3 caracter (PI_05)
		try {
			Provincia pr2 = new Provincia("sevilla","111");
		} catch (ProvinciaException e) {
			System.out.println(e.getMessage());
		}		
		
		//añadir un pueblo a la lista vacia (PI_06)
		try {
			pr1.addPueblo("Brenes", "11111", 14000, 24000, 540);
		} catch (ProvinciaException | PuebloException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(pr1.listadoNombresPueblos());
		
		//añadir pueblo repetido a la provincia (PI_07)
		try {
			pr1.addPueblo("Brenes", "11111", 14000, 24000, 540);
		} catch (ProvinciaException | PuebloException e) {
			System.out.println(e.getMessage());
		}
		
		//añadir pueblo con renta per capita negativa (PI_08)
		try {
			pr1.addPueblo("Torrelodones", "22222", 200, -40, 505);
		} catch (ProvinciaException | PuebloException e) {
			System.out.println(e.getMessage());
		}
		
		//añadir pueblo con superficie negativa (PI_09)
		try {
			pr1.addPueblo("Torrelodones", "22222", 200, 40, -505);
		} catch (ProvinciaException | PuebloException e) {
			System.out.println(e.getMessage());
		}
		
		//añadir pueblo con poblacion negativa (PI_10)
		try {
			pr1.addPueblo("Torrelodones", "22222", -200, 40, 505);
		} catch (ProvinciaException | PuebloException e) {
			System.out.println(e.getMessage());
		}
	}
}
