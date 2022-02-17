package Ej5;


import java.util.Objects;

public class Partido {

	private int jornada;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private int golesLocal;
	private int golesVisitante;
	private char resultadoQuiniela;
	private boolean jugado;
	
	//constructor
	public Partido(int jornada, Equipo equipoLocal, Equipo equipoVisitante) throws PartidoException {
		super();
		this.jornada = jornada;
		setEquipoLocal(equipoLocal);
		setEquipoVisitante(equipoVisitante);
		jugado = false;
	}

	//metodos
	/**
	 * metodo que pone el resultado del partido
	 * @return
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
			
			resultadoQuiniela = getResultadoQuiniela();
			jugado = true;
		} catch (Exception e) {
			throw new PartidoException("Error de formato debe ser. num-num ");
		}
		
		
		
	}
	
	/**
	 * conseguir el resultado de la quiniela
	 * @return
	 */
	public String getResultado() {
		String resultado;
		if(!jugado) resultado ="";
		else if (golesLocal == golesVisitante) resultado = "X";
		else if (golesLocal  > golesVisitante) resultado = "1";
		else resultado = "2";
		return resultado;
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
