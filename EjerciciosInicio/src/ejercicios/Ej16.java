package ejercicios;

/*
 * Escribe los números del 320 al 160, contando de 20 en 20 hacia atrás 
 * utilizando un bucle for.
 * */
public class Ej16 {

	public static void main(String[] args) {
		System.out.println(num320Al20());

	}

	public static String num320Al20() {
		String resultado = "";
		for (int i = 320; i >= 160; i -= 20) {
			resultado += Integer.toString(i) + "\n"; 
		}
		return resultado;
	}
}
