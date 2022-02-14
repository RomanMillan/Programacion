import java.util.Objects;

public class Avion {
	private String idAvion;
	private int capacidad;
	private int numVuelos;
	private double kmVolados;
	private String compannia;
	
	//Constructor
	public Avion(String idAvion, int capacidad) {
		super();
		this.idAvion = idAvion;
		this.capacidad = capacidad;
		this.kmVolados = 0;
		this.numVuelos = 0;
	}

	public Avion(String idAvion, String compannia,int capacidad) {
		super();
		this.idAvion = idAvion;
		this.capacidad = capacidad;
		this.compannia = compannia;
		this.kmVolados = 0;
		this.numVuelos = 0;
	}

	//get and set
	public String getIdAvion() {
		return idAvion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public int getNumVuelos() {
		return numVuelos;
	}

	public double getTotalKm() {
		return kmVolados;
	}

	public String getCompannia() {
		return compannia;
	}


	public void setKmVolados(double kmVolados) {
		this.kmVolados = kmVolados;
	}

	public void setCompannia(String compannia) {
		this.compannia = compannia;
	}
	
	//metodos 
	public double getMediaKm() {
		double mediaKm = kmVolados / numVuelos;
		return mediaKm;
	}
	
	public boolean asignarVuelo(int capacidad,double kilometros) {
		boolean asignado = false;
		if (capacidad <= this.capacidad &&capacidad>0 && kilometros >0) {
			this.numVuelos ++;
			this.kmVolados += kilometros;
			asignado = true;
		}
		return asignado;
	}
	
	//hashCode and Override
	@Override
	public int hashCode() {
		return Objects.hash(capacidad, compannia, idAvion, kmVolados, numVuelos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avion other = (Avion) obj;
		return capacidad == other.capacidad && Objects.equals(compannia, other.compannia)
				&& Objects.equals(idAvion, other.idAvion)
				&& Double.doubleToLongBits(kmVolados) == Double.doubleToLongBits(other.kmVolados)
				&& numVuelos == other.numVuelos;
	}

	//toString
	@Override
	public String toString() {
		return "Avion [idAvion=" + idAvion + ", capacidad=" + capacidad + ", numVuelos=" + numVuelos + ", kmVolados="
				+ kmVolados + ", compannia=" + compannia + "]";
	}

}
