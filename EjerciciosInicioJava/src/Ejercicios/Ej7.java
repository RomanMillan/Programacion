package ejercicios;

/*
 * Método que muestre los números del 1 al 100 utilizando la instrucción for  (para)
 * */

public class Ej7 {

	public static void main(String[] args) {

		num1Al100();
	}
	
	//metodo que imprime los numeros del 1 al 100
	public static void num1Al100() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i + 1);
		}
	}
}
