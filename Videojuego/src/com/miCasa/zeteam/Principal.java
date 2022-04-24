package com.miCasa.zeteam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;



public class Principal {

	public static Scanner teclado = new Scanner(System.in);
	public static HashSet<Videojuego> listaVideojuegos = new HashSet<>();
	
	public static void main(String[] args) {
		
		int opc; 
		int horas;
		String nombre;
		String manual;
		String extra;
		double precio;

		leerFichero("fichero//videojuegos.txt");
		
		do {
			menu();
			boolean bManual = false;
			boolean bExtra = false;

			opc = leeInt("Eligue una opcion: ");

			switch (opc) {

			// comprar juego
			case 1: {
				// pregunta por los dato del juego
				nombre = leeString("Nombre del juego: ");
				precio = leeInt("Precio del juego: ");
				manual = leeString("Tiene manual [si/no]: ");
				extra = leeString("Tiene extras [si/no]: ");

				// mira si tiene goodies
				if (manual.equals("si"))
					bManual = true;
				if (extra.equals("si"))
					bExtra = true;

				// crea el juego dependiendo si es goody o no.
				if (bManual || bExtra) {
					try {
						Videojuego vGoody = new Goody(nombre, precio, bManual, bExtra);
						listaVideojuegos.add(vGoody);
					} catch (VideojuegoException e) {
						System.out.println(e.getMessage());
					}
				} else {
					try {
						Videojuego v = new Videojuego(nombre, precio);
						listaVideojuegos.add(v);
					} catch (VideojuegoException e) {
						System.out.println(e.getMessage());
					}
				}

				break;
			}

			// Devolver juego
			/*
			 * 1. Pedimos el nombre (hashCode/Equals) 
			 * 2. Hacemos un Iterator para ver si el juego está y no 
			 * se ha superado el numero de horas permitido y se guarda en aux
			 * 3. si el juego cumple los requisitos se borra y da un mensaje de devuleto
			 * 4. si no nos saldrá un mensaje de no se ha podido devolver.
			 * */
			case 2: {

				nombre = leeString("Indique el nombre: ");
				
				Iterator<Videojuego> puntero = listaVideojuegos.iterator();
				Videojuego aux;
				boolean salir= false;
				
				while(puntero.hasNext()&&!salir) {
					aux = puntero.next();
					if(aux.getNombre().equals(nombre) && aux.getHorasJugadas()<=2) {
						listaVideojuegos.remove(aux);
						salir = true;
					}
				}
				
				if(salir) {
					System.out.println("Devolucion realizada con exito.");
				}else {
					System.out.println("No se ha podido devolver.");	
				}
				
				break;
			}

			// Jugar
			
			/*
			 * 1. Pedimos el nombre (hashCode/Equals) y el num de horas
			 * 2. Hacemos un Iterator para ver si el juego está se guarda en aux
			 * 3. si el juego esta (salir == true) sumamos las horas al juego
			 * 4. si no nos saldrá un mensaje de error.
			 * */
			case 3: {
				
				nombre = leeString("Indique el nombre: ");
				horas = leeInt("Indica las horas a jugar: ");
				
				try {	
					Iterator<Videojuego> puntero = listaVideojuegos.iterator();
					Videojuego aux;
					boolean salir= false;
					while(puntero.hasNext()&&!salir) {
						aux = puntero.next();
						if(aux.getNombre().equals(nombre)) {
							aux.setHorasJugadas(horas);
							salir = true;
						}
					}
				} catch (VideojuegoException e) {
					System.out.println(e.getMessage());
				}
					
				
				
				break;
			}

			// ver lista de juegos
			case 4: {
				System.out.println(listaVideojuegos.toString());
				break;
			}

			
			// ver juego
			
			/*
			 * 1. Pedimos el nombre (hashCode/Equals)
			 * 2. Hacemos un Iterator para ver si el juego está y guardar en aux
			 * 3. si el juego esta (salir == true) y nos muestra el toString()
			 * 4. si no nos saldrá un mensaje de no encontrado.
			 * */
			case 5: {
				nombre = leeString("nombre del juego: ");
				
				Iterator<Videojuego> puntero = listaVideojuegos.iterator();
				Videojuego aux=null;
				boolean salir = false;
				
				while(puntero.hasNext() && !salir) {
					aux = puntero.next();
					salir = true;
				}
				
				if(salir) {
					System.out.println(aux.toString());
				}else {
					System.out.println("Juego no encontrado.");
				}
				
				break;
			}

			// salir
			case 6: {
				escribirEnFicheroVideojuego("fichero//videojuegos.txt");
				System.out.println("Programa finalizado.");
				break;
			}
			default:
				System.out.println("Error al elegir una opcion.");
			}
		} while (opc != 6);
	}

	// ______________________________________________________________________________

	// metodo que imprime menu
	public static void menu() {
		System.out.println("\n" + "1. Comprar juego. \n" + "2. Devolver juego. \n" + "3. Jugar. \n"
				+ "4. Ver lista de juegos. \n" + "5. Ver juego. \n" + "6. Salir aplicación. \n");
	}

	// metodo que lee enteros
	public static int leeInt(String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}

	// metodo que lee cadenas
	public static String leeString(String texto) {
		System.out.print(texto);
		return teclado.nextLine();
	}
	
	//lee un fichero y lo carga en un arraylist (VIDEOJUEGO)
	private static void leerFichero(String nombreFichero) {
		String linea;
		try {
		    //insertamos todo el fichero en un buffer.
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			
			//lee linea por linea y lo imprime
			linea = filtroLectura.readLine();	
			
			while (linea != null) {
				String[] campos = linea.split(",");
				double precio = Double.parseDouble(campos[1]);
				double horas = Double.parseDouble(campos[4]);
		
				if(campos.length<8) {
					Videojuego v = new Videojuego(campos[0], precio);
					v.setHorasJugadas(horas);
					listaVideojuegos.add(v);
				}else {
					boolean buleano = Boolean.parseBoolean(campos[6]);
					boolean buleano2 = Boolean.parseBoolean(campos[7]);
					Videojuego g = new Goody(campos[0], precio, buleano, buleano2);
					g.setHorasJugadas(horas);
					listaVideojuegos.add(g);
				}
				
				
				linea = filtroLectura.readLine();
			}

			//cerramos el fichero y buffer
			filtroLectura.close();
			flujoLectura.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		}catch (VideojuegoException e) {
				System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
	}
	
	
	//escribe la informacion en el archivo (VIDEOJUEGO)
	private static void escribirEnFicheroVideojuego(String nombre) {

		try {
			FileWriter flujoEscritura=new FileWriter(nombre);
			PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
		
			//proceso el fichero
			Iterator<Videojuego> puntero = listaVideojuegos.iterator();
			Videojuego aux;
			while(puntero.hasNext()) {
				aux = puntero.next();
				if(aux instanceof Goody) {
					filtroEscritura.println(aux.getNombre() + "," + 
					aux.getPrecio() + ","+ aux.getPegi() + "," + aux.getRequisitos() + ","
					+ aux.getHorasJugadas() + "," + aux.getGenero() + "," 
					+ ((Goody)aux).isManual() + "," + ((Goody)aux).isExtras());
				}else {
					filtroEscritura.println(aux.getNombre() + "," + 
					aux.getPrecio() + ","+ aux.getPegi() + "," + aux.getRequisitos() + ","
					+ aux.getHorasJugadas() + "," + aux.getGenero());
					}
				}
			

			//fin del proceso
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		}
	
	

}
