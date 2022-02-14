package Ej1;

import java.util.Scanner;

public class MainRectangulo {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		Rectangulo r1 = new Rectangulo();

		double largo, ancho;

		largo = leerDouble("Inserte el largo: ");
		ancho = leerDouble("Inserte el ancho: ");
		
		if (r1.setLongitud(largo) == true &&  r1.setAncho(ancho) == true) {
			System.out.println("El area es: "+ r1.area());
			System.out.println("El perimetro es: "+ r1.perimetro());
		}else {
			System.out.println("No se ha podido insertar los datos: ");
		}
		
		
	}

	// metodo que lee un double
	public static double leerDouble(String texto) {
		System.out.print(texto);
		return Double.parseDouble(teclado.nextLine());
	}

}
