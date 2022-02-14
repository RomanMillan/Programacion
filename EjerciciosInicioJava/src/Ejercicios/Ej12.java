package ejercicios;


/*
 * Método que muestre los números del 100 al 1 utilizando la instrucción do..while
 * */
public class Ej12 {

	public static void main(String[] args) {
		num100al1();

	}
	
	//metodo que imprime num del 100 al 1
	public static void num100al1() {
		int num = 100;
		do {
			System.out.println(num);
			num--;
		}while(num>=1);
	}
}
