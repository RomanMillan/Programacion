package com.jacaranda.Principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
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
		leerFichero("ficheros//modulos.txt");
		do {
			menu();
			System.out.println("Insertar una opcion: ");
			opc = Integer.parseInt(teclado.nextLine());
			switch (opc) {
			// alta alumnado
			case 1: {
				System.out.println("escribir nombre: ");
				String nombre = teclado.nextLine();
				System.out.println("Introduce el dni: ");
				String dni = teclado.nextLine();
				System.out.println("Inserte el correo: ");
				String correoE = teclado.nextLine();
				listaAlumnado.add(new Alumnado(nombre, dni,correoE));
				break;
			}
			// Registrar modulo
			case 2: {
				System.out.println("escribir nombre: ");
				String nombre = teclado.nextLine();
				System.out.println("Introduce numero de horas: ");
				int horas = teclado.nextInt();
				System.out.println("Inserte los creditos: ");
				int creditos = teclado.nextInt();
				listaModulos.add(new Modulo(nombre,horas,creditos));
				break;
			}
			// Registrar nota
			case 3: {

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
					 int entero = Integer.parseInt(campos[1]);
					 int entero2 = Integer.parseInt(campos[2]);
						Modulo mod = new Modulo(campos[0], entero,entero2);
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
	

}
