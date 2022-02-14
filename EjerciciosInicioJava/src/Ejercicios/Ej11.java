package ejercicios;


/*
 * Muestra los números del 100 al 1 utilizando la instrucción while
 * */
public class Ej11 {

	public static void main(String[] args) {
		num100Al1();

	}
	
	//metodo que imprime num del 100 al 1
	public static void num100Al1() {
		int num = 100;
		while (num>= 1) {
			System.out.println(num);
			num--;
		}
	}
}
