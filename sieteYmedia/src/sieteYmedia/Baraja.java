package sieteYmedia;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Baraja {

	private final  int NUM_CARTAS = 40;
	private int siguente;
	private Carta listaCartas[];

	//constructor
	public Baraja() {
		 listaCartas = new Carta [NUM_CARTAS];
		 siguente = 0;
	}

	//get and set
	public int getSiguente() {
		return siguente;
	}

	
	
	public Carta[] getListaCartas() {

		return listaCartas;
	}

	//metodos
	/*
	 * Metodo que genera una carta y la añade a la lista de cartas
	 */
	public void barajar() throws CartaException {
		 boolean encontrado = false;
		for(int e= 0;e<NUM_CARTAS;e++) {
			do {
				encontrado = false;
				//generamos la carta
				int numeroCarta = generaNumero();
				String palo = generaPalo();
				
				//miramos si es una carta mayor
				String cartaMayor = "";
				if(numeroCarta == 8) {
					cartaMayor += "Sota";
				}else if(numeroCarta == 9) {
					cartaMayor += "Caballo";
				}else if(numeroCarta == 10) {
					cartaMayor += "Rey";
				}
				
				//buscar si tenemos repetida la carta
				for (int i = 0;i<siguente && encontrado == false;i++) {
					if(numeroCarta>= 8) {
						if(listaCartas[i].getNumMayor().equals(cartaMayor) && listaCartas[i].getPalo().equals(palo)) {
							encontrado = true;
						}
					}else {
						if(listaCartas[i].getNumero() ==numeroCarta && listaCartas[i].getPalo().equals(palo)) {
							encontrado = true;
						}	
					}
					
				}
				//si no está repetida la insertamos en lista de cartas
				if(encontrado == false) {
					if(numeroCarta >= 8) {
						listaCartas[siguente] = new Carta(cartaMayor, palo);
						siguente++;
					}else {
						listaCartas[siguente] = new Carta(numeroCarta, palo);
						siguente++;	
					}
				}
			}while(encontrado == true);
		}
		siguente = 0;
	}

	
	/*
	 * metodo que genera un palo
	 */
	private String generaPalo() {
		String listaPalo [] = {"Oro","Basto","Copa","Espada"};
		ThreadLocalRandom r1 = ThreadLocalRandom.current();
		int Npalo = r1.nextInt(0,4);
		String palo = listaPalo[Npalo];
		return palo;
	}
	
	/*
	 * Metodo que genera un numero de la carta
	 */
	private int generaNumero() {
		ThreadLocalRandom r1 = ThreadLocalRandom.current();
		int numeroCarta = r1.nextInt(1,11);
		return numeroCarta;
	}

	/*
	 * Devuelve un objeto carta de la lista en orden
	 */
	public Carta getSiguiente() throws BarajaException {
		
		Carta carta;
		try {
			carta = listaCartas[siguente];
			siguente++;
		} catch (Exception e) {
			throw new BarajaException("No quedan mas cartas");
		}
		return carta;
	}
	
	@Override
	public String toString() {
		return "Baraja [listaCartas=" + Arrays.toString(listaCartas) + "]";
	}


	
}
