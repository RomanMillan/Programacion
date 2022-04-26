package com.jacaranda.Principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import com.jacaranda.gestion.Alumnado;
import com.jacaranda.gestion.Modulo;
import com.jacaranda.gestion.Nota;

public class Principal {

	public static LinkedList<Alumnado> listaAlumnado = new LinkedList<>();
	public static HashSet<Modulo> listaModulos = new HashSet<>();
	public static ArrayList<Nota> listaNotas = new ArrayList<>();

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {

		int opc;
		leerFichero("ficheros//alumnado.txt");
		leerFicheroModulo("ficheros//modulos.txt");
		leerFicheroNota("ficheros//notas.txt");
		do {
			menu();
			opc = leeInt("Inserte una opcion: ");
			switch (opc) {
			// alta alumnado
			case 1: {
				String nombre = leeString("escribir nombre: ");
				String dni = leeString("escribir el dni: ");
				String correoE = leeString("Inserte el correo: ");
				
				listaAlumnado.add(new Alumnado(nombre, dni,correoE));
				break;
			}
			// Registrar modulo
			case 2: {
				String nombre = leeString("escribir nombre: ");
				int horas = leeInt("Inserte horas");
				int creditos = leeInt("Inserte los creditos: ");
				
				listaModulos.add(new Modulo(nombre,horas,creditos));
				break;
			}
			// Registrar nota
			/*
			 * 1. pedimos el dni del alumno, el nombre del modulo y la nota.
			 * 2. buscamos el objeto del alumno (dni) y el objeto modulo (nombre)
			 * 3. Creamos el objeto nota y lo guardamos en la lista de notas 
			 * 4. Si no es posible dará un mensaje de no encontrado.
			 * */
			case 3: {
				Nota nota = null;
				LocalDate fecha=null;
				
				String dni = leeString("DNI alumno: ");
				String nombre = leeString("Nombre del modulo: ");
				double puntos = leeDouble("Insertar la nota: ");
				
				Iterator<Alumnado> puntero = listaAlumnado.iterator();
				Alumnado aux = null;
				boolean salir = false;
				while(puntero.hasNext() && !salir) {
					aux = puntero.next();
					if(aux.getDni().equals(dni)) {
						salir = true;
					}
				}
				
				Iterator<Modulo> puntero2 = listaModulos.iterator();
				Modulo aux2 = null;
				boolean salir2 = false;
				while(puntero2.hasNext()) {
					aux2 = puntero2.next();
					if(aux2.getNombre().equals(nombre)) {
						salir2 = true;
					}
				}
				
				if(salir && salir2) {
					nota = new Nota(puntos,fecha.now(),aux,aux2);
					listaNotas.add(nota);
				}else {
					System.out.println("Datos no encontrados");
				}				
				break;
			}
			// Listar notas todos los alumnos
			case 4: {
				for (Nota nota : listaNotas) {
					System.out.println(nota);
				}

				break;
			}
			// Listar todos los alumnos
			case 5: {
				for (Alumnado alumnado : listaAlumnado) {
					System.out.println(alumnado);
				}
				break;
			}
			case 6: {
				System.out.println("Programa finalizado");
				escribirEnFichero("ficheros//alumnado.txt");
				escribirEnFicheroModulos("ficheros//modulos.txt");
				escribirEnFicheroNota("ficheros//notas.txt");
				break;
			}
			default:
				System.out.println("Error al elegir opcion.");
			}
		} while (opc != 6);
	}
	
	
//______________________________________________________________________________________
	//imprime el menu
	public static void menu() {
		System.out.println("1. Alta alumnado. \n" + "2. Alta modulo. \n" + "3. Registrar nota \n"
				+ "4. Listar notas todos los alumnos \n" + "5. Listar todos los alumnos \n" + "6. Salir");
	}

