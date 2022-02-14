package Ej1;

import java.util.Objects;

public class Rectangulo {
	private double longitud = 1;
	private double ancho = 1;
	
	//constructor
	public Rectangulo() {

	}
	
	//get and set
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		if (longitud  >=0 && longitud <20) {
			this.longitud = longitud;	
		}
	}
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		if (ancho >= 0 && ancho <= 20) {
			this.ancho = ancho;	
		}
	}
	//metodos area y rectangulo
	public double perimetro() {
		double perimetro;
		perimetro = (longitud *2) + (ancho *2);
		
		return perimetro;
	}
	
	public double area() {
		double area;
		area = longitud * ancho;
		return area;
	}

	//hashCode AND equals
	@Override
	public int hashCode() {
		return Objects.hash(ancho, longitud);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangulo other = (Rectangulo) obj;
		return Double.doubleToLongBits(ancho) == Double.doubleToLongBits(other.ancho)
				&& Double.doubleToLongBits(longitud) == Double.doubleToLongBits(other.longitud);
	}

	//toString
	@Override
	public String toString() {
		return "Rectangulo [longitud=" + longitud + ", ancho=" + ancho + "]";
	}

	
}
