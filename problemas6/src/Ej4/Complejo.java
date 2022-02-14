package Ej4;

import java.util.Objects;

import Ej4.Complejo;

public class Complejo {

	private double numReal;
	private double numImaginario;
	
	//constructor
	public Complejo(double numReal, double numImaginario) {
		super();
		this.numReal = numReal;
		this.numImaginario = numImaginario;
	}

	//get and set
	public double getNumReal() {
		return numReal;
	}

	public double getNumImaginario() {
		return numImaginario;
	}

	//Metodos
	//metodo que suma dos numeros complejos
	public Complejo suma(Complejo num2) {
		double real, imaginario;
		Complejo n3;
		real = this.numReal + num2.numReal;
		imaginario = this.numImaginario + num2.numImaginario;
		n3 = new Complejo(real, imaginario);
		return n3;
	}
	
	//metodo que resta dos numeros complejos
	public Complejo resta(Complejo num2) {
		double real,imaginario;
		Complejo n3;
		real = this.numReal - num2.numReal;
		imaginario = this.numImaginario - num2.numImaginario;
		n3 = new Complejo(real, imaginario);
		return n3;
	}
	
	
	//Hascode and equals
	@Override
	public int hashCode() {
		return Objects.hash(numImaginario, numReal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complejo other = (Complejo) obj;
		return Double.doubleToLongBits(numImaginario) == Double.doubleToLongBits(other.numImaginario)
				&& Double.doubleToLongBits(numReal) == Double.doubleToLongBits(other.numReal);
	}
	//toString
	@Override
	public String toString() {
		if (numImaginario >0) {
		return numReal + " + " + numImaginario +"i";
		
		}else if (numImaginario == 0) {
			return " " + numReal;
		}else {
			return numReal + " " + numImaginario + "i";
		}
		
	}
}
