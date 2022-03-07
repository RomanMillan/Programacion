package com.CasinoM;

import java.util.Scanner;

public class Menu {
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		Baraja j = new BarajaEspannola();
		
		BarajaEspannola es = new BarajaEspannola();  
		
		System.out.println("Objeto BarajaEspañola: " + es.numero());
		
		System.out.println("Objeto  baraja: " + j.numero());
		
		j.getSiguiente();
		System.out.println(j.listCarta);
	}
}
