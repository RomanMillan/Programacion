package sieteYmedia;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Baraja {

	private final  int NUM_CARTAS = 48;
	private int siguente;
	private Carta listaCartas[];
	private int numeroCartas;

	//constructor
	public Baraja() {
		 listaCartas = new Carta [NUM_CARTAS];
		 siguente = 0;
	}

	//get and set
	public int getSiguente() {
		return siguente;
	}

	//metodos
	public void barajar() throws CartaException, BarajaException {
		int numeroCarta;
		String palo;
		boolean encontrado = false;
		ThreadLocalRandom r1 = ThreadLocalRandom.current();
		ThreadLocalRandom r2 = ThreadLocalRandom.current();
		String listaPalo [] = {"Oro","Basto","Copa","Espada"};
		numeroCarta = r1.nextInt(1,12);
		int Npalo = r2.nextInt(1,4);
		palo = listaPalo[Npalo];
		
		for (int i = 0;i<numeroCarta;i++) {
			if(listaCartas[i].getNumero() ==numeroCarta && listaCartas[i].getPalo().equals(palo)) {
				encontrado = true;
			}
		}
		if(encontrado == false) {
			listaCartas[siguente] = new Carta(numeroCarta, palo);	
		}else {
			throw new BarajaException("Baraja igual");
		}
		
		
	}
	
}
