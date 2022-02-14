import java.util.Scanner;

public class ej3 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Nota de practica: ");
		double practica = Double.parseDouble(teclado.nextLine());
		
		System.out.println("Nota de problemas: ");
		double problema = Double.parseDouble(teclado.nextLine());
		
		System.out.println("Nota de teórica: ");
		double teorica = Double.parseDouble(teclado.nextLine());
		
		practica *= 0.1;
		problema *= 0.5;
		teorica *= 0.4;
		
		int media = (int) (practica + problema + teorica);
		
		System.out.println("la media es: " + media);
		
		if (media < 4) {
			System.out.println();
		}
	}

}
