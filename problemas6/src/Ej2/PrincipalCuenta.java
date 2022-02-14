package Ej2;

import java.util.Scanner;

public class PrincipalCuenta {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		
		Cuenta c1;
		
		String nombreCuenta;
		double cantidadInicial,cant;
		int elec;
		boolean finalizar = false,operacion;
		
		//pedimos los datos para crear la cuenta
		nombreCuenta = leerString("Inserte su nombre: ");
		cantidadInicial = leerDouble("Inserte el saldo inicial: ");
		
		c1 = new Cuenta(nombreCuenta,cantidadInicial);
		
		//bucle para realizar las operaciones
		do {
			System.out.println(menu());
			elec = leerInt("Elige una opcion: ");
			
			switch (elec) {
			//reintegro
			case 1: {
				cant = leerDouble("¿Cuanta cantidad desea retirar?: ");
				operacion = c1.reintegro(cant);
				if (operacion == true) {
					System.out.println("Operacion realizada.");
				}else {
					System.out.println("No se pudo realizar la operacion.");
				}
				break;
			}
			//ingreso
			case 2:{
				cant = leerDouble("Inserte la cantidad a ingresar: ");
					operacion = c1.ingreso(cant);
					if (operacion == true) {
						System.out.println("Operacion realizada.");
					}else {
						System.out.println("No se pudo realizar la operacion.");
					}
				break;
			}
			//consultar saldo y num rein e ingr
			case 3:{
				System.out.println(c1.toString());
				break;
				
			}
			//finalizar
			case 4:{
				elec = leerInt("Inserte un 4 si realmente desea finalizar: ");
				if (elec ==4) {
					finalizar = true;
					System.out.println("Saldo actual: " + c1.getSaldo() + "€");
					System.out.println("Programa finalizado.");
				}
				break;
			}
			default:
				System.out.println("Error al insertar una opcion");
			}
		}while(finalizar !=true);

	}

	//metodo que lee String
	public static String leerString(String texto) {
		System.out.print(texto);
		return teclado.nextLine();
	}
	
	//metodo que lee Double
	public static double leerDouble(String texto) {
		System.out.print(texto);
		return Double.parseDouble(teclado.nextLine());
	}
	
	//metodo que lee integer
	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}
	
	//metodo que muestra el menu del programa
	public static String menu() {
		String menu;
		menu = "1. Hacer un reintegro. \n"
				+ "2. Hacer un ingreso. \n"
				+ "3. Consultar el saldo y el número de reintegros e ingresos realizados \n"
				+ "4. Finalizar operaciones. E informar del saldo final de todas las operaciones";
		return menu;
	}
}



