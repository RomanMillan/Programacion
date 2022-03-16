package com.micasa.libreria;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Libro {

	private String titulo;
	private String autor;
	private String editorial;
	private LocalDate fechaEdicion;
	private String isbn;
	
	
	//constructores
	public Libro(String titulo, String autor, String editorial) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.fechaEdicion = LocalDate.now();
		isbn = generarISBN();
	}


	public Libro(String titulo, String autor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		fechaEdicion = LocalDate.now();
		isbn = generarISBN();
	}


	//getter and setter
	public String getEditorial() {
		return editorial;
	}


	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}


	public LocalDate getFechaEdicion() {
		return fechaEdicion;
	}


	public void setFechaEdicion(LocalDate fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	}


	public String getAutor() {
		return autor;
	}	
	
	public String getTitulo() {
		return titulo;
	}


	public String getIsbn() {
		return isbn;
	}
	
	
	//METODOS
	
	/*Calculo del ISBN
	 * - 3 primeros caracteres del titulo (sin espacios)
	 * - la longitud del titulo.
	 * - 3 ultiimos caracteres del autor (sin espacios)
	 * - la longitud del autor
	 * */



	//metodo que crea el isbn
	private String generarISBN() {
		//quitamos todos los espacios 
		String tituloAux = titulo;
		tituloAux = tituloAux.replaceAll(" ", "");
		
		String autorAux = autor;
		autorAux = autorAux.replaceAll(" ", "");
		
		//guardamos los datos en isbn
		isbn = tituloAux.substring(0, 3);
		isbn += titulo.length();
		isbn += autorAux.substring(0, 3);
		isbn += autor.length();
		
		return isbn;
	}


	//saber cuantos dias han pasado entre los dos libros
	public int diferenciaDias(Libro libroAcomparar) {
		int dias = 0;
		return dias = Math.abs(dias) + (int) this.fechaEdicion.until(libroAcomparar.fechaEdicion,ChronoUnit.DAYS);
	}

	
	//hascode and equals (isbn)
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}



	//toString
	@Override
	public String toString() {
		return "Libro: " + titulo + ". Autor: " + autor + ". ISBN: " + isbn;
	}
	
	
	
}
