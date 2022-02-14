package ejercicios;

/*
 * Escribe los números del 320 al 160, contando de 20 en 20 utilizando un bucle do-while.
 * */
public class Ej18 {

	public static void main(String[] args) {
		num320Al160();

	}
	
	// metodo que imprime los num del 320 al 160 de cuenta regresiba de 20
	public static void num320Al160() {
		int num = 320;
		do {
			System.out.println(num);
			num -= 20;
		}while(num>=160);
	}

}
