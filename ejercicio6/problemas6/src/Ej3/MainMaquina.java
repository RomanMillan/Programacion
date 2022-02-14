package Ej3;

import java.util.Scanner;

public class MainMaquina {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		Maquina m1;
		
		double saldoInicial,cantidad;
		int opc;
		String resp;
		
		saldoInicial = leerDouble("Ingrese el saldo inicial: ");
		m1 = new Maquina(saldoInicial);
		
		do {
			System.out.println(menu());
			opc = leerInt("Elige una operacion: ");
			
			switch (opc) {
			//cafe
			case 1: {
				cantidad = leerDouble("Inserte la cantidad: ");
				resp = m1.controlDinero(cantidad, opc);
				if (resp.equals("correcto") !=true) {
					System.out.println(resp);
				}else {
					System.out.println(m1.cafe(cantidad));
				}
				break;
			}
			//leche
			case 2:{
				cantidad = leerDouble("Inserte la cantidad: ");
				resp = m1.controlDinero(cantidad, opc);
				if (resp.equals("correcto") !=true) {
					System.out.println(resp);
				}else {
					System.out.println(m1.leche(cantidad));
				}
				break;
			}
			//cafe con leche
			case 3:{
				cantidad = leerDouble("Inserte la cantidad: ");
				resp = m1.controlDinero(cantidad, opc);
				if (resp.equals("correcto") !=true) {
					System.out.println(resp);
				}else {
					System.out.println(m1.cafeConLeche(cantidad));
				}
				break;
			}
			//consultar estado
			case 4:{
				System.out.println(m1.toString());
				break;
			}
			//apagar
			case 5:{
				System.out.println("Programa finalizado");
				break;
			}
			//error
			default:
				System.out.println("Eleccion Incorrecta");
			}
			
		}while(opc != 5);
	}

	//metodo que lee Int
	public static int leerInt(String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}
	
	//metodo que lee Double
	public static double leerDouble(String texto) {
		System.out.print(texto);
		return Double.parseDouble(teclado.nextLine());
	}
	
	//metodo que muestra menu
	public static String menu() {
		String menu;
		menu = "\n"
				+ "1. Servir café solo (1€) \n"
				+ "2. Servir leche (0.8€) \n"
				+ "3. Servir café con leche (1.5€) \n"
				+ "4. Consultar estado máquina. \n"
				+ "5. Apagar máquina y salir. \n";
		return menu;
	}
}
