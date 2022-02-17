package Ej5;

import java.util.Objects;

public class Equipo {

	private String nombre;
	private String campo;
	private String ciudad;
	private int partidosGanados;
	//constructor
	public Equipo(String nombre, String campo, String ciudad) {
		super();
		this.nombre = nombre;
		this.campo = campo;
		this.ciudad = ciudad;
		partidosGanados = 0;
	}

	//get and set
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getPartidosGanados() {
		return partidosGanados;
	}

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
