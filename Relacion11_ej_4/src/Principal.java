import java.util.Scanner;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int elec;
		do {
			menu();
			elec = leerInt("Inserta una opcion: ");
			switch (elec) {
			//nueva pagina consultada
			case 1: {
				
				String url = leerString("Inserta la url: ");
				String fecha = leerString("Insertar la fecha: ()");
				
				Historial h = new Historial();
				h.addPaginaWeb(url, null);
				break;
			}
			//consultar historial completo
			case 2: {
							
				break;
						}
			
			//consultar historial de un dia
			case 3: {
				
				break;
			}
			
			//borrar historial completo
			case 4: {
				
				break;
			}
			//finalizar
			case 5: {
				System.out.println("Programa finalizado");
				break;
			}
			default:
				System.out.println("Error en la eleccion");
			}
		}while(elec!=5);
		
	}
	
	//menú
	public static void menu() {
		System.out.println("\n"
				+ "1. Nueva página consultada \n"
				+ "2. Consultar historial completo.\n"
				+ "3. Consultar historial de un día.\n"
				+ "4. Borrar historial completo.\n"
				+ "5. Salir");
	}
	
	//lee un entero
	public static int leerInt(String texto) {
		System.out.println(texto);
		return Integer.parseInt(teclado.nextLine());
	}
	
	public static String leerString(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}
}
