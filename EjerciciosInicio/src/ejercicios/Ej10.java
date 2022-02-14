package ejercicios;

/*
 * Escribe los números del 100 al 1 utilizando la instrucción for
 * */
public class Ej10 {

	public static void main(String[] args) {
		System.out.println(num100Al1());
		
	}
	//metodo que imprime los num del 100 al 1
	public static String num100Al1() {
		String resultado = "";
		for (int i = 100;i>=1;i--) {
			resultado += Integer.toString(i) + "\n";
		}
		return resultado;
	}
}
