package com.miCasa.zeteam;

import java.util.Objects;

public class Videojuego {

	private String nombre;
	private double precio;
	private int pegi;
	private String requisitos;
	private double horasJugadas;
	private Genero genero;
	private Contenido contenido;

	// constructor
	public Videojuego(String nombre, double precio) throws VideojuegoException {
		super();
		this.nombre = nombre;
		setPrecio(precio);
		horasJugadas = 0;
	}

	// getter and setter
	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	protected void setPrecio(double precio) throws VideojuegoException {
		if (precio < 0) {
			throw new VideojuegoException("El precio no puede ser menor a 0");
		}
		this.precio = precio;
	}

	public int getPegi() {
		return pegi;
	}

	public void setPegi(int pegi) throws VideojuegoException {
		if (pegi < 3 || pegi > 18) {
			throw new VideojuegoException("La edad pegi no puede ser menor a 3 ni mayor a 18");
		}
		this.pegi = pegi;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public double getHorasJugadas() {
		return horasJugadas;
	}

	public void setHorasJugadas(double horasJugadas) throws VideojuegoException {
		if (horasJugadas < 0) {
			throw new VideojuegoException("Las horas jugadas no pueden ser 0 o menor");
		}
		this.horasJugadas += horasJugadas;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		try {
			this.genero = Genero.valueOf(genero.toUpperCase());
		} catch (Exception e) {
			System.out.println("Genero no valido");
		}

	}

	public Contenido getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		try {
			this.contenido = Contenido.valueOf(contenido.toUpperCase());
		} catch (Exception e) {
			System.out.println("Contenido no permitido");
		}
	}

	// hashCode and Equals (nombre)
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videojuego other = (Videojuego) obj;
		return Objects.equals(nombre, other.nombre);
	}

	// toString
	@Override
	public String toString() {
		return "Videojuego [nombre=" + nombre + ", precio=" + precio + ", pegi=" + pegi +
				", requisitos=" + requisitos
				+ ", horasJugadas=" + horasJugadas + ", genero=" + genero + "] \n";
	}

}
