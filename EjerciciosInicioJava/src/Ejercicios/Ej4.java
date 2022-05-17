package Ejercicios;

import java.util.Scanner;

/*
 * Calcular las calificaciones de un alumno con un método que reciba la 
 * nota de la parte práctica, la nota de los problemas y la parte teórica. 
 * 
 * La nota final se calcula según el siguiente criterio: 
 * - la parte práctica vale el 10%; 
 * - la parte de problemas vale el 50% 
 * - la parte teórica el 40%. 
 * 
 * Las notas deben estar entre 0 y 10, si no lo están, deberá devolver un mensaje
 * de error. 
 * 
 * Realiza el método que calcule la media de tres notas y te devuelva 
 * la nota del boletín (insuficiente, suficiente, bien, notable o sobresaliente).
 * */

public class Ej4 {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		// pedimos las notas (practica, problemas y teórica)
		System.out.print("Inserte la nota de la parte práctica: ");
		double notaPractica = Double.parseDouble(teclado.nextLine());
		
		System.out.print("Inserte la nota de la parte de los problemas: ");
		double notaProblema = Double.parseDouble(teclado.nextLine());
		
		System.out.print("Inserte la nota de la parte teórica: ");
		double notaTeorica = Double.parseDouble(teclado.nextLine());
		
		// Calculamos el porcentaje de puntacion obtenido.
		notaPractica *= 0.1;
		notaProblema *= 0.5;
		notaTeorica *= 0.4;
		
		//sumamos la notas para obtner la media
		int notaMedia = (int) (notaPractica + notaProblema + notaTeorica);
		
		// mostramos que clasificacion ha sacado el alumno.
		if (notaMedia <5) {
			System.out.println("nota: " + notaMedia + " Insuficiente");
		}else if (notaMedia == 5) {
			System.out.println("nota: " + notaMedia + " Suficiente");
		}else if (notaMedia ==6) {
			System.out.println("nota: " + notaMedia + " Bien");
		}else if (notaMedia ==7 || notaMedia == 8) {
			System.out.println("nota: " + notaMedia + " Notable");
		}else {
			System.out.println("nota: " + notaMedia + " Sobresaliente");
		}
		teclado.close();
	}

}
