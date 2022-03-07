package com.CasinoM;

public class BarajaEspannola extends Baraja {
	
	public BarajaEspannola() {
		super(42);
	}
	
	@Override
	public int numero() {
		return 20;
	}
	

	@Override
	public String generarPalo() {
		// TODO Auto-generated method stub
		int numeroPalos;
		numeroPalos=(int) ((Math.random()*4)+1);
		String palos[]= {"","ORO","ESPADA","BASTO","COPA"};
		return palos[numeroPalos];
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	

}
