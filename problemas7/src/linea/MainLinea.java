package linea;

import java.util.Scanner;

public class MainLinea {
	public static Scanner teclado = new Scanner(System.in);
	
	//metodo Main
	public static void main(String[] args) {
		Punto p1;
		Punto p2;
		int ejeX,ejeY;
		
		//pedimos que inserte las posiciones 
		System.out.println("Punto A");
		ejeX = leerInt("Inserte el eje X: ");
		ejeY = leerInt("Inserte el eje Y: ");
		
		p1 = new Punto(ejeX,ejeY);
		
		System.out.println("Punto B");
		ejeX = leerInt("Inserte el eje X: ");
		ejeY = leerInt("Inserte el eje Y: ");
		
		p2 = new Punto(ejeX,ejeY);
		
		Linea l1 = new Linea(p1,p2);
		
		
		System.out.println(l1.toString());

		l1.moverArriba(2);
		System.out.println(l1.toString());
	}

	
	//metodo que lee Entero
	public static int leerInt(String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}
}

