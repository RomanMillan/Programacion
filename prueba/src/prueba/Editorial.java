package prueba;

import java.util.Objects;

public class Editorial {

	private String nombre;
	private String pais;
	
	public Editorial(String nombre, String pais) {
		super();
		setNombre(nombre);
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

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
		Editorial other = (Editorial) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Editorial [nombre=" + nombre + ", pais=" + pais + "]";
	}
	
	
}
