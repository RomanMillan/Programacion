package prueba;

import java.util.Scanner;

public class Libreria {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		
		final int MAXEDITORIAL = 10;
		int numeroEditoriales = 0;
		Editorial listaEditorial [] = new Editorial [MAXEDITORIAL];
		
		final int MAXLIBRO = 100;
		int numeroLibros = 0;
		Libro listaLibro [] = new Libro[MAXLIBRO];
		
		int elec = 0;
		do {
			boolean elecCorrecto = false;
			do {
				try {
					elec = leerInt("Inserte una eleccion: ");
					elecCorrecto = true;
				} catch (Exception e) {
					System.out.println("Debe ser un numero.");
				}
			
			}while(elecCorrecto!=true);
			
			switch (elec) {
			case 1: {
				if(numeroEditoriales==MAXEDITORIAL) {
					System.out.println("Numero de editoriales lleno");
				}else {
					String nombre,pais;
					nombre = leerString("Inserta el nombre de la editorial: ");
					boolean encontrado = false;
					for (int i = 0;i<numeroEditoriales && encontrado == false;i++) {
						if(listaEditorial[i].getNombre().equals(nombre)) {
							encontrado = true;
						}
					}
					pais = leerString("Inserta el nombre del pais: ");	
					
					if(encontrado == true) {
						System.out.println("El nombre de la editorial ya está cojido");
					}else {
						listaEditorial[numeroEditoriales] = new Editorial(nombre, pais);
						numeroEditoriales++;
					}	
				}
				break;
			}
			case 2: {
				String nombre,autor,nombreEditorial;
				
				
				nombre = leerString("Inserta el nombre del libro: ");
				autor = leerString("Inserta el autor: ");
				nombreEditorial = leerString("La editorial");
				
				boolean encontradoEditorail = false;
				int posicion = 0;
				for(int i = 0;i<numeroEditoriales && encontradoEditorail == false;i++) {
					if(listaEditorial[i].getNombre().equals(nombreEditorial)) {
						encontradoEditorail = true;
						posicion = i;
					}
				}
				
				if(encontradoEditorail == true) {
					listaLibro[numeroLibros] = new Libro(nombre, autor, listaEditorial[posicion]);
					numeroLibros++;
				}else {
					System.out.println("Editorial no encontrada");
				}
				
				break;
			}
			case 3: {
				
				break;
			}
			case 4: {
				
				String nombreLibro = leerString("Insertar titulo del libro: ");
				boolean encontrado = false;
				int posicion = 0;
				for (int i = 0;i<numeroLibros && encontrado == false;i++) {
					if(listaLibro[i].getNombre().equals(nombreLibro)) {
						encontrado = true;
						posicion = i;
					}
				}
				
				try {
					int paginas = leerInt("Insertar el numero de paginas: ");
					listaLibro[posicion].setNumPaginas(paginas);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				
				break;
			}
			case 5: {
				for(int i = 0;i<numeroLibros;i++) {
					System.out.println(listaLibro[i]);
				}
				break;
			}
			case 6: {
				
				break;
			}
			case 7: {
				
				break;
			}
			case 8: {
				String nombreEditorial;
				boolean encontrado = false;
				int posicion = 0;
				nombreEditorial = leerString("Insertar el nombre de la editorial: ");
				for (int i = 0; i<numeroEditoriales && encontrado== false;i++) {
					if(listaEditorial[i].getNombre().equals(nombreEditorial)) {
						encontrado = true;
						posicion= i;
					}
				}
				
				if(encontrado == true) {
					System.out.println(listaEditorial[posicion].getPais());
				}else {
					System.out.println("No se encontro la editorial");
				}
				
				break;
			}
			case 9: {
				System.out.println("Programa finalizado");
				break;
			}
			default:
				System.out.println("Error, al insertar una opción.");
			}
			
		}while(elec !=9);
		

	}

	public static void menu() {
		System.out.println("\n"
				+ "1. Crear editorial. \n"
				+ "2. Crear libro. \n"
				+ "3. Mostrar libro. \n"
				+ "4. Agregar paginas. \n"
				+ "5. Mostrar todos los libros. \n"
				+ "6. Mostrar Editorial \n"
				+ "7. Mostrar todas las editoriales. \n"
				+ "8. Mostrar pais de la editorial. \n"
				+ "9. Salir");
	}
	
	public static String leerString(String texto) {
		System.out.print(texto);
		return teclado.nextLine();
	}
	
	public static int leerInt(String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}
}