	public static int leeInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}
	
	public static double leeDouble(String texto) {
		System.out.println(texto);
		return Double.parseDouble(teclado.nextLine());
	}
	
	
	public static String leeString (String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}
	
	//lee un fichero y lo carga en un arraylist (ALUMNO)
	private static void leerFichero(String nombreFichero) {
		String linea;
		try {
			//insertamos todo el fichero en un buffer 
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			
			//lee linea por linea y lo imprime
			linea = filtroLectura.readLine();	
			
			while (linea != null) {
				
				String[] campos = linea.split(",");
					Alumnado alu = new Alumnado(campos[0], campos[1],campos[2]);
					listaAlumnado.add(alu);
				linea = filtroLectura.readLine();
			}

			//cerramos el fichero y buffer
			filtroLectura.close();
			flujoLectura.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//escribe la informacion en el archivo (ALUMNO)
	private static void escribirEnFichero(String nombre) {

		try {
			FileWriter flujoEscritura=new FileWriter(nombre);
			PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
		
			//proceso el fichero
			for(Alumnado alu:listaAlumnado) {
				filtroEscritura.println(alu.getNombre() + "," + alu.getDni() + ","+ alu.getCorreoE());
			}
			//fin del proceso
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		}
	
	//lee un fichero y lo carga en un arraylist (MODULO)
		private static void leerFicheroModulo(String nombreFichero) {
			String linea;
			try {
				//insertamos todo el fichero en un buffer 
				FileReader flujoLectura = new FileReader(nombreFichero);
				BufferedReader filtroLectura = new BufferedReader(flujoLectura);
				
				//lee linea por linea y lo imprime
				linea = filtroLectura.readLine();	
				
				while (linea != null) {
					
					String[] campos = linea.split(",");
					 int horas = Integer.parseInt(campos[1]);
					 int creditos = Integer.parseInt(campos[2]);
						Modulo mod = new Modulo(campos[0], horas,creditos);
						listaModulos.add(mod);
					linea = filtroLectura.readLine();
				}

				//cerramos el fichero y buffer
				filtroLectura.close();
				flujoLectura.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("No existe el fichero " + nombreFichero);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		//escribe la informacion en el archivo (MODULO)
		private static void escribirEnFicheroModulos(String nombre) {

			try {
				FileWriter flujoEscritura=new FileWriter(nombre);
				PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
			
				//proceso el fichero
				for(Modulo mod:listaModulos) {
					filtroEscritura.println(mod.getNombre() + "," + mod.getNumHorasSemanales() + ","+ mod.getCreditos());
				}
				//fin del proceso
				filtroEscritura.close();
				flujoEscritura.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			}
	

		
		//lee un fichero y lo carga en un arraylist (NOTA)
				private static void leerFicheroNota(String nombreFichero) {
					String linea;
					try {
						//insertamos todo el fichero en un buffer 
						FileReader flujoLectura = new FileReader(nombreFichero);
						BufferedReader filtroLectura = new BufferedReader(flujoLectura);
						
						//lee linea por linea y lo imprime
						linea = filtroLectura.readLine();	
						
						while (linea != null) {
							String[] campos = linea.split(",");
							double puntos = Double.parseDouble(campos[0]);
							LocalDate fecha = LocalDate.parse(campos[1]);
							
							Iterator<Alumnado> puntero = listaAlumnado.iterator();
							Alumnado auxAlumno = null;
							boolean salir = false;
							while(puntero.hasNext()&& !salir) {
								auxAlumno = puntero.next();
								if(auxAlumno.getDni().equals(campos[2])) {
									salir= true;
								}
							}
							
							
							Iterator<Modulo> puntero2 = listaModulos.iterator();
							Modulo auxModulo = null;
							boolean salir2 = false;
							while(puntero2.hasNext()&& !salir2) {
								auxModulo = puntero2.next();
								if(auxModulo.getNombre().equals(campos[3])) {
									salir2= true;
								}
							}
							
							
							Nota note = new Nota(puntos,fecha,auxAlumno,auxModulo);
							listaNotas.add(note);
							linea = filtroLectura.readLine();
						}

						//cerramos el fichero y buffer
						filtroLectura.close();
						flujoLectura.close();
						
					} catch (FileNotFoundException e) {
						System.out.println("No existe el fichero " + nombreFichero);
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
				}
		
		//escribe la informacion en el archivo (NOTA)
		private static void escribirEnFicheroNota(String nombre) {

			try {
				FileWriter flujoEscritura=new FileWriter(nombre);
				PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
			
				//proceso el fichero
				for(Nota note:listaNotas) {
					filtroEscritura.println(note.getNota() + "," + note.getFecha() + ","+ note.getAlumno() + "," + note.getModulo());
				}
				//fin del proceso
				filtroEscritura.close();
				flujoEscritura.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			}
	

}
