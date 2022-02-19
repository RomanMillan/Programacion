package Ej5;


import java.util.Objects;
/**
 * 
 * @author Román Millán Díaz
 *@version 1.0
 */
public class Partido {

	private int jornada;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private int golesLocal;
	private int golesVisitante;
	private char resultadoQuiniela;
	private boolean jugado;
	
	//Constructor
	/**
	 * Constructor que genera un objeto partido
	 * @param jornada Jornada donde se realíza el partido
	 * @param equipoLocal Nombre del equipo local
	 * @param equipoVisitante Nombre del equipo visitante
	 * @throws PartidoException Si los equipos son iguales
	 */
	public Partido(int jornada, Equipo equipoLocal, Equipo equipoVisitante) throws PartidoException {
		super();
		setJornada(jornada);
		setEquipoLocal(equipoLocal);
		setEquipoVisitante(equipoVisitante);
		jugado = false;
	}

	//metodos
	/**
	 * Insertar los resultado de un partido
	 * @param resultado los resultados de los dos equipos <b>1-2</b>
	 * @throws PartidoException si los resultado están en un formato no admitidos
	 */
	public void ponerResultado(String resultado)throws PartidoException{
		int posicion = resultado.indexOf("-");
		//miramos si ha insertardo correctamente el formato de resultados
		if (posicion == -1) {
			throw new PartidoException("Error en el formato. num-num");
		}
		
		//intentamos actualizar el resultado, partidos ganados y jugado = true
		try {
			golesLocal = Integer.parseInt(resultado.substring(0, posicion));
			golesVisitante = Integer.parseInt(resultado.substring(posicion + 1));
			
			if (golesLocal > golesVisitante) {
				equipoLocal.setPartidosGanados(equipoLocal.getPartidosGanados()+1);
			}else {
				equipoVisitante.setPartidosGanados(equipoVisitante.getPartidosGanados()+1);
			}
			
			resultadoQuiniela = (char) getResultadoQuiniela();
			jugado = true;
		} catch (Exception e) {
			throw new PartidoException("Error de formato debe ser. num-num ");
		}
		
		
		
	}
	
	//GET and SET
	/**
	 * Obtener los resultados del partido
	 * @return devuelve el resultado del partido
	 */
	public String getResultado() {
		String resultado;
		if(!jugado) resultado ="";
		else if (golesLocal == golesVisitante) resultado = "X";
		else if (golesLocal  > golesVisitante) resultado = "1";
		else resultado = "2";
		return resultado;
	}
	/**
	 * Obtener la jornada
	 * @return numero de jornada
	 */
	public int getJornada() {
		return jornada;
	}

	/**
	 * Insertar la jornada
	 * @param jornada numero de jornada a insertar
	 */
	private void setJornada(int jornada){
			this.jornada = jornada;	
		
	}

	/**
	 * Obtener el objeto del equipo local
	 * @return nombre del equipo local
	 */
	public Equipo getEquipoLocal() {
		Equipo copiaEquipoL = new Equipo(equipoLocal.getNombre(),equipoLocal.getCampo()
				,equipoLocal.getCiudad());
		return copiaEquipoL;
	}

	/**
	 * Insertar objeto del equipo local
	 * @param equipoLocal obejto a insertar
	 * @throws PartidoException si el equipo local es igual que el visitante
	 */
	private void setEquipoLocal(Equipo equipoLocal) throws PartidoException{
		if(equipoLocal.equals(equipoVisitante)) {
			throw new PartidoException("00001: Equipo repetido");
		}
		this.equipoLocal = equipoLocal;
	}

	/**
	 * Obtener el objeto del equipo visitante
	 * @return Objeto visitante
	 */
	public Equipo getEquipoVisitante() {
		Equipo copiaEquipoV = new Equipo(equipoVisitante.getNombre(), equipoVisitante.getCampo()
				,equipoVisitante.getCiudad());
		return copiaEquipoV;
	}

	/**
	 * Insertar el objeto visitante
	 * @param equipoVisitante Objeto visitante a insertar
	 * @throws PartidoException Si el objeto visitante es igual al objeto local
	 */
	private void setEquipoVisitante(Equipo equipoVisitante) throws PartidoException{
		if (equipoVisitante.equals(equipoLocal)) {
			throw new PartidoException("00001: Equipo repetido");
		}
		this.equipoVisitante = equipoVisitante;
	}

	/**
	 * Obtener el numero de goles local
	 * @return numero de goles
	 */
	public int getGolesLocal() {
		return golesLocal;
	}

	/**
	 * Insertar el numero de goles local
	 * @param golesLocal Numero de goles a insertar
	 */
	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}

	/**
	 * Obtener el numero de goles del visitante
	 * @return Numero de goles
	 */
	public int getGolesVisitante() {
		return golesVisitante;
	}

	/**
	 * Insertar el numero de goles del visitante
	 * @param golesVisitante numero de goles
	 */
	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	/**
	 * Obtener el resultado de la quiniela
	 * @return resultado de la quiniela
	 */
	public char getResultadoQuiniela() {
		return resultadoQuiniela;
	}

	/**
	 * Insertar el resultado de la quiniela
	 * @param resultadoQuiniela resulado a insertar
	 */
	public void setResultadoQuiniela(char resultadoQuiniela) {
		this.resultadoQuiniela = resultadoQuiniela;
	}

	//hashCode y equals
	@Override
	public int hashCode() {
		return Objects.hash(equipoLocal, equipoVisitante, jornada);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		return Objects.equals(equipoLocal, other.equipoLocal) && Objects.equals(equipoVisitante, other.equipoVisitante)
				&& jornada == other.jornada;
	}

	
	//toString
	/**
	 * Obtiene el toString de partidos
	 * @return muestra una información diferente en base si el partido se ha jugado o no.
	 */
	public String toString() {
		String respuesta = "";
		if (jugado != true) {
			respuesta = "Partido entre equipo local " + equipoLocal.getNombre() + " y el equipo"
					+ " visitante " + equipoVisitante.getNombre() + " todavia no se ha jugado";
		}else {
			respuesta = "Partido entre equipo local " + equipoLocal.getNombre() + " y el equipo "
					+ "visitante " + equipoVisitante.getNombre() + 
					" jugado en el estadio " + equipoLocal.getCampo() + " de la ciudad "+
					 equipoLocal.getCiudad() + " ha finalizado con " + golesLocal + 
					 " goles del equipo local y " + golesVisitante + " goles del equipo "
					 		+ "visitante. Resultado quiniela = " + resultadoQuiniela;
		}
		return respuesta;
	}
	
	
}
