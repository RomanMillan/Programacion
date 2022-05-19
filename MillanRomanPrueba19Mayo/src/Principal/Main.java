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
	public static Series series = new Series();	
	
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
			
			
			//System.out.println(series.toString());
			
			listaSeries.addAll(series.sacarSeries());
			
			//System.out.println(listaSeries.toString());
			
			//mis pruebas de Temporada.
			/*
			Temporada t1 = new Temporada("Temp");
			t1.annadirCapitulo("c1");
			t1.annadirCapitulo("c2");
			t1.annadirCapitulo("c3");
			t1.annadirCapitulo("c4");
			t1.annadirCapitulo("c5");
			t1.annadirCapitulo("c6");
			t1.annadirCapitulo("c7");
			*/
			//System.out.println(t1.primerCapituloQueContieneEstaPalabara("dd"));
			
			//t1.anadirCapituloDespues("c5_1", "c5");
			//System.out.println(t1.toStringMio());
			
			//pruebas Serie
//			Serie s1 = new Serie("Serie1", 2010, Tema.COMEDIA);
//			
//			s1.annadirTemporada("t1");
//			System.out.println(s1.toString2());
//			s1.annadirTemporada("t2");
//			System.out.println(s1.toString2());

			//pruebas Series

			
			
			escribirEnFicheroSeries("ficheros//FicheroSeries.csv");
			
		} catch (SerieException e) {
			// TODO Auto-generated catch block
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
	
	//NO me ha dado tiempo de terminarlo necesito modificarlo para temporada
	private static void escribirEnFicheroTemporada(String nombre) {
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

