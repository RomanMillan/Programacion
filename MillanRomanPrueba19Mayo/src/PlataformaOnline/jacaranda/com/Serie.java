package PlataformaOnline.jacaranda.com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/*Se ha optado por usar un LinkedList ya que en uno de los metodos te pide que insertes un capitulo en 
 * una posicion concreta entre medio de dos capitulos. Con LinkedList es muy facil hacer esto ya que guarda los datos del anterior y siguente
 * y para insertar el objeto solo basta con pasarle el objeto y la posición donde lo queremos insertar.
 * También ofrece otras comodidadas por el estilo.
 * */


public class Serie{
	private static final int ANNO_MINIMO = 1900; // Sólo se almacenrará series posteriores a 1900
	private String nombreSerie; // Nombre de la serie
	private int anno; //Año de la primera temporada de la serie
	private Tema tema; // Tema de la serie
	private ArrayList<Temporada> temporadas; // Lista de las temporadas de las series.
	
	
	/**
	 * Constructor que recibe el nombre de la serie, el año de creación y el tema.  Se crea la serie sin ninguna temporada
	 * @param nombreSerie
	 * @param anno
	 * @param tema
	 * @throws SerieException: si el año es anterior a 1900 se lanzará una exception
	 */
	public Serie(String nombreSerie, int anno, Tema tema) throws SerieException {
		super();
		this.nombreSerie = nombreSerie;
		setAnno(anno);
		this.tema = tema;
		temporadas=new ArrayList<Temporada>();
	}
	
	/**
	 * Añade una nueva temporada. Se le pasará el nombre de la nueva temporada y se añadirá al final.
	 * Debe comprobar que no existe un temporada con ese nombre en cuyo caso saltará la excepción.
	 * @param nombreTemporada
	 * @throws SerieException
	 */
	public void annadirTemporada( String nombreTemporada) throws SerieException {
		Iterator<Temporada> puntero = temporadas.iterator();
		boolean encontrado = false;
		Temporada auxT;
		//compruebo si ya está agreagada la temporada
		if(temporadas.contains(nombreTemporada)){
			throw new SerieException("Temporada ya agregada");
		}
		
		while (puntero.hasNext()&&!encontrado) {
			auxT = puntero.next();
			if(auxT.getNombre().equals(nombreTemporada)) {
				encontrado = true;
				throw new SerieException("Temporada ya agregada");
			}
		}
		Temporada nomTemporada = new Temporada(nombreTemporada);
		temporadas.add(nomTemporada);
		
	}
	
	
	/**
	 * Añade un nuevo capítulo a una temporada. Se le pasará el nombre de la temporada y si la temporada no existe
	 * se lanzará una exception
	 * @param nombreTemporada
	 * @param nombreCapitulo
	 * @throws SerieException
	 */
	public void annadirCapituloTemporada( String nombreTemporada, String nombreCapitulo) throws SerieException {
		Temporada temporada = new Temporada(nombreTemporada);
		int pos = temporadas.indexOf(temporada);
		if (pos == -1) {
			throw new SerieException("No existe la temporada");
		}
		temporadas.get(pos).annadirCapitulo(nombreCapitulo);
	}
	
	
	/**
	 * Valorar temporada. Si no exsite la temporada lanza una exception.
	 * @param nombreTemporada
	 * @param valoracion
	 * @throws SerieException
	 */
	
	public void valorarTemporada(String nombreTemporada, int valoracion) throws SerieException {
		Temporada temporada = new Temporada(nombreTemporada);
		int pos = temporadas.indexOf(temporada);
		if (pos == -1) {
			throw new SerieException("No existe la temporada");
		}
		temporadas.get(pos).valorar(valoracion);
		
	}
	/**
	 * Devuelve un listado de las temporadas de una serie ordenadas  de mayor a menor por nota media. 
	 * De cada temporada se mostrará el nombre, número de capítulos y nota media
	 * @return
	 */
	public String listadoTemporadasPorNotaMedia() {
		StringBuilder r = new StringBuilder();
		Collections.sort(this.temporadas,new OrdenarPorNotaMedia());
		for(Temporada temporada:this.temporadas) {
			r.append(temporada.toString()+"\n");
		}
		
		return r.toString();
	}
	
	/**
	 * Devuelve un listado de las temporadas de una serie ordenadas de menor a mayor por número de capítulos. 
	 * De cada temporada se mostrará el nombre, número de capítulos y nota media.
	 * @return
	 */
	public String listadoTemporadasPorNumeroDeCapitulos() {
		StringBuilder resultado = new StringBuilder();
		Collections.sort(this.temporadas,new OrdenarPorNumerosDeCapitulos());
		for(Temporada temporada:this.temporadas) {
			resultado.append(temporada.toString()+"\n");
		}
		return resultado.toString();
		
	}
	
	
	/**
	 * Devuelve el nombre de la Serie
	 * @return
	 */
	public String getNombreSerie() {
		return nombreSerie;
	}


	/** Asigna el nombre de la serie
	 * 
	 * @param nombreSerie
	 */
	public void setNombreSerie(String nombreSerie) {
		this.nombreSerie = nombreSerie;
	}


	/**
	 * Devuelve el año
	 * @return
	 */
	public int getAnno() {
		return anno;
	}


	/**
	 * Asinga el año
	 * @param anno
	 * @throws SerieException
	 */
	public void setAnno(int anno) throws SerieException {
		if ( anno < ANNO_MINIMO) {
			throw new SerieException("Anno incorrecto");
		}
		this.anno = anno;
	}


	/**
	 * Devuelve el tema
	 * @return
	 */
	public Tema getTema() {
		return tema;
	}

	/** Asinga el tema
	 * 
	 * @param tema
	 */
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	/** 
	 * Devuelve el número de temporadas que tiene la serie
	 * @return
	 */
	public int numeroTemporadas() {
		return temporadas.size();
	}

	
	/**
	 * toString
	 */
	public String toString() {
		return  "Serie " + nombreSerie + " Anno " + anno + " Tema " + tema + "Numero temporadadas " + numeroTemporadas() +"\n";
	}
	
	public String toString2() {
		return temporadas.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreSerie == null) ? 0 : nombreSerie.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		if (nombreSerie == null) {
			if (other.nombreSerie != null)
				return false;
		} else if (!nombreSerie.equals(other.nombreSerie))
			return false;
		return true;
	}

	/*
	public HashSet<Temporada> sacarTemporada(){
		Iterator<Temporada> puntero = temporadas.iterator();
		HashSet<Temporada> listaT = new HashSet<>();
		Temporada auxT;
		while(puntero.hasNext()) {
			auxT = puntero.next();
			listaT.add(auxT);
		}
		return listaT;
	}
	*/
	
	public String getTemporadas() {
		StringBuilder s = new StringBuilder();
		for(Temporada t: temporadas) {
			s.append(this.nombreSerie + ","+ t.getNombre() + "," + t.getNumeroCapitulos() + "," + t.getSumaOpiniones()
			+ "," + t.getNumeroOpiniones() + "\n");
		}
		return s.toString();
	}
	
	public String getCapitulosS() {
		StringBuilder s = new StringBuilder();
		for(Temporada t: temporadas) {
			
			s.append(this.nombreSerie +","+ t.getNombre() + ","+t.getCapitulos() + "\n");
		}
		return s.toString();
	}
	
}
