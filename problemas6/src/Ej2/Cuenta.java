package Ej2;

import java.util.Objects;

public class Cuenta {
	private String nombre;
	private double saldo;
	private int reintegro;
	private int ingreso;
	
	//constructor
	public Cuenta(String nombre, double saldo) {
		super();
		
		if (saldo >0) {
			this.saldo = saldo;
		}
		this.nombre = nombre;
		reintegro = 0;
		ingreso = 0;
	}

	//get and set
	public String getNombre() {
		return nombre;
	}

	public double getSaldo() {
		return saldo;
	}

	public int getReintegro() {
		return reintegro;
	}

	public int getIngreso() {
		return ingreso;
	}

	
	//metodos
	
	//metodo que hace un reintegro
	public boolean reintegro(double cantidad) {
		boolean realizado = false;
		if (cantidad < saldo && cantidad > 0) {
			saldo -= cantidad;
			reintegro ++;
			realizado = true;
		}	
		return realizado;
	}
	
	//metodo que hace un ingreso
	public boolean ingreso(double cantidad) {
		boolean realizado = false;
		if (cantidad>0) {
			saldo += cantidad;
			ingreso++;
			realizado = true;
		}
		return realizado;
	}
	
	
	//hastCode And equals
	@Override
	public int hashCode() {
		return Objects.hash(ingreso, reintegro, nombre, saldo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return ingreso == other.ingreso && reintegro == other.reintegro && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(saldo) == Double.doubleToLongBits(other.saldo);
	}
	
	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + ", reintegro=" + reintegro + ", ingreso=" + ingreso + "]";
	}

	

}
