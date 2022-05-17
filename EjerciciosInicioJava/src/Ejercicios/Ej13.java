package Ejercicios;

/*
 * Calcula y escribe los números múltiplos de 5 (0 a 100) utilizando un bucle for.
 * */
public class Ej13 {

	public static void main(String[] args) {
		
		mulp0al100();
	}
	//metodo que calcula y escribe los numeros multiplos 5 (0-100)
	public static void mulp0al100() {
		for (int i= 0;i<=100;i++) {
			System.out.println(i*5);
		}
	}
}
