package ejercicios;


/*
 * Muestra los números del 100 al 1 utilizando la instrucción while
 * */
public class Ej11 {

	public static void main(String[] args) {
		System.out.println(num100Al1());

	}
	
	//metodo que imprime num del 100 al 1
	public static String num100Al1() {
		String resultado = "";
		int num = 100;
		while (num>= 1) {
			resultado += Integer.toString(num) + "\n";
			num--;
		}
		return resultado;
	}
}
