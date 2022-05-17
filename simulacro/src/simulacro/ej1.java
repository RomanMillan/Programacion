package simulacro;

import java.util.Scanner;

public class ej1 {
	
	public static Scanner teclado = new Scanner(System.in);
	//metodo (MAIN)
	public static void main(String[] args) {
		String mens1 = "", mens2 ="",nuevoMens;
		int opc =0,cont =0;
		do {
			menu();
			
			leerInt("Inserte una opcion: ");
			switch (opc) {
			//consulta el num de mensajes
			case 1: {
				if (mens1 !="" && mens2 !="") {
					System.out.println(cont = 2);
				}else if (mens1 !="") {
					System.out.println(cont++)	;
				}else if (mens1 !="") {
				System.out.println(cont++)	;
				}else {
					System.out.println(cont);
				}
				cont = 0;
				break;
			}
			//consulta un mensaje en concreto
			case 2:{
			
			break;	
			}
			//añade un nuevo mensaje
			case 3:{
				if(mens1 == "" || mens2 == "") {
					nuevoMens = leerString("Deje el mensaje");
					if(mens1 =="") {
						mens1 += nuevoMens;
					}else {
						mens2 += nuevoMens;
					}
				}else {
					System.out.println("El buzón de mensajes esta lleno.");
				}
				break;
			}
			//borra todo los mensajes
			case 4:{
				mens1 = "";
				mens2 = "";
				break;
			}
			//finaliza el programa
			case 5:{
				System.out.println("Fin del programa.");
				break;
			}
			//si inserta una opcion no valida salta un error
			default:
				System.out.println("No es una opción aceptada.");
			}
			
		}while(opc != 5 );
				
		
	}
	
	//metodo que lee un entero
	public static int leerInt (String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}
	
	//metodo que lee una cadena
	public static String leerString(String texto) {
		System.out.println(texto);
		return teclado.nextLine();
	}

	//metodo que imprime muestra el menu
	public static String menu() {
		String menu;
		menu = "1.Consultar núm de mensajes \n"
				+ "2. Consultar mensaje : 1.Mensaje núm1 -> 1. Oir  ->2.Borrar // 2. Mensaje núm 2 -> 1. Oir  ->2.Borrar \n"
				+ "3. Añadir mensaje \n"
				+ "4. Borrar todos los mensajes \n"
				+ "5. Salir";
		
		return menu;
	}
	
}
