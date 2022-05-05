package com.jacaranda.euromillon;

import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {
		Combinacion p =null;
		Combinacion k = null;
		try {
			p = new Combinacion(1, 1, 1, 7, 6, 11, 3);
			k = new Combinacion(6, 1, 9, 4, 50, 7, 8);
		} catch (CombinacionException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(p.comprobarAciertos(k));
	
		
	}

}
