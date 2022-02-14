package ejercicios;

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
		int dia, mes;
		
		dia = leerInt("Inserte el dia: ");
		mes = leerInt("Inserte el mes: ");
		System.out.println(tempEstacion(dia,mes) + "º");
		
	}
	
	//metodo que lee un entero
	public static int leerInt(String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}
	
	//metodo que retorne una temperatura adecuada
	public static int tempEstacion(int dia, int mes) {
		int temp;
		//primavera
		if ((mes >= 3 && mes <6 && dia >= 20) ||(mes >3 && mes <=6 && dia <=21)) {
			temp = 20;
		//verano
		}else if ((mes >= 6 && mes <9) || (mes >6 && mes <=9 && dia <=23)) {
			temp = 24;
		//otoño
		}else if ((mes >= 9 && mes <12)|| (mes >9 && mes <=12 && dia <=21)) {
			temp = 19;
		//invierno
		}else {
			temp = 19;
		}
		return temp;
	}

}





