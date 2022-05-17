package Ejercicios;

/*
 * Método que muestre los números del 1 al 100 utilizando la instrucción 
 * do.while (repetir .. hasta)
 * */
public class Ej9 {

	public static void main(String[] args) {
		num1Al100();

	}
	
	//metodo que imprime los num del 1 al 100
		public static void num1Al100() {
			int num = 0;
			do {
				++num;
				System.out.println(num);
			}while(num<100);
		}
}