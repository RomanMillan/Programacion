import java.util.Scanner;

public class CalcularLaMedia {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		double total = 0;
		int cont = 0;

		for (int i = 1; i <= 10; i++) {
			System.out.println("Inserte un numero: ");
			double num = Double.parseDouble(teclado.nextLine());
			total += num;
			cont++;
		}
		double result = total / cont;
		System.out.println("La media es: " + result);
		teclado.close();
	}
}
