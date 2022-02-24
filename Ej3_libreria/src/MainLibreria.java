import java.util.Scanner;


public class MainLibreria {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		

		final int MAX_LIBRO = 100;
		Libro listaLibro [] = new Libro [MAX_LIBRO];
		int cantidadLibro = 0;
		
		int opc = 0;
		do {
			
			boolean opcCorrecta = false;
			do {
				
				try {
					opc = leerInt("Inserta una opcion: ");
					opcCorrecta = true;
				} catch (Exception e) {
					System.out.println("Debe ser un numero.");
				}
				
			}while(opcCorrecta != true);
			
			switch (opc) {
			//dar de alta un libro
			case 1: {
				boolean altaCorrecto = false;
				
				String nombreLibro = leerString("Inserte el titulo del libro: ");
				String nombreAutor = leerString("Inserar el nombre del autor: ");
				String apellidoAutor = leerString("Insertar el apellido del autor; ");

				do {
					try {
						int precioBase = leerInt("Insertar el precio base del libro: ");
						listaLibro[cantidadLibro++] = new Libro(nombreLibro, nombreAutor, apellidoAutor, precioBase);		
						altaCorrecto = true;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
				}while(altaCorrecto !=true);
				
				
				break;
			}
			
			//ver el precio de venta de un libro
			case 2: {
				String nombreLibro = leerString("Insertar el titulo del libro: ");
				
				boolean encontrado = false;
				int posicion = 0;
				for(int i = 0; i<cantidadLibro && encontrado == false;i++) {
					if(listaLibro[i].getTitulo().equals(nombreLibro)) {
						encontrado = true;
						posicion = i;
					}
					
					if(encontrado == true) {
						double precioIva = listaLibro[posicion].getPrecioBase() * Libro.getIva();
						double precioTotal = listaLibro[posicion].getPrecioBase() + precioIva;
						System.out.println(precioTotal + "€");
					}else {
						System.out.println("Libro no encontrado");
					}
				}
				
				break;
			}
			
			//cambiar el precio base de un libro
			case 3: {

				String nombreLibro = leerString("Insertar el titulo del libro: ");
				boolean encontrado = false;
				
				int posicion = 0;
				for(int i = 0; i<cantidadLibro && encontrado == false;i++) {
					if(listaLibro[i].getTitulo().equals(nombreLibro)) {
						encontrado = true;
						posicion = i;
					}
				}
				
				if(encontrado ==true) {
					boolean correcto = false;
					double precioNuevo = 0;
					do {
						try {
							precioNuevo = leerInt("Insertar el nuevo precio: ");
							listaLibro[posicion].setPrecioBase(precioNuevo);
							correcto = true;
						} catch (LibroExpction e) {
							System.out.println(e.getMessage());
						}catch(Exception i) {
							System.out.println("Error inesperado");
						}
					}while(correcto != true);
				}
				
				break;
			}
			
			//mostrar todos los libros
			case 4: {
				for(int i = 0;i<cantidadLibro;i++) {
					System.out.println(listaLibro[i]);
				}
				break;
			}
			
			//Mostrar el total de dinero en la libreria (suma de todos libros de la libreria)
			case 5: {
				boolean encontrado = false;
				double sumaPrecioBase = 0;
				for(int i = 0;i<cantidadLibro;i++) {
					sumaPrecioBase += listaLibro[i].getPrecioBase(); 
					encontrado = true;
				}
				
				if(encontrado == true) {
					double costeIVA = sumaPrecioBase * Libro.getIva();
					double cantidadTotal = costeIVA + sumaPrecioBase;
					System.out.println(cantidadTotal);
				}else {
					System.out.println("No se han encontrado ningun libro");
				}
				
				break;
			}
			//salir
			case 6: {
				System.out.println("Programa finalizado");
				break;
			}
			default:
				System.out.println("Error al insertar una elección");
			}
			
		}while(opc !=6);

	}

	//menu principal
	public static void menu() {
		System.out.println("\n"
				+ "1. Dar de alta un libro\r\n"
				+ "2. Ver el precio de venta de un libro en particular \n" 
				+ "3. Cambiar el precio base de un libro.\r\n"
				+ "4. Mostrar todos los libros existentes.\r\n"
				+ "5. Mostrar el total de dinero que tenemos en la librería \n");
	}
	
	//lee int
	public static int leerInt(String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}
	
	//lee String
	public static String leerString(String texto) {
		System.out.print(texto);
		return teclado.nextLine();
	}
}
