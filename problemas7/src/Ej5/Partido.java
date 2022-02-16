package Ej5;

import java.text.ParseException;
import java.util.Objects;

public class Partido {

	private int jornada;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private int golesLocal;
	private int golesVisitante;
	private char resultadoQuiniela;
	
	//constructor
	public Partido(int jornada, Equipo equipoLocal, Equipo equipoVisitante, 
			char resultadoQuiniela) throws PartidoException {
		super();
		this.jornada = jornada;
		setEquipoLocal(equipoLocal);
		setEquipoVisitante(equipoVisitante);
		this.resultadoQuiniela = resultadoQuiniela;
	}

	//metodos
	/**
	 * metodo que pone el resultado del partido
	 * @return
	 */
	public void ponerResultado(String resultado)throws PartidoException{
		
		int posicion = resultado.indexOf("-");
		golesLocal = Integer.parseInt(resultado.substring(0, posicion));
		golesVisitante = Integer.parseInt(resultado.substring(posicion + 1));
		
		if (golesLocal > golesVisitante) {
			equipoLocal.setPartidosGanados(equipoLocal.getPartidosGanados()+1);
		}else {
			equipoVisitante.setPartidosGanados(equipoVisitante.getPartidosGanados()+1);
		}
	}
	
	//get y set
	public int getJornada() {
		return jornada;
	}

	private void setJornada(int jornada) {
		this.jornada = jornada;
	}

	public Equipo getEquipoLocal() {
		Equipo copiaEquipoL = new Equipo(equipoLocal.getNombre(),equipoLocal.getCampo()
				,equipoLocal.getCiudad());
		return copiaEquipoL;
	}

	private void setEquipoLocal(Equipo equipoLocal) throws PartidoException{
		if(equipoLocal.equals(equipoVisitante)) {
			throw new PartidoException("00001: Equipo repetido");
		}
		this.equipoLocal = equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		Equipo copiaEquipoV = new Equipo(equipoVisitante.getNombre(), equipoVisitante.getCampo()
				,equipoVisitante.getCiudad());
		return copiaEquipoV;
	}

	private void setEquipoVisitante(Equipo equipoVisitante) throws PartidoException{
		if (equipoVisitante.equals(equipoLocal)) {
			throw new PartidoException("00001: Equipo repetido");
		}
		this.equipoVisitante = equipoVisitante;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	public char getResultadoQuiniela() {
		return resultadoQuiniela;
	}

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
	
	public String toString(boolean acabado) {
		String respuesta = "";
		if (acabado != true) {
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
