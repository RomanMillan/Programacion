package ejercicios;

/*
 * Muestra los números múltiplos de 5 de 0 a 100 utilizando un bucle while.
 * */

public class Ej14 {

	public static void main(String[] args) {
		System.out.println(mult1al100());

	}
	//metodo que calcula y escribe los numeros multiplos 5 (0-100)
	public static String mult1al100() {
		String resultado= "";
		int num = 0;
		while (num <=100) {
			resultado += Integer.toString(num*5) + "\n";
			num++;
		}
		return resultado;
	}
}
