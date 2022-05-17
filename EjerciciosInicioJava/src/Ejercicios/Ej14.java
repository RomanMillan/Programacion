package Ejercicios;

/*
 * Muestra los números múltiplos de 5 de 0 a 100 utilizando un bucle while.
 * */

public class Ej14 {

	public static void main(String[] args) {
		mult1al100();

	}
	//metodo que calcula y escribe los numeros multiplos 5 (0-100)
	public static void mult1al100() {
		int num = 0;
		while (num <=100) {
			System.out.println(num*5);
			num++;
		}
	}
}
