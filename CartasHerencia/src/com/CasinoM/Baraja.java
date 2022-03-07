package com.CasinoM;

import java.util.Arrays;

public abstract class Baraja implements Repartible {
	protected int numCartas;
	private int siguiente;
	protected Carta[] listCarta ;

	
	//Constructor
	public Baraja(int numCartas) {
		super();
		this.numCartas=numCartas;
		this.siguiente=0;
		this.listCarta = new Carta[numCartas];

	}
	
	
	private int generarNumero() {
		int numero;
		numero= (int) ((Math.random()*(numCartas/4))+1);
		return numero;
	}
	
	protected abstract String generarPalo();

	protected abstract int numero();
	
	public void barajar(){
		int numero,cantidadCartas=0;
		String palo;
		int numeroCartasIntroducidas=0;
		boolean encontrado=false;
		//el primer elemento esta vacio ya que el numero random nunca es 0
		while(cantidadCartas< this.numCartas){
			numero= generarNumero();
			
			Carta nuevaCarta = new Carta(numero, generarPalo());
			for(int i=0;i<numeroCartasIntroducidas&& encontrado==false;i++) {
				if(nuevaCarta.getNumber()==listCarta[i].getNumber()&&nuevaCarta.getPalo().equals(listCarta[i].getPalo())) {
					encontrado = true;
				}
			}
			if(encontrado == false) {
				listCarta[cantidadCartas]= new Carta(nuevaCarta.getNumber(), nuevaCarta.getPalo());
				cantidadCartas+=1;
				numeroCartasIntroducidas+=1;
			}else {
				encontrado= false;
			}
			
		}
	}
	
	
	public Carta getCarta() {
		return listCarta[siguiente];
	}
	@Override
	public String toString() {
		return "Baraja [numCartas=" + numCartas + ", listCarta=" + Arrays.toString(listCarta) + "]";
	}
	@Override
	public Carta getSiguiente() {
		// TODO Auto-generated method stub
		Carta copia;
		if(this.siguiente== this.numCartas) {
			this.siguiente=0;
		}
		copia = new Carta(listCarta[this.siguiente].getNumber(), listCarta[this.siguiente].getPalo());
		this.siguiente+=1;
		
		return copia;
		
	}
	
	
	
}

