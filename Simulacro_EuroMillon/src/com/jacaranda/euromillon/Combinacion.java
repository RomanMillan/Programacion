package com.jacaranda.euromillon;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class Combinacion {

	//He usado HashSet ya que es una coleccion de numeros que no necesitan 
	//estar ordenados.
	
	HashSet <Integer> numeros;
	HashSet <Integer> estrellas;
	
	//constructor
	public Combinacion(int n1, int n2, int n3, int n4, int n5, int est1, int est2) throws CombinacionException {
		super();
		numeros = new HashSet<>();
		estrellas = new HashSet<>();
		probarNum(n1, n2, n3, n4, n5);
		probarEst(est1, est2);
		this.numeros.add(n1);
		this.numeros.add(n2);
		this.numeros.add(n3);
		this.numeros.add(n4);
		this.numeros.add(n5);
		this.estrellas.add(est1);
		this.estrellas.add(est2);
		
	}
	
	//metodos que comprueban que los datos están bien insertados.
	private void probarNum(int n1, int n2, int n3, int n4, int n5) throws CombinacionException {
		if(n1<1 ||n1 >50 ||n2<1 ||n2>50||n3<1 ||n3>50||n4<1||n4>50||n5<1||n5>50) {
			throw new CombinacionException("Datos mal insertados");
		}
	}
	
	private void probarEst(int est1, int est2) throws CombinacionException {
		if(est1<1 ||est1>12||est2<1||est2>12) {
			throw new CombinacionException("Datos mal insertados");
		}
	}
	
	
	//metodos que generan un estring
	public String toStringNumeros() {
		Iterator<Integer> puntero =  numeros.iterator();
		String cadena="";
		while(puntero.hasNext()) {
			cadena += puntero.next() + "-";
		}
		return cadena;
	}
	
	public String toStringEstrellas() {
		Iterator<Integer> puntero =  estrellas.iterator();
		String cadena="";
		while(puntero.hasNext()) {
			cadena += puntero.next() + "-";
		}
		return cadena;
	}

	//metodo que comprueba la cantidad de aciertos.
	public int comprobarAciertos(Combinacion c) {
		int cant =0;
		int valor = 0;
		Iterator<Integer> puntero = c.numeros.iterator();
		while(puntero.hasNext()) {
			valor = puntero.next();
			if(this.numeros.contains(valor)) {
				cant++;
			}
		}
		
		Iterator<Integer> puntero2 = c.estrellas.iterator();
		while(puntero2.hasNext()) {
			valor = puntero2.next();
			if(this.estrellas.contains(valor)) {
				cant++;
			}
		}
		
		return cant;
	}
	
	
	//hashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(estrellas, numeros);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combinacion other = (Combinacion) obj;
		return Objects.equals(estrellas, other.estrellas) && Objects.equals(numeros, other.numeros);
	}
		
}
