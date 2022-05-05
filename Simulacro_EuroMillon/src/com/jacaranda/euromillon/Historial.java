package com.jacaranda.euromillon;

import java.time.LocalDate;
import java.util.Map;

public class Historial {

	 Map <LocalDate, Combinacion> h;
	 
	public Historial(LocalDate f, Combinacion c) {
		super();
		addSorteo(f,c);
	}

	public boolean addSorteo(LocalDate f, Combinacion c) {
		Map l;
		l.put(c, l);
		boolean anadido =false;
		if(!this.h.containsKey(l)) {
			this.h = l;
		}
		return anadido;
	}
	
	public borrar() {
		
	}
	
}
