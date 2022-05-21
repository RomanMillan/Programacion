package PlataformaOnline.jacaranda.com;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class Series {

	private HashMap<String, Serie> mapSeries;
	
	/**
	 * Crea el objeto que nos servirá para tener las series
	 */
	public Series() {
		mapSeries=new HashMap<String, Serie>();
	}
	
	
	/** Añade una serie a la lista de series. Si existe una serie con el mismo nombre lanza una excpetion
	 * 
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirSerie(String nombreSerie, int anno, Tema tema) throws SerieException {
		if (mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("Ya existe esa serie");
		}
		Serie serie = new Serie(nombreSerie, anno, tema);
		mapSeries.put(serie.getNombreSerie(), serie);
	}
	
	
	/** Añade una temporada a la Serie cuyo nombre se le pasa por argumento, si no existe
	 * la Serie lanza una exception
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirTemporada(String nombreSerie, String temporada) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.annadirTemporada(temporada);
	}
	
	
	/** Añade un capítulo a la temporada de la Serie cuyo nombre se le pasa por argumento, si no existe
	 * la Serie o la temporada lanza una exception
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirCapituloTemporada(String nombreSerie, String temporada, String capitulo) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.annadirCapituloTemporada(temporada, capitulo);

	}
	
	
	/** Valorar una temporada de la Serie cuyo nombre se le pasa por argumento, si no existe
	 * la Serie o la temporada lanza una exception
	 * @param serie
	 * @throws SerieException
	 */
	public void valorarTemporada(String nombreSerie, String temporada, int valoracion) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.valorarTemporada(temporada, valoracion);
	}
	
	/**
	 * Devuelve el número de temporadas que tiene la serie que se pasa por parámetro
	 * Si no existe la serie saltará la excepción.
	 * @param nombreSerie
	 * @return
	 * @throws SerieException
	 */

	public int numeroDeTemporadasDeUnaSerie(String nombreSerie) throws SerieException{
		int numT= 0;
		if(!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("Serie no encontrada.");
		}
		Serie auxT;
		auxT = mapSeries.get(nombreSerie);
		numT = auxT.numeroTemporadas();
		return numT;
	}
	
	
	
	/** Modifica el tema de una serie. Si no se encuentra la serie o ya tenía ese tema saltará la excepción. 
	 * 
	 * @param nombreSerie
	 * @param nuevoTema
	 * @throws SerieException
	 */
	public void modificarTema( String nombreSerie, Tema nuevoTema) throws SerieException {
		if(!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("Serie no encontrada.");
		}
		Serie auxT;
		auxT = mapSeries.get(nombreSerie);
		if(auxT.getTema().equals(nuevoTema)) {
			throw new SerieException("Serie ya tiene ese tema");
		}
		auxT.setTema(nuevoTema);
	}
	
	
	
	/**
	 * Devolverá un listado ordenado de forma creciente por el año de la serie. 
	 * Para cada serie se mostrará su nombre, año y número de temporadas. 
	 * Si no hay ninguna serie de ese tema saltará la excepción.
	 * @param tema
	 * @return
	 * @throws SerieException
	 */
	public  String listadoOrdenadoSeriesDeUnTema( Tema tema)  throws SerieException {
		StringBuilder r = new StringBuilder();
		ArrayList<Serie> listado = new ArrayList<Serie>();
		for(Serie serie:mapSeries.values()) {
			if(serie.getTema().equals(tema)) {
				listado.add(serie);
			}
		}
		Collections.sort(listado,new OrdenadoPorTema());
		for(Serie serie:listado) {
			r.append(serie.toString()+"\n");
		}
		return listado.toString();
	}
	
	
	//metodo para sacar las series
	public HashSet<Serie> sacarSeries() {
		HashSet series = new HashSet<>();
		Serie auxS;
		for(String clave:mapSeries.keySet()) {
			auxS = mapSeries.get(clave);
			series.add(auxS);
		}
		return series;
	}
	
	//metodo mio para mostrar las series de Series.
	public String toString() {
		StringBuilder s = new StringBuilder();
		Serie auxS;
		for(String clave:mapSeries.keySet()) {
			auxS = mapSeries.get(clave);
			s.append(auxS.getNombreSerie() + "," + auxS.getAnno() + "," + auxS.getTema() + "\n");
		}
		return s.toString();
	}
	
	public void escribirEnFicheroTemporada(String nombre) {
		try {
			FileWriter flujoEscritura=new FileWriter(nombre);
			PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
			
			for(Serie serie:mapSeries.values()) {
				filtroEscritura.print(serie.getTemporadas());
			}
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void escribirEnFicheroCapitulos(String nombre) {
		try {
			FileWriter flujoEscritura=new FileWriter(nombre);
			PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
			
			for(Serie serie:mapSeries.values()) {
				filtroEscritura.print(serie.getCapitulosS());
			}
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}



}
