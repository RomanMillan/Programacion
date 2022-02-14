import java.util.Scanner;

public class ej2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("inserte un caracter: ");
		char caracter = teclado.nextLine().charAt(0);
		
		int num = (int) caracter;
		
		if (num>= 65 && num<= 90) {
			System.out.println("Es mayuscula");
		}else if (num>= 97 && num<= 122) {
			System.out.println("Es minuscula");
		}else if (num>= 48 && num<= 57) {
			System.out.println("Es numerico");
		}else if (num==46) {
			System.out.println("Es signo de puntación");
		}else if (num==32) {
			System.out.println("Es espacio");
		}else if (num== 40 ||num== 41||num== 123||num== 125) {
			System.out.println("Paréntesis () o llaves {}");
		}else {
			System.out.println("Otro carácter");
		}
		teclado.close();
	}

}
