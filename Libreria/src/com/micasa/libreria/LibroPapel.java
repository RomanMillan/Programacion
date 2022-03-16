package com.micasa.libreria;

public class LibroPapel extends Libro{

	private double peso;
	private double precio;
	
	//constructor
	public LibroPapel(String titulo, String autor, String editorial, double peso, double precio) {
		super(titulo, autor, editorial);
		this.peso = peso;
		this.precio = precio;
	}
	
	
	//getter and setter
	public double getPeso() {
		return peso;
	}

	public double getPrecio() {
		return precio;
	}



	//toString
	@Override
	public String toString() {
		return super.getIsbn() + ", precio=" + precio + ". Peso:" + peso + "Libro:" + super.getTitulo();
	}
	
	
}
