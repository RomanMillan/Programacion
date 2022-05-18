package entrenandoColecciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Principal3 {

	public static HashMap<String, ArrayList<Cancion>> albunes = new HashMap<>();
	public static void main(String[] args) {
		
		leerFichero("fichero//canciones.txt");
		System.out.println(albunes.toString());
		
		Cancion c4 = new Cancion("Muerta k sencilla", "maria isabel", 3.40);
		ArrayList<Cancion> listaC = new ArrayList<>();
		listaC.add(c4);
		albunes.put("Album 4", listaC);
		
		escribirEnFicheroVideojuego("fichero//canciones.txt");
		
	}
	
	
	//metodo que lee fichero y lo carga en hashMap
		private static void leerFichero(String nombreFichero) {
			String linea;
			try {
			    //insertamos todo el fichero en un buffer.
				FileReader flujoLectura = new FileReader(nombreFichero);
				BufferedReader filtroLectura = new BufferedReader(flujoLectura);
				
				//lee linea por linea y lo imprime
				linea = filtroLectura.readLine();	
				
				while (linea != null) {
					String[] campos = linea.split(",");
					//cogemos el nombre del album y su primera cancion
					String nomAl = campos[0];
					String nombre = campos[1];
					String autor = campos[2];
					Double duracion = Double.parseDouble(campos[3]);
					
					//miramos si tiene otra cancion mas.
					if(campos.length==4) { //si tiene 1 cancion solo insertamos esa
						Cancion c = new Cancion(nombre,autor,duracion);
						ArrayList<Cancion> listaC = new ArrayList<>();
						listaC.add(c);
						albunes.put(nomAl, listaC);	
					}else { //si tiene 2 canciones insertamos las dos
						Double duracion2 = Double.parseDouble(campos[6]);
						Cancion c = new Cancion(nombre,autor,duracion);
						Cancion c2 = new Cancion(campos[4], campos[5], duracion2);
						ArrayList<Cancion> listaC = new ArrayList<>();
						listaC.add(c);
						listaC.add(c2);
						albunes.put(nomAl, listaC);
					}

					linea = filtroLectura.readLine();
				}

				//cerramos el fichero y buffer
				filtroLectura.close();
				flujoLectura.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("No existe el fichero " + nombreFichero);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} 
		}
		
		
		//escribe la informacion en el archivo (VIDEOJUEGO)
		private static void escribirEnFicheroVideojuego(String nombre) {

			try {
				FileWriter flujoEscritura=new FileWriter(nombre);
				PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
			
				//proceso el fichero
				
				for(String clave: albunes.keySet()) {
					ArrayList<Cancion> auxC  =new ArrayList<>();
					auxC = albunes.get(clave);
					
					Iterator<Cancion> puntero = auxC.iterator();
					Cancion cAux;
					while(puntero.hasNext()) {
						cAux = puntero.next();
						filtroEscritura.println(clave + ","+ cAux.getNombre() 
						+ "," + cAux.getAutor() + ","+ cAux.getDuracion());
					}
				}
				//fin del proceso
				filtroEscritura.close();
				flujoEscritura.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
}
