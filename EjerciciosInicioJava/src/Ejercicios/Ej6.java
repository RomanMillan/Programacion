package Ejercicios;

import java.util.Scanner;

/*
 * Programar un sistema de calefacción-refrigeración que compruebe 
 * - en función del día y el mes la estación en la que estamos 
 * y en función de la estación programe 
 * la temperatura: Invierno->19º, Primavera->20º, Verano->24º, Otoño→19º. 
 *  
 * - El método deberá recibir como parámetro el mes y el día actual, 
 * -  y el método deberá devolver los grados a los que deberemos programar el sistema.
 * */


public class Ej6 {

	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		int dia, estacion;
		
		dia = leerInt("Inserte el dia: ");
		estacion = leerInt("Inserte el mes: ");
		System.out.println(tempEstacion(dia,estacion) + "º");
		
	}
	
	//metodo que lee un entero
	public static int leerInt(String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}
	
	//metodo que retorne una temperatura adecuada
	public static int tempEstacion(int dia, int estacion) {
		int temp;
		//primavera
		if (estacion >= 3 && estacion <6 && dia >= 20) {
			temp = 20;
		}else if(estacion >3 && estacion <=6 && dia <=21) {
			temp = 20;
		//verano
		}else if (estacion >= 6 && estacion <9) {
			temp = 24;
		}else if (estacion >6 && estacion <=9 && dia <=23 ) {
			temp = 24;
		//otoño
		}else if (estacion >= 9 && estacion <12) {
			temp = 19;
		}else if (estacion >9 && estacion <=12 && dia <=21) {
			temp = 19;
		//invierno
		}else {
			temp = 19;
		}
		return temp;
	}
	
	// otro metodo que funciona debido a que otoño y primavera tienen la misma temp
	public static int tempEstacion2(int dia, int estacion) {
		int temp;
		//primavera
		if (estacion >= 3 && estacion <6 && dia >= 20) {
			temp = 20;
		}else if(estacion >3 && estacion <=6 && dia <=21) {
			temp = 20;
		//verano
		}else if (estacion >= 6 && estacion <9) {
			temp = 24;
		}else if (estacion >6 && estacion <=9 && dia <=23 ) {
			temp = 24;
		//otoño e invierno
		}else {
			temp = 19;
		}
		return temp;
	}
}





