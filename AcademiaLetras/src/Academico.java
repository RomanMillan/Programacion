import java.util.Objects;

public class Academico {

	private String nombre;
	private int annoIngreso;
	private String oficio;
	
	public Academico(String nombre, int annoIngreso, String oficio) {
		super();
		this.nombre = nombre;
		this.annoIngreso = annoIngreso;
		this.oficio = oficio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnnoIngreso() {
		return annoIngreso;
	}

	public void setAnnoIngreso(int annoIngreso) {
		this.annoIngreso = annoIngreso;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
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
		Academico other = (Academico) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Academico [nombre=" + nombre + ", annoIngreso=" + annoIngreso + ", oficio=" + oficio + "]";
	}
	
	
}
