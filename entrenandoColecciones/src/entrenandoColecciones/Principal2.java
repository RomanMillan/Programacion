package entrenandoColecciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


public class Principal2 {

	
	public static void main(String[] args) {
		
		
		HashSet<Cancion> listaCanciones = new HashSet<>();
		
		Cancion c1 = new Cancion("A", "Luis", 3.45);
		Cancion c2 = new Cancion("B", "Maria", 4);
		Cancion c3 = new Cancion("C", "Suna", 3);
		//Cancion c4 = new Cancion("A", "Luis", 6.45);
		
		listaCanciones.add(c1);
		listaCanciones.add(c2);
		listaCanciones.add(c3);
		
		//System.out.println(listaCanciones.toString());
		
		/*
		Iterator<Cancion> puntero = listaCanciones.iterator();
		Cancion aux;
		boolean completado = false;
		while(puntero.hasNext()&&!completado) {
			aux = puntero.next();
			if(aux.getNombre().equals("A")) {
				listaCanciones.remove(aux);
				completado = true;
			}
		}
		
		*/
		
		System.out.println("----------");
		//System.out.println(listaCanciones.toString());
		
		//-------------OTRAS PRUEBAS---------

		HashMap<String, Cancion> listaCanciones2 = new HashMap<>();
		
		listaCanciones2.put("A", c1);
		listaCanciones2.put("B", c2);
		listaCanciones2.put("C", c3);
		
		listaCanciones2.put("A", c3);
		
		//System.out.println(listaCanciones2.toString());
		System.out.println("----------------");
		//System.out.println(listaCanciones2.get("A"));

		
		//recorrer un HashMap
		for(String clave:listaCanciones2.keySet()) {
			Cancion auxC;
			auxC = listaCanciones2.get(clave);
		}
		
		
		
		
		//--------Añadir mas canciones a una misma clave.

		HashMap<String,HashSet<Cancion>> listaCanciones3 = new HashMap<>();
		
		HashSet<Cancion> canciones = new HashSet<>();
		canciones.add(c1);
		listaCanciones3.put("Album 1", canciones);
		
		HashSet<Cancion> canciones2 = new HashSet<>();
		canciones2.add(c2);
		listaCanciones3.put("Album 2", canciones2);
		
		canciones.add(c3);
		
		System.out.println(listaCanciones3);

		
		
		
		//--borrar una cancion de un album
		HashSet<Cancion> auxLista = new HashSet<>();
		auxLista = listaCanciones3.get("Album 1");
		
		Iterator<Cancion> puntero = auxLista.iterator();
		Cancion auxCancion;
		boolean completado = false;
		while (puntero.hasNext()&&!completado) {
			auxCancion = puntero.next();
			if(auxCancion.getNombre().equals("A")){
				auxLista.remove(auxCancion);
				completado = true;
			}
		}
		System.out.println(listaCanciones3);

		
		
	}
	
	
	

}
