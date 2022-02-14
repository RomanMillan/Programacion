package ejercicios;

/*
 * Calcula y escribe los números múltiplos de 5 (0 a 100) utilizando un bucle for.
 * */
public class Ej13 {

	public static void main(String[] args) {
		System.out.println(mulp0al100());
	}
	//metodo que calcula y escribe los numeros multiplos 5 (0-100)
	public static String mulp0al100() {
		String resultado = "";
		for (int num = 0;num<=100;num++) {
			resultado += Integer.toString(num*=5 ) + "\n"; 
		}
		return resultado;
	}
}
