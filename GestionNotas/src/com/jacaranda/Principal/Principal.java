package com.jacaranda.Principal;

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
		do {
			menu();
			opc = Integer.parseInt(teclado.nextLine());
			switch (opc) {
			case 1: {
				
				break;
			}
			case 2: {
				
				break;
			}
			case 3: {
				
				break;
			}
			case 4: {
				for(Nota nota:listaNotas) {
					System.out.println(nota);
				}
				
				break;
			}
			case 5: {
				for(Alumnado alumnado:listaAlumnado) {
					System.out.println(alumnado);
				}
				break;
			}
			case 6: {
				System.out.println("Programa finalizado");
				break;
			}
			default:
				System.out.println("Error al elegir opcion.");
			}
		}while(opc !=6);
	}

	public static void menu() {
		System.out.println("1. Alta alumnado. \n"
				+ "2. Alta modulo. \n"
				+ "3. Registrar nota \n"
				+ "4. Listar notas todos los alumnos \n"
				+ "5. Listar todos los alumnos \n"
				+ "6. Salir");
	}
	
}
