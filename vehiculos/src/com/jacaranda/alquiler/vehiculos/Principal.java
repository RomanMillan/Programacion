package com.jacaranda.alquiler.vehiculos;

import java.time.LocalDate;
import java.util.Scanner;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		
		Vehiculo listaVehiculos [] = new Vehiculo[10];
		int numeroVehiculos = 0;
		
		int opc = 0;
		do {
			menu();
			opc = leerInt("Inserta una opcion: ");
			switch (opc) {
			case 1: {
				String tipoVehiculo = leerString("Inserta el tipo de vehiculo: ");
				
				String comparar = tipoVehiculo.toUpperCase();
				
				if(comparar.equals("COCHE")) {
					String matricula = leerString("Inserte la matricula: ");
					String gama = leerString("Inserte la gama: ");
					int fechaDia= leerInt("Inserta el dia: ");
					int fechaMes= leerInt("Inserta el mes: ");
					int fechaAnno= leerInt("Inserta el año: ");
					String carburante = leerString("Inserta el tipo de carburante");
					
					try {
						listaVehiculos[numeroVehiculos] = new Coche(matricula, gama,
								LocalDate.of(fechaAnno, fechaMes, fechaDia), carburante);
						numeroVehiculos++;
					} catch (VehiculoException e) {
						System.out.println(e.getMessage());
					}
				}else if(comparar.equals("MICROBUS")) {
					String matricula = leerString("Inserte la matricula: ");
					String gama = leerString("Inserte la gama: ");
					int fechaDia= leerInt("Inserta el dia: ");
					int fechaMes= leerInt("Inserta el mes: ");
					int fechaAnno= leerInt("Inserta el año: ");
					int numPlazas = leerInt("Inserta el numero de plazas ");
					
					try {
						listaVehiculos[numeroVehiculos] = new Microbus(matricula, gama,
								LocalDate.of(fechaAnno, fechaMes, fechaDia), numPlazas);
						numeroVehiculos++;
					} catch (VehiculoException e) {
						System.out.println(e.getMessage());
					}
					
				}else if (comparar.equals("FURGONETA")) {
					String matricula = leerString("Inserte la matricula: ");
					String gama = leerString("Inserte la gama: ");
					int fechaDia= leerInt("Inserta el dia: ");
					int fechaMes= leerInt("Inserta el mes: ");
					int fechaAnno= leerInt("Inserta el año: ");
					double pMA = leerDouble("Inserta el peso maximo autorizado: ");
					
					try {
						listaVehiculos[numeroVehiculos] = new Furgoneta(matricula, gama,
								LocalDate.of(fechaAnno, fechaMes, fechaDia), pMA);
						numeroVehiculos++;
					} catch (VehiculoException e) {
						System.out.println(e.getMessage());
					}
				}else {
					System.out.println("No tenemos ese tipo de vehiculos.");
				}
				
				break;
			}
			case 2: {
					String matricula = leerString("Inserta el numero de matricula: ");
					boolean encontrado= false;
					int posicion = 0;
					for(int i = 0;i<numeroVehiculos;i++) {
						if(listaVehiculos[i].getMatricula().equals(matricula) && encontrado == false) {
							encontrado = true;
							 posicion = i;
						}
					}
					if (encontrado == true) {
						System.out.println(listaVehiculos[posicion].getPrecio() + "€");
					}else {
						System.out.println("La matricula no ha sido encontrada.");
					}
					
				break;
						}
			case 3: {
				System.out.println("Programa finalizado");
				break;
			}
			default:
				System.out.println("Error al insertar una opcion.");
			}
			
		}while(opc !=3);
		
		
//		Vehiculo v = null;
//		Vehiculo coche = null;
//		try {
//			v = new Vehiculo("4567gpz", "Baja",LocalDate.of(2022, 5,20) );	
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		System.out.println(v);
//		
//		try {
//			coche = new Coche("44778DM", "Media", LocalDate.of(2022, 4, 4),"Gasolina");
//		} catch (VehiculoException e) {
//			System.out.println(e.getMessage());
//		}
//
//		System.out.println(coche.toString());
//		System.out.println(((Coche) coche).getPrecio());
	}

	
	public static void menu() {
		System.out.println("\n"
				+ "1. Alta de vehículo: \n"
				+ "2. Cálculo de precio de alquiler \n"
				+ "3. Salir"
				+ "\n");
	}
	
	public static double leerDouble(String texto) {
		System.out.println(texto);
		return Double.parseDouble(teclado.nextLine());
	}
	
	public static String leerString (String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}
	
	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}
}
