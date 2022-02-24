package parking;

import java.util.Scanner;

public class MainParking {

	
	public static Scanner teclado = new Scanner(System.in);
	//menuPrincipal
	public static void main(String[] args) {
		
		/*
		 * Lista de categorias y parkings 
		 * 
			final int MAXIMOCATEGORIAS = 100;
			Categoria listaCategoria [] = new Categoria [MAXIMOCATEGORIAS];
			int cantCategorias = 0;
			
			final int MAXIMOPARKINGS = 100;
			Parking listaParking [] = new Parking [MAXIMOPARKINGS];
			int cantParkings = 0;
		
		*/
		
		Categoria c1 = new Categoria("coches", 1);
		Parking p1 = new Parking("parking1", c1, 2);
		
		int eleccion = 0;
		do {
			boolean correcto = false;
			do {
				try {
					eleccion = leerInt("Inserta una opción: ");	
					correcto = true;
				} catch (Exception e) {
					System.out.println("La elección debe ser un numero");
				}
			}while (correcto != true);
			
			
			switch (eleccion) {
			//entrar al parking
			case 1: {
				try {
					p1.entrarParking();	
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			}
			//salir del parking
			case 2: {
				boolean tiempoCorrecto = false;
				do {
					int tiempoParking = leerInt("Inserte el tiempo en el parking: ");
					try {
						System.out.println(p1.cobrarYsalirDelParking(tiempoParking) + "€");
						tiempoCorrecto = true;
					} catch (Exception e) {
						System.out.println(e.getMessage());
						
					}
				}while(tiempoCorrecto != true);	
			break;
			}
			//mostrar información del parking
			case 3: {
				System.out.println(p1.toString());
			break;
			}
			//salir
			case 4: {
				System.out.println("Programa finalizado");
				break;
			}
			default:
				System.out.println("Error al elegir una opción");
			}
			
		}while(eleccion !=4);
	}

	///////////////////////////////////////////////////
	//menú principal
	public static void menu() {
		System.out.println("\n"
				+ "1.- Entrar al parking.\r\n"
				+ "2.- Salir de parking.\r\n"
				+ "3.- Mostrar información del parking.\r\n"
				+ "4.- Salir del programa.\n");
	}
	
	//metodo lee String
	public static String leerString(String texto) {
		System.out.print(texto);
		return teclado.nextLine();
	}
	
	//metodo que lee Int
	public static int leerInt(String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}
}
