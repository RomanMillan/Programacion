package ejercicios;

/*
 * Muestra los números del 1 al 100 utilizando la instrucción while (mientras)
 * */
public class Ej8 {

	public static void main(String[] args) {
		
		num1Al100();
	}
	
	//metodo que imprime los num del 1 al 100
	public static void num1Al100() {
		int num = 0;
		while (num<100) {
			++num;
			System.out.println(num);
		}
	}

}
