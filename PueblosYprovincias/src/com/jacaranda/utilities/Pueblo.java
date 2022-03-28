package com.jacaranda.utilities;

import java.util.Objects;

public class Pueblo implements Comparable<Pueblo> {

	private String nombre;
	private String codigo;
	private int numeroHabitantes;
	private double rentaPerCapita;
	private double superficie;

	// constructores
	public Pueblo(String nombre, String codigo, int numeroHabitantes, double rentaPerCapita, double superficie)
			throws PuebloException {
		super();
		setNombre(nombre);
		setCodigo(codigo);
		setNumeroHabitantes(numeroHabitantes);
		setRentaPerCapita(rentaPerCapita);
		setSuperficie(superficie);
	}

	public Pueblo(String nombre, String codigo) throws PuebloException {
		super();
		setNombre(nombre);
		setCodigo(codigo);
	}

	// getter and setter
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}

	public String getCodigo() {
		return codigo;
	}

	private void setCodigo(String codigo) throws PuebloException {
		if (codigo.length() >= 5) {
			for (int i = 0; i < codigo.length() - 1; i++) {
				if (codigo.charAt(i) < 48 || codigo.charAt(i) > 57) {
					throw new PuebloException("El codigo debe ser numerico");
				}
				this.codigo = codigo;
			}
		} else {
			throw new PuebloException("El codigo debe ser mayor o igual que 5");
		}
	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public void setNumeroHabitantes(int numeroHabitantes) throws PuebloException {
		if (numeroHabitantes < 0) {
			throw new PuebloException("El numero de habitantes no puede ser negativo");
		}
		this.numeroHabitantes = numeroHabitantes;
	}

	public double getRentaPerCapita() {
		return rentaPerCapita;
	}

	public void setRentaPerCapita(double rentaPerCapita) throws PuebloException {
		if (rentaPerCapita < 0) {
			throw new PuebloException("La renta no puede ser negativo");
		}
		this.rentaPerCapita = rentaPerCapita;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) throws PuebloException {
		if (superficie < 0) {
			throw new PuebloException("La superficie no puede ser negativa");
		}
		this.superficie = superficie;
	}

	// hasCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pueblo other = (Pueblo) obj;
		return Objects.equals(codigo, other.codigo);
	}

	// toString
	@Override
	public String toString() {
		return "Pueblo [nombre=" + nombre + ", codigo=" + codigo + ", " + "numeroHabitantes=" + numeroHabitantes
				+ ", reantaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + "]\n";
	}

	//ordenar por nombre
	@Override
	public int compareTo(Pueblo o) {
//		if(this.nombre.compareToIgnoreCase(o.getNombre())<0) {
//			return -1;
//		}else if(this.nombre.compareToIgnoreCase(o.getNombre())>0){
//			return 1;
//		}
//		return 0;
		
		if (o == null) {
			return -1;
		}
		return this.nombre.compareToIgnoreCase(o.getNombre());
		
	}

}


