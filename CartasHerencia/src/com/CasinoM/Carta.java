package com.CasinoM;

import java.util.Objects;

public class Carta {
	private int number;
	private String palo;
	
	//Constructor
	public Carta(int number, String palo) {
		super();
		
			this.number = number;
			this.palo = palo;
		
		
	}
	
	//Metodo para obtener valor, si el numero esta entre 1 y 7 
	//vale su numero si no 0.5
	public double getValor() {
		double valor;
		if(this.number<=7) {
			valor= this.number;
		}else {
			valor =0.5;
		}
		return valor;
	}

	/*
	 * Una carta es igual si tiene el mismo numero y palo
	 */
	@Override
	public int hashCode() {
		return Objects.hash(number, palo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		return number == other.number && Objects.equals(palo, other.palo);
	}
	
	//Metodo para mostrar nombre y palo
	public int getNumber() {
		return number;
	}
	
	public String getPalo() {
		return palo;
	}
	
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Carta resultado = new Carta(this.getNumber(), this.getPalo());
		return resultado;
	}

	@Override
	public String toString() {
		return "Carta [number=" + number + ", palo=" + palo + "]";
	}
	
	
	
	
	
	

}
