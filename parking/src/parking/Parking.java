package parking;

import java.util.Objects;

public class Parking {

	private String nombre;
	private Categoria categoria;
	private int total_plazas;
	private static int plazas_ocupadas;
	private double dinero;
	
	//constructor
	public Parking(String nombre, Categoria categoria, int total_plazas) {
		super();
		setNombre(nombre);
		setCategoria(categoria);
		setTotal_plazas(total_plazas);
		plazas_ocupadas = 0;
		dinero = 0;
	}

	//GET AND SET
	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//categorias
	public Categoria getCategoria() {
		Categoria copiaCategoria = new Categoria(categoria.getNombre(), categoria.getPrcioPorMinuto());
		return copiaCategoria;
	}

	private void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	//total_plazas
	public int getTotal_plazas() {
		return total_plazas;
	}

	private void setTotal_plazas(int total_plazas) {
		this.total_plazas = total_plazas;
	}

	//plazas_ocupadas
	public static int getPlazas_ocupadas() {
		return plazas_ocupadas;
	}

	public static void setPlazas_ocupadas(int plazas_ocupadas) {
		Parking.plazas_ocupadas = plazas_ocupadas;
	}

	//dinero
	public double getDinero() {
		return dinero;
	}

	private void setDinero(double dinero) {
		this.dinero = dinero;
	}

	//METODOS
	/*
	 *  1. cobrarYsalirDelParking
	 *   - recibe los min que estubo en el parking
	 *   - Se le devulve el precio
	 *   - Actualizar el numero de plazas_ocupadas
	 *  
	 *  2. entrarParking
	 *   - Ni recibe ni devuleve nada, solo contar que entró un coche.
	 *   - Si el parking está lleno debe generar una ecepcion
	 *   - Actualizar en numero de plazas_ocupadas
	 *   
	 *  3. clonarParking
	 *   - recibe un nuevo nombre del nuevo parking
	 *   - Devolverá un nuevo objeto parking con las mismas caracteristicas
	 *     pero con todas las plazas libres.
	 * */
	
	//cobrar Y salir del parking
	public double cobrarYsalirDelParking(int minutos) throws ParkingException{
		double coste;
		if(minutos <= 0) {
			throw new ParkingException("Tiene que ser mayor que 0");
		}
		coste = minutos * categoria.getPrcioPorMinuto();
		dinero += coste;
		plazas_ocupadas --;
		
		return coste;
	}
	
	//entrar en el parking
	public void entrarParking() throws ParkingException{
		if(plazas_ocupadas == total_plazas) {
			throw new ParkingException("Plazas llenas");
		}
		plazas_ocupadas++;
	}
	
	
	//colnarParking
	public Parking colonarParking(String nombre) throws ParkingException{
		Parking parkingClonado;
		if(this.nombre.equals(nombre)) {
			throw new ParkingException("El nombre ya está cojido.");
		}
		parkingClonado = new Parking(nombre, this.categoria, this.total_plazas);
		return parkingClonado;
	}
	
	//HashCode (son el mismo parking si tienen el mismo nombre)
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
		Parking other = (Parking) obj;
		return Objects.equals(nombre, other.nombre);
	}

	//toString
	@Override
	public String toString() {
		return "Parking [nombre=" + nombre + ", categoria=" + categoria + ", total_plazas=" + total_plazas + ", dinero="
				+ dinero + "]";
	}
	
	
	
}
