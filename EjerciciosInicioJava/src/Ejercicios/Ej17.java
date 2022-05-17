package Ejercicios;

/*
 * Muestra los números del 320 al 160, contando de 20 en 20 hacia atrás 
 * utilizando un bucle while
 * */
public class Ej17 {

	public static void main(String[] args) {
		num320Al160();

	}

	// metodo que imprime los num del 320 al 160 de cuenta regresiba de 20
	public static void num320Al160() {
		int num = 320;
		while (num >= 160) {
			System.out.println(num);
			num -= 20;
		}
	}
}
