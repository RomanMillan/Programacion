package sieteYmedia;

import java.util.Scanner;

public class MainJuego {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		Carta cartaRespaldo;
		double sumaJugador = 0, sumaBanca = 0;
		boolean respuesta = false;
		
		do {
			sumaBanca = 0;
			sumaJugador = 0;
			respuesta = false;
			//se crea el objeto carta
			Baraja b1 = new Baraja();
			
			// se crea la baraja de cartas
			try {
				b1.barajar();	
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			//imprimo la baraja para ver el funcionamineto
			System.out.println(b1.toString());
			
			//Primera mano del jugador
			System.out.println("Cartas del jugador:");
			try {
				cartaRespaldo = b1.getSiguiente();
				System.out.println("Carta Oculta: " + cartaRespaldo);
				sumaJugador = cartaRespaldo.getValor();
				
				cartaRespaldo = b1.getSiguiente();
				System.out.println("Carta visible: " + cartaRespaldo);
				sumaJugador += cartaRespaldo.getValor();
				
				System.out.println("Puntos Jugador: " + sumaJugador);
				
				System.out.println("---------------------------------");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			if(sumaJugador> 7.5) {
				System.out.println("Has perdido. La banca gana :(");
			}else{
				//preguntamos si quiere seguir obteniendo cartas
				boolean respuestaSeguir = false;
				do {
					respuestaSeguir = false;
					String ObtenerCarta = leerString("S para obtener otra carta / N plantarse: ");
					if(ObtenerCarta.equals("S")) {
						try {
							cartaRespaldo = b1.getSiguiente();
							System.out.println("Carta visible: " + cartaRespaldo);
							sumaJugador += cartaRespaldo.getValor();
							System.out.println("Puntos Jugador: " + sumaJugador);
							System.out.println("_______________________________");
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						respuestaSeguir = true;
					}
					//vemos si el jugador se ha pasado de puntos
					if(sumaJugador>7.5) {
						System.out.println("Has perdido. La banca gana.");
						respuestaSeguir =false;
					}		
				}while(respuestaSeguir == true);
				
				//si el jugador no ha perdido 
				if(sumaJugador<=7.5) {
					//mientras que la banca tenta 6 o menos puntos pedirá carta
					while(sumaBanca<=6) {
						try {
							cartaRespaldo = b1.getSiguiente();
							System.out.println("Carta visible: " + cartaRespaldo);
							sumaBanca += cartaRespaldo.getValor();
							System.out.println("Puntos Banca " + sumaBanca);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
					//una vez que se plante la banca
					if(sumaBanca== sumaJugador) {
						System.out.println("Empate y has perdido");
					}else if((sumaBanca > sumaJugador) && sumaBanca <= 7.5) {
						System.out.println("Los siento has perdido");
					}else {
						System.out.println("Enhorabuena has ganado :) confetti confetti");
					}	
				}
			}
			
			//preguntamos si quiere jugar otra partida
			String seguirJugando = leerString("S para seguir juando / N dejar de jugar: ");
			if(!seguirJugando.equals("S")) {
				respuesta = true;
			}
		}while(respuesta == false);
		
		System.out.println("Juego Finalizado");
	}

	//metodo que lee un string
	public static String leerString(String texto) {
		System.out.print(texto);
		return teclado.nextLine();
	}
	
}
