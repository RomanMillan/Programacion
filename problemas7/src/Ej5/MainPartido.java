package Ej5;

import java.util.Scanner;
/**
 * La clase es el menú principal sobre partidos
 * @author Román Millán Díaz 
 * @version 1.0
 *
 */
public class MainPartido {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) throws PartidoException {
		
		final int EQUIPOS = 20;
		final int PARTIDIOS = 100;
		int equipos = 0, partidos = 0;
		Equipo equiposLista [] = new Equipo [EQUIPOS];
		Partido partidosLista [] = new Partido [PARTIDIOS];
		
		int eleccion = 0;
		
		
		do {
			menu();
			//obligamos a que se inserte un numero
			boolean elecCorrecta = false;
			do {
				try {
					eleccion = leerInt("Eligue una opción: ");
					elecCorrecta = true;
				} catch (Exception e) {
					System.out.println("La elección tiene que ser un numero.");
				}	
			}while(elecCorrecta !=true);
			
			switch (eleccion) {	
			//dar de alta un equipo
			case 1: {
				boolean encontrado = false;
				String nombre, campo, ciudad;
				nombre = leerString("Nombre del equipo: ");
				campo = leerString("Nombre del campo: ");
				ciudad = leerString("Nombre de la ciudad: ");
								
				for (int i = 0;i<equipos && encontrado == false; i++) {
						if (equiposLista[i].getNombre().equals(nombre)) {
							encontrado =true;
						}
					}
				
				if (encontrado == true) {
					System.out.println("Equipo encontrado.");
				}else if(equipos == EQUIPOS) {
					System.out.println("No se puede insertar mas equipos");
				}else {
					equiposLista[equipos] = new Equipo(nombre, campo, ciudad);
					equipos++;
				}
				break;	
			}
				
			//Modificar la ciudad del equipo
			case 2: {
				boolean encontrado = false;
				int posicion = 0;
				String equipoAbuscar = leerString("Inserte el nombre del equipo: ");
				
				for (int i = 0;i<equipos && encontrado == false; i++) {
					if (equiposLista[i].getNombre().equals(equipoAbuscar)) {
						posicion = i;
						encontrado =true;
					}
					
				}
				if (encontrado == true) {
					String nombreCiudad = leerString("Inserte el nombre de la ciudad: ");
					equiposLista[posicion].setCiudad(nombreCiudad);
				}else {
					System.out.println("Equipo no encontrado.");
				}
				
			break;
			}
			
			//Modificar el estadio de un equipo
			case 3: {
				boolean encontrado = false;
				int posicion = 0;
				String equipoAbuscar = leerString("Inserte el nombre del equipo: ");
				
				for (int i = 0;i<equipos && encontrado == false; i++) {
					if (equiposLista[i].getNombre().equals(equipoAbuscar)) {
						posicion = i;
						encontrado =true;
					}
				}
				if (encontrado == true) {
					String nombreCampo = leerString("Inserte el nombre del estadio: ");
					equiposLista[posicion].setCampo(nombreCampo);
				}else {
					System.out.println("Equipo no encontrado.");
				}
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
				boolean correcto = false, encontrado1 = false,encontrado2 = false;
				String equipoLocal, equipoVisitante="";
				Equipo obEquipoLocal = null,obEquipoVisitante = null;
				int jornada = 0;
				
				//pedimos la jornada
				do {
					try {
						jornada = leerInt("Inserte la jornada: ");
						correcto = true;
					} catch (NumberFormatException i) {
						System.out.println("La jornada debe ser un numero.");
					}	
				}while(correcto != true);
				
				
				
				//pedimos el nombre del equipo local
				equipoLocal = leerString("Inserte el nombre del equipo local: ");
				for (int i = 0;i<equipos && encontrado1 == false;i++){
					if(equiposLista[i].getNombre().equals(equipoLocal)) {
						encontrado1 = true;
						obEquipoLocal = equiposLista[i];
					}
				}
				if(encontrado1 == false) System.out.println("Equipo no encontrado");
				
				//pedimos el nombre del equipo visitante
				if(encontrado1 == true) {
					equipoVisitante = leerString("Inserte el nombre del equipo visitante: ");
					for (int i = 0;i<equipos && encontrado2 == false;i++){
						if(equiposLista[i].getNombre().equals(equipoVisitante)) {
							encontrado2 = true;
							obEquipoVisitante = equiposLista[i];
						}
					}
					if(encontrado2 == false) System.out.println("Equipo no encontrado.");
				}
				
				//si no están repetido los equipos y lleno los partidos creamos el partido
				if(encontrado1 == true && encontrado2 == true) {
					if(partidos < PARTIDIOS) {
						if (equipoLocal.equals(equipoVisitante)== false) {
							partidosLista[partidos] = new Partido(jornada, obEquipoLocal, obEquipoVisitante);
							partidos++;
						}else {
							System.out.println("Error, los dos equipos son iguales");
						}
					}else {
						System.out.println("No se puede crear mas partidos");
					}
				}
				
				break;
			}
			
			//Poner el resultado de un partido.
			case 6: {
				String BusEquipoLocal,BusEquipoVisitante,resultado;
				int jornada = 0;
				boolean encontrado = false,jornadaCorrecto = false;
				int posicion = 0;
				
				do {
					try {
						jornada = leerInt("Inserte la jornada: ");
						jornadaCorrecto = true;
					} catch (Exception e) {
						System.out.println("La jornada tiene que ser un numero.");
					}	
				}while(jornadaCorrecto !=true);
				
				
				
				BusEquipoLocal = leerString("Inserte el nombre del equipo local: ");
				BusEquipoVisitante= leerString("Inserte el nombre del equipo visitante: ");
				resultado = leerString("Inserta el resultado: ");
				
				//miramos si el partido existe
				for (int i = 0;i<partidos && encontrado==false;i++) {
					if((partidosLista[i].getJornada() == jornada) 
							&& (partidosLista[i].getEquipoLocal().getNombre().equals(BusEquipoLocal))
							&& (partidosLista[i].getEquipoVisitante().getNombre().equals(BusEquipoVisitante))){
						
						encontrado = true;
						posicion = i;
					}
				}
				
				// si el partido existe intentamos porner el resultado
				if(encontrado == true) {
					try {
						partidosLista[posicion].ponerResultado(resultado);	
					}catch (Exception e){
						e.getMessage();
					}	
				}else {
					System.out.println("Partido no encontrado");
				}
				

				break;
			}
			
			//Mostrar un partido
			case 7: {
				String BusEquipoLocal,BusEquipoVisitante;
				int jornada = 0, posicion = 0;
				boolean encontrado = false, jornadaCorrecto = false;
				
				do {
					try {
						jornada = leerInt("Inserte la jornada: ");
						jornadaCorrecto = true;
					} catch (Exception e) {
						System.out.println("La jornada tiene que ser un numero.");
					}	
				}while(jornadaCorrecto !=true);
				
				BusEquipoLocal = leerString("Inserte el nombre del equipo local: ");
				BusEquipoVisitante= leerString("Inserte el nombre del equipo visitante: ");
				
				//miramos si el partido existe y lo mostramos
				for(int i = 0;i<partidos && encontrado == false;i++) {
					if((partidosLista[i].getJornada() == jornada) 
							&& (partidosLista[i].getEquipoLocal().getNombre().equals(BusEquipoLocal))
							&& (partidosLista[i].getEquipoVisitante().getNombre().equals(BusEquipoVisitante))){
						encontrado = true;
						posicion = i;
						
					}
				}
				
				if(encontrado == true) {
					System.out.println(partidosLista[posicion].toString());
					
				}else {
					System.out.println("Partido no encontrado.");
				}
				
				break;
			}
			
			//Mostrar todos los partidos
			case 8: {
				for(int i = 0;i<partidos;i++) {
					System.out.println(partidosLista[i].toString());
				}
				break;
			}
			
			//Mostrar todos los equipos
			case 9: {
				for(int i = 0;i<equipos;i++) {
					System.out.println(equiposLista[i].toString());
				}
			break;
			}
			//salir
			case 10:{
				System.out.println("Programa finalizado");			
				break;
			}
				
			default:
				System.out.println("Error al insertar una opción.");
			}
			
		}while(eleccion !=10);
		
	
	}
	/**
	 *Imprime el menu principal
	 */
	public static void menu() {
		System.out.println("\r\n"
				+ "1.- Dar de alta un equipo. "
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
				+ "9.- Mostrar todos los equipos."
				+ "\r\n"
				+ "10.- Salir \r\n");
	}
	/**
	 *  Lee un numero entero 
	 * @param texto Descripción del dato que el usuario tiene que insertar
	 * @return Retorna el numero insertado por el usuario
	 */
	public static int leerInt(String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}
	/**
	 * Lee una cadena insertada por el usuario
	 * @param texto Cadena guia para que el usuario inserte lo requerido
	 * @return Retorna el dato insertado por el usuario
	 */
	public static String leerString(String texto) {
		System.out.print(texto);
		return teclado.nextLine();
	}
}

