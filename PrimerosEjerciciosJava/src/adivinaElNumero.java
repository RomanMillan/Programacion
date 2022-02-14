import java.util.Scanner;

public class adivinaElNumero {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int cont = 1;
		boolean correcto = false;
		int num = (int) (Math.random()*100);
		
		do {
			System.out.println("¿Cual es el numero?: ");
			int respuesta = Integer.parseInt(teclado.nextLine());
			if (respuesta == num) {
			correcto = true;
			System.out.println("Es correcto, logrado en : " + cont + " intentos.");
			}else {
				System.out.println("El numero no es correcto :( \n intentelo de nuevo.");
				 cont++;
				 if (respuesta < num) {
					 System.out.println("El numero insertado es menor");
				 }else {
					 System.out.println("El numero insertado es mayor");
				 }
			}
			
		}while(correcto != true);
		teclado.close();
	}

}
