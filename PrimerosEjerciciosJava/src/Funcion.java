import java.util.Scanner;

public class Funcion {

	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		char elec;
		double nPra;
		double nPro;
		double nExa;
		
		do {
			System.out.println("Inserte la nota de practica: ");
			nPra = Double.parseDouble(teclado.nextLine());
			
			System.out.println("Inserte la nota de probema: ");
			nPro = Double.parseDouble(teclado.nextLine());
			
			System.out.println("Inserte la nota de examen: ");
			nExa = Double.parseDouble(teclado.nextLine());
			
			System.out.println("la nota es: " + media(nPra,nPro,nExa));
			
			System.out.println("¿Desea insertar otra nota? (S/N)");
			elec = teclado.nextLine().charAt(0);
			
			//comprobamos que inserta bien la eleccion
			while (elec != 'N' && elec != 'S') {
				System.out.println("error al insertar eleccion.");
				
				System.out.println("¿Desea insertar otra nota? (S/N)");
				elec = teclado.nextLine().charAt(0);
			}
			
		}while(elec != 'N');
		
		System.out.println("Programa finalizado.");
	}

	// funcion para obtener la media
	public static double media (double notaPractica, double notaProblema, double notaExamen ) {
		double resultado = 0.1 * notaPractica + 0.4 * notaProblema + 0.5 * notaExamen;
		return  resultado;
	}
	
	
}
