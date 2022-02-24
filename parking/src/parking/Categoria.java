package parking;

import java.util.Objects;

public class Categoria {
	
	private String nombre;
	private double prcioPorMinuto;
	
	//constructor
	public Categoria(String nombre, double prcioPorMinuto) {
		super();
		this.nombre = nombre;
		this.prcioPorMinuto = prcioPorMinuto;
	}

	//get and set
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrcioPorMinuto() {
		return prcioPorMinuto;
	}

	public void setPrcioPorMinuto(double prcioPorMinuto) {
		this.prcioPorMinuto = prcioPorMinuto;
	}

	//hasCode and Equals
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
		Categoria other = (Categoria) obj;
		return Objects.equals(nombre, other.nombre);
	}

	//toString
	@Override
	public String toString() {
		return "Categoria [nombre=" + nombre + ", prcioPorMinuto=" + prcioPorMinuto + "]";
	}
	
	
	
}
