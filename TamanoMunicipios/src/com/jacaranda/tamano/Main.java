package com.jacaranda.tamano;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import com.google.gson.Gson;

public class Main {

	public static TamanoMunicipioComunidad p = new TamanoMunicipioComunidad();
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String fichero = leerFichero("fichero/tamanoMunicipioComunidad.json");
		
		p.cargarDatos(fichero);
		System.out.println(p);
		int opc;
		do {
			menu();
			opc = leerInt("Inserta una opcion: ");
			
			switch (opc) {
			//conseguir datos de todas las comunidades, España y anio eleguido
			case 1:
				int anio = leerInt("Inserte un anio: ");
				System.out.println(p.datosAnio(anio));
				break;
			//conseguir datos de solo la comunidad eleguida y anio
			case 2:
				String nombreC = leerString("Inserta el nombre de la comunidad: "); 
				anio = leerInt("Inserte un anio: ");
				System.out.println(p.datosComunAnio(nombreC, anio));
				break;
			//anadir un dato
			case 3:
				String comunidad = leerString("Inserte el nombre de la comunidad: ");
				String descripcion = leerString("Inserte la descripcion: ");
				int anioD = leerInt("Inserte el anio: ");
				int dato = leerInt("Inserte el dato: ");
				System.out.println(p.inertarDatos(comunidad, descripcion, anioD, dato));
				break;
			//Comprobar que el valor de Total es la suma de todos los valores
			case 4:
				nombreC = leerString("Inserta el nombre de la comunidad: "); 
				anio = leerInt("Inserte un anio: ");
				System.out.println(p.comprobarValor(nombreC, anio));
				break;
			//salir
			case 5:
				String r = leerString("¿Quieres guardar los datos en un nuevo fichero(S/N)?");
				if(r.equals("S")) {
					String nombreF = leerString("Inserte el nombre del nuevo fichero: ");
					p.guardarDatosNuevoArchivo(nombreF);
				}else {
					p.guardarDatos();
				}
				System.out.println("Programa finalizado");
				break;
			//mensaje de error
			default:
				System.out.println("Error al insertar una opcion");
			}	
		} while (opc !=5);

	}
	
	
	private static String leerFichero(String nombreFichero) {
		String linea;
		StringBuilder resultado = new StringBuilder();
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while(linea != null) {
				resultado.append(linea);
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (Exception e) {
			System.out.println("No existe el fichero" + nombreFichero);
		}
		return resultado.toString();
	}
	
	
	public static void menu() {
		System.out.println("\n"
				+ "1. Mostrar los datos del aÃ±o elegido \n"
				+ "2. Mostrar los datos de una comunidad y un aÃ±o \n"
				+ "3. AÃ±adir un dato \n"
				+ "4. Comprobar que el valor de Total es la suma de todos los valores \n"
				+ "5. Salir ");
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
