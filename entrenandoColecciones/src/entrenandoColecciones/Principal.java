package entrenandoColecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Principal {

	public static void main(String[] args) {
		HashSet<Cancion> listaCanciones = new HashSet<>();
		HashMap<String, Cancion> listaCanciones4 = new HashMap<>();
		
		ArrayList<Cancion> listaCanciones2 = new ArrayList<>();
		LinkedList<Cancion> listaCanciones3 = new LinkedList<>();
		
		
		Cancion c1 = new Cancion("A", "Luis", 3.45);
		Cancion c2 = new Cancion("B", "Maria", 4);
		Cancion c3 = new Cancion("C", "Suna", 3);
		Cancion c4 = new Cancion("A", "Luis", 6.45); //cancion repetida con c1
		
		
		
		//HashSet
		/*   CARACTERISTICAS:
		 * - Inserta los objetos (Canciones) de forma desordenada.
		 * - No inserta objetos (Canciones) repetidas (se fija en lo que tengamos asignado 
		 * 	 en el hashCode y Equals [Nombre y Autor]).
		 * - Tiene el mejor rendimiento de todas las colecciones Set.
		 * - Para borrar o buscar un objeto solo con crear un objeto aux y pasarle
		 *   los parametros que lo hacen unicos (nombre y autor) vasta.
		 * */
		
		listaCanciones.add(c1);
		listaCanciones.add(c2);
		listaCanciones.add(c3);
		if(!listaCanciones.add(c4))
			System.out.println("no insertado");
		
		System.out.println(listaCanciones.toString());
		
		//-------borramos una cancion
		Cancion aux = new Cancion("A", "Luis", 0);
		if(listaCanciones.contains(aux))
			System.out.println("si contiene");
		
		
		//HashMap
		listaCanciones4.put(c1.getNombre(), c1);
		listaCanciones4.put("B", c2);
		listaCanciones4.put("C", c3);
		
		if(listaCanciones4.containsKey("A"))
			System.out.println("Oh yea");
		
		System.out.println(listaCanciones4.toString());
		
		
		
		//ArrayList
		/*
		 * - Permite elementos duplicados.
		 * - Se ordena de en base a la insercion.
		 * - Es un array dimensionable.
		 * - Mejor rendimiento.
		 * */
		listaCanciones2.add(c1);
		listaCanciones2.add(c2);
		listaCanciones2.add(c3);
		listaCanciones2.add(c4);
		
		System.out.println(listaCanciones2.toString());
		
		//LinkedList
		/*
		 * - Tiene un doble puntero (apunta al objeto anterior y siguente) 
		 * 	[Muy util cuando tenemos que eliminar muchas veces objetos de la lista]
		 * */
		listaCanciones3.add(c1);
		listaCanciones3.add(c2);
		listaCanciones3.add(c3);
		
		System.out.println(listaCanciones3.toString());

	}

}
