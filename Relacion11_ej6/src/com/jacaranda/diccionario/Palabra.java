package com.jacaranda.diccionario;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Palabra {

	private String palabra;
	private Set<String> significado;
	
	//constructor
	public Palabra(String palabra, String significado) {
		super();
		this.palabra = palabra;
		this.significado = new HashSet<>();
		this.significado.add(significado);
	}

	//getter and setter
	public String getPalabra() {
		return palabra;
	}

	public String getSignificado() {
		return this.significado.toString();
	}

	public void setSignificado(String significado) {
		this.significado.add(significado);
	}

	//hashCode and equals (palabra)
	@Override
	public int hashCode() {
		return Objects.hash(palabra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Palabra other = (Palabra) obj;
		return Objects.equals(palabra, other.palabra);
	}

	@Override
	public String toString() {
		return "Palabra [palabra=" + palabra + ", significado=" + significado + "]";
	}

	
	
	
	
}
