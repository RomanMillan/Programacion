import java.util.Scanner;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		
		Avion a1 = new Avion("TL-4885",480);
		int opcion, capacidad,km;
		String compania;
		
		do {
			menu();
			opcion = leerInt("Marca una opcion: ");
			
			switch (opcion) {
			case 1: {
				capacidad = leerInt("Inserte la cantida de pasajeros: ");
				km = leerInt("Inserte la distancia del vuelo: ");
				a1.asignarVuelo(capacidad, km);
				break;
			}
			case 2: {
							System.out.println(a1.getNumVuelos());
				break;
						}
			case 3: {
				System.out.println(a1.getTotalKm());
				break;
			}
			case 4: {
				System.out.println(a1.getMediaKm());
				break;
			}
			case 5: {
				compania = leerString("Inserta la nueva compañia: ");
				a1.setCompannia(compania);
				break;
			}
			case 6: {
				System.out.println(a1.toString());
				break;
			}
			case 7: {
				System.out.println("Fin del programa");
				break;
			}
			default:
				System.out.println("Error al marcar una opcion");
			}
			
		}while(opcion !=7);
		
		
	}
	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}
	
	public static String leerString(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}
	
	public static String menu() {
		String menu;
		menu = "1. Asignasr vuelo/ 2. Obtener el numero de vuelos / 3. Obtener el num de km \n"
				+ "4. Obtener la media de km por vuelo / 5. Cambio de compañia \n"
				+ "6. Mostrar informacion del avion / 7. Salir";
		
		return menu;
	}
}
