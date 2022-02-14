package ejercicios;

/*
 * Método que muestre los números del 1 al 100 utilizando la instrucción for  (para)
 * */

public class Ej7 {

	public static void main(String[] args) {

		System.out.println(num1Al100());
	}
	
	//metodo que imprime los numeros del 1 al 100
	public static String num1Al100() {
		String resultado = "";
		for (int i = 1; i < 101; i++) {
			resultado += Integer.toString(i) + "\n";
		}
		return resultado;
	}
}
