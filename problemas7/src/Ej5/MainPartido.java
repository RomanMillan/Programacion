package Ej5;

import java.util.Scanner;

public class MainPartido {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) throws PartidoException {
		
		final int EQUIPOS = 20;
		final int PARTIDIOS = 100;
		int equipos = 0, partidos = 0;
		Equipo equiposLista [] = new Equipo [EQUIPOS];
		Partido partidosLista [] = new Partido [PARTIDIOS];
		
		int eleccion;
		menu();
		
		
		do {
			eleccion = leerInt("Eligue una opción: ");
			switch (eleccion) {
			//dar de alta un equipo
			case 1: {
				String nombre, campo, ciudad;
				nombre = leerString("Nombre del equipo: ");
				campo = leerString("Nombre del campo: ");
				ciudad = leerString("Nombre de la ciudad: ");
				
				if (equipos <= EQUIPOS) {
					equiposLista[equipos++] = new Equipo(nombre, campo, ciudad);
				}else {
					System.out.println("Cupo lleno");
				}
				
				
				
				break;
			}
			
			//Modificar la ciudad del equipo
			case 2: {
							
			break;
			}
			
			//Modificar el estado de un equipo
			case 3: {
				
				break;
			}
			
			//Imprimir el equipo
			case 4: {
				boolean encontrado = false;
				int posicion = 0;
				
				String equipoAbuscar = leerString("Inserte el nombre del equipo: ");
				for (int i = 0;i<equipos && encontrado == false; i++) {
					if (equiposLista[i].getNombre().equals(equipoAbuscar)) {
						posicion = i;
						encontrado = true;	
					}
				}
				
				if (encontrado == true) {
					System.out.print(equiposLista[posicion].toString());
				}else {
					System.out.println("El nombre insertado no está registrado.");
				}
				
				System.out.println();
				break;
			}
			
			//Dar de alta un partido
			case 5: {
				
				break;
			}
			
			//Poner el resultado de un partido.
			case 6: {
				
				break;
			}
			
			//Mostrar un partido
			case 7: {
				
				break;
			}
			
			//Mostrar todos los partidos
			case 8: {
				
				break;
			}
			
			//Salir
			case 9: {
				System.out.println("Programa finalizado");			
			break;
			}

			default:
				System.out.println("Error al insertar una opción.");
			}
			
		}while(eleccion !=9);
		
	
	}
	
	public static void menu() {
		System.out.println("1.- Dar de alta un equipo. "
				+ "\r\n"
				+ "2.- Modificar la ciudad del equipo "
				+ "\r\n"
				+ "3.- Modificar el estado de un equipo "
				+ "\r\n"
				+ "4.- Imprimir el equipo "
				+ "\r\n"
				+ "5.- Dar de alta un partido "
				+ "\r\n"
				+ "6.- Poner el resultado de un partido. "
				+ "\r\n"
				+ "7.- Mostrar un partido"
				+ "\r\n"
				+ "8.- Mostrar todos los partidos."
				+ "\r\n"
				+ "9.- Salir \r\n");
	}
	
	public static int leerInt(String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}
	
	public static String leerString(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}
}

