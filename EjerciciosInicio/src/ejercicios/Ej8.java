package ejercicios;

/*
 * Muestra los números del 1 al 100 utilizando la instrucción while (mientras)
 * */
public class Ej8 {

	public static void main(String[] args) {
		System.out.println(num1Al100());
		
	}
	
	//metodo que imprime los num del 1 al 100
	public static String num1Al100() {
		String resultado = "";
		int num = 0;
		while (num<100) {
			++num;
			resultado += Integer.toString(num) + "\n"; 
		}
		return resultado;
	}

}
