package Principal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


import PlataformaOnline.jacaranda.com.Serie;
import PlataformaOnline.jacaranda.com.SerieException;
import PlataformaOnline.jacaranda.com.Series;
import PlataformaOnline.jacaranda.com.Tema;
import PlataformaOnline.jacaranda.com.Temporada;

public class Main {

	public static HashSet<Serie> listaSeries = new HashSet<>();
		
	
	public static void main(String[] args) {

		Series series = new Series();		
		try {
			series.annadirSerie("This is us", 2015, Tema.DRAMA);
			series.annadirSerie("Friends", 1990, Tema.COMEDIA);
			series.annadirSerie("Dallas", 1970, Tema.INTRIGA);
			
			series.annadirTemporada("This is us", "Empezamos");
			series.annadirTemporada("This is us", "Seguimos");
			series.annadirTemporada("This is us", "Finalizamos");
			
			series.annadirCapituloTemporada("This is us", "Empezamos", "La familia");
			series.annadirCapituloTemporada("This is us", "Empezamos", "El problema");
			series.annadirCapituloTemporada("This is us", "Empezamos", "Los niños");
			series.annadirCapituloTemporada("This is us", "Empezamos", "CAsi el final");
			series.annadirCapituloTemporada("This is us", "Empezamos", "El final");
			
			//System.out.println(series.numeroDeTemporadasDeUnaSerie("This is us"));
			//series.modificarTema("This is us", Tema.DRAMA);
			
			series.annadirSerie("SS", 2016, Tema.DRAMA);
			series.annadirSerie("MM", 2010, Tema.DRAMA);
			series.annadirSerie("VV", 2009, Tema.DRAMA);
			
			System.out.println(series.listadoOrdenadoSeriesDeUnTema(Tema.DRAMA));
			
			
			
			//Escribir la informacion en los ficheros.
			//listaSeries.addAll(series.sacarSeries());
			//escribirEnFicheroSeries("ficheros//FicheroSeries.csv");
			
			//series.escribirEnFicheroTemporada("ficheros//FicheroTemporada.csv");
			
			//series.escribirEnFicheroCapitulos("ficheros//FicheroCapitulos.csv");
			
		} catch (SerieException e) {
			e.printStackTrace();
		}
		
		

	}
	
	private static void escribirEnFicheroSeries(String nombre) {

		try {
			FileWriter flujoEscritura=new FileWriter(nombre);
			PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
		
			//proceso el fichero
			
			Iterator<Serie> puntero = listaSeries.iterator();
			Serie aux;
			while(puntero.hasNext()) {
				aux = puntero.next();
				filtroEscritura.println(aux.getNombreSerie() + "," + aux.getAnno() + "," + aux.getTema());
			}
			//fin del proceso
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
