package ejercicios;


/*
 * Realiza un programa que muestre los números múltiplos de 5 de 0 a 100 
 * utilizando un bucle do-while.
 * */
public class Ej15 {

	public static void main(String[] args) {
		mult1al100();

	}
	//metodo que calcula y escribe los numeros multiplos 5 (0-100)
	public static void mult1al100() {
		int num = 0;
		do {
			System.out.println(num*5);
			num++;
		}while(num<=100);
	}
}
