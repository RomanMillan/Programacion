import java.util.Objects;

public class Autor {

	private String nombre;
	private String apellido;
	private String seudonimo;
	private String nacionalidad;
	
	//constructor
	public Autor(String nombre, String apellido, String nacionalidad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
	}


	//get and set
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getSeudonimo() {
		return seudonimo;
	}


	public void setSeudonimo(String seudonimo) {
		this.seudonimo = seudonimo;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	//hashCode And Equals
	@Override
	public int hashCode() {
		return Objects.hash(apellido, nacionalidad, nombre);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(nacionalidad, other.nacionalidad)
				&& Objects.equals(nombre, other.nombre);
	}


	//toString
	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", apellido=" + apellido + ", seudonimo=" + seudonimo + ", nacionalidad="
				+ nacionalidad + "]";
	}
	
	
	
	
}
