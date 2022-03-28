package com.jacaranda.utilities;

public class Principal {

	public static void main(String[] args) {
		
		//crear provincia.
		Provincia pr1=null;
		try {
			pr1 = new Provincia("sevilla", "55555");
		} catch (ProvinciaException e1) {
			System.out.println(e1.getMessage());
		}
		
		//a�ado un pueblo
		try {
			pr1.addPueblo("brenes", "11111", 4, 59, 88);
		} catch (ProvinciaException | PuebloException e) {
			System.out.println(e.getMessage());
		}
		
		
		//añado otro pueblo
		try {
			pr1.addPueblo("santiago", "22222", 10, 20, 156);
		} catch (ProvinciaException | PuebloException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(pr1.delPueblo("santiago"));
		
		
	}

}
