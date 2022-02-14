package ejercicios;

/*
 * Escribe los números del 320 al 160, contando de 20 en 20 hacia atrás 
 * utilizando un bucle for.
 * */
public class Ej16 {

	public static void main(String[] args) {
		num320Al20();

	}

	public static void num320Al20() {
		for (int i = 320; i >= 160; i -= 20) {
			System.out.println(i);
		}
	}
}
