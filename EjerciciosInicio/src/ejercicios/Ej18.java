package ejercicios;

/*
 * Escribe los números del 320 al 160, contando de 20 en 20 utilizando un bucle do-while.
 * */
public class Ej18 {

	public static void main(String[] args) {
		System.out.println(num320Al160());

	}
	
	// metodo que imprime los num del 320 al 160 de cuenta regresiba de 20
	public static String num320Al160() {
		String resultado = "";
		int num = 320;
		do {
			resultado = Integer.toString(num) + "\n";
			num -= 20;
		}while(num>=160);
		return resultado;
	}

}
