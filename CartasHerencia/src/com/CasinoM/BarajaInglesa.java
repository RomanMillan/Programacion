package com.CasinoM;

public class BarajaInglesa extends Baraja {
	
	public BarajaInglesa() {
		super(52);
	}
	
	@Override
	public String generarPalo() {
		// TODO Auto-generated method stub
		int numeroPalos;
		numeroPalos=(int) ((Math.random()*4));
		
		return PalosBrajaInglesa.values()[numeroPalos].toString();
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder resultado=new StringBuilder("Baraja Inglesa\n");
		for(int i =0 ;i<super.numCartas;i++) {
			if(super.listCarta[i].getNumber()<=10) {
				resultado.append(super.listCarta[i].getNumber());
				
			}else {
				if(super.listCarta[i].getNumber()==11) {
					resultado.append("J");
				}
				else if(super.listCarta[i].getNumber()==12) {
					resultado.append("Q");
				}
				else {
					resultado.append("K");
				}
			}
			resultado.append("" + super.listCarta[i].getPalo()+"\n");
		}
		return resultado.toString();
	}
}
