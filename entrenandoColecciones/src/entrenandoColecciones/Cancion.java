package entrenandoColecciones;

import java.util.Objects;

public class Cancion {

	private String nombre;
	private String autor;
	private double duracion;
	
	//constructores
	public Cancion(String nombre, String autor, double duracion) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.duracion = duracion;
	}

	
	//getter and setter
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}


	//hashCode and Equals (Nombre y Autor)
	@Override
	public int hashCode() {
		return Objects.hash(autor, nombre);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cancion other = (Cancion) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(nombre, other.nombre);
	}


	//toString
	@Override
	public String toString() {
		return "Cancion [nombre=" + nombre + ", autor=" + autor + ", duracion=" + duracion + "] \n";
	}
	
	
	
}
