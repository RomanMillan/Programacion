import java.time.LocalDateTime;
import java.util.Scanner;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		
		Historial h = new Historial();
		int elec;
		do {
			menu();
			elec = leerInt("Inserta una opcion: ");
			switch (elec) {
			//nueva pagina consultada
			case 1: {
				
				String url = leerString("Inserta la url: ");
				int dia = leerInt("Insertar el dia: ");
				int mes = leerInt("Insertar el mes: ");
				int anio = leerInt("Insertar el anio: ");
				LocalDateTime fecha = LocalDateTime.of(anio, mes, dia, 0, 0);
				
				try {
					h.addPaginaWeb(url, fecha);
				} catch (HistorialException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			//consultar historial completo
			case 2: {
				System.out.println(h.toString());			
				break;
			}
			
			//consultar historial de un dia
			case 3: {
				int dia = leerInt("Insertar el dia: ");
				int mes = leerInt("Insertar el mes: ");
				int anio = leerInt("Insertar el anio: ");
				LocalDateTime fecha = LocalDateTime.of(anio, mes, dia, 0, 0);
				System.out.println(h.consultarHistorialUnDia(fecha));
				break;
			}
			
			//borrar historial completo
			case 4: {
				h.borrarHistorial();
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
	
	//menu
	public static void menu() {
		System.out.println("\n"
				+ "1. Nueva pagina consultada \n"
				+ "2. Consultar historial completo.\n"
				+ "3. Consultar historial de un dia.\n"
				+ "4. Borrar historial completo.\n"
				+ "5. Salir");
	}
	
	//lee un entero
	public static int leerInt(String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}
	
	public static String leerString(String texto) {
		System.out.print(texto);
		return teclado.nextLine();
	}
}
