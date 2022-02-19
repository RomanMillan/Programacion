package Ej5;

import java.util.Objects;
/**
 * 
 * @author Román Millán Díaz
 * @version 1.0
 */
public class Equipo {

	private String nombre;
	private String campo;
	private String ciudad;
	private int partidosGanados;

	/**
	 * Constructor que genera un objeto equipo
	 * @param nombre nombre que tendrá el equipo
	 * @param campo nombre que tendrá en campo del equipo
	 * @param ciudad nombre donde pertenece el equipo
	 */
	public Equipo(String nombre, String campo, String ciudad) {
		super();
		this.nombre = nombre;
		this.campo = campo;
		this.ciudad = ciudad;
		partidosGanados = 0;
	}

	//get and set
	/**
	 * Obtener el nombre del equipo
	 * @return nombre del equipo.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Inserta el nombre del equipo
	 * @param nombre El nuevo nombre a insertar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtener el nombre campo
	 * @return nombre del campo
	 */
	public String getCampo() {
		return campo;
	}

	/**
	 * Insertar el nombre campo
	 * @param campo El nombre a insertar
	 */
	public void setCampo(String campo) {
		this.campo = campo;
	}
	
	/**
	 *  Obtener el nombre ciudad
	 * @return nombre ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * Insertar el nombre ciudad
	 * @param ciudad El nombre a insertar
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * Obtener el numero de paritdos ganados
	 * @return numero de partidos ganados
	 */
	public int getPartidosGanados() {
		return partidosGanados;
	}
	
	/**
	 * Insertar el numero de partidos ganados
	 * @param partidosGanados numero
	 */
	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}

	//hashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(nombre, other.nombre);
	}

	//toString
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", campo=" + campo + ", ciudad=" + ciudad + ", partidosGanados="
				+ partidosGanados + "]";
	}
}
