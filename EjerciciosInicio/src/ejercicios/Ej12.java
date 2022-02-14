package ejercicios;


/*
 * Método que muestre los números del 100 al 1 utilizando la instrucción do..while
 * */
public class Ej12 {

	public static void main(String[] args) {
		System.out.println(num100al1());

	}
	
	//metodo que imprime num del 100 al 1
	public static String num100al1() {
		String resultado = "";
		int num = 100;
		do {
			resultado += Integer.toString(num) + "\n";
			num--;
		}while(num>=1);
		return resultado;
	}
}
