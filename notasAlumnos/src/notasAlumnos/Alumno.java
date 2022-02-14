package notasAlumnos;

import java.util.Objects;

public class Alumno {
	//atributos
	private String nombre;
	private String apellidos;
	private String dni;
	private double notaPrimerTrimestre;
	private double notaSegundoTrimestre;
	private double notaTercerTrimestre;
	
	//constructor: crear los objetos e inicializar los atributos  con valor adecuado
	public Alumno(String dni){
		this.dni = dni;
		this.notaPrimerTrimestre = -1;
		this.notaSegundoTrimestre = -1;
		this.notaTercerTrimestre = -1;
	}
	

	public Alumno(String nombre, String apellidos, String dni) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.notaPrimerTrimestre = -1;
		this.notaSegundoTrimestre = -1;
		this.notaTercerTrimestre = -1;
	}


	public Alumno(String nombre, String apellidos, String dni, double notaPrimerTrimestre, double notaSegundoTrimestre,
			double notaTercerTrimestre) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.notaPrimerTrimestre = notaPrimerTrimestre;
		this.notaSegundoTrimestre = notaSegundoTrimestre;
		this.notaTercerTrimestre = notaTercerTrimestre;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public double getNotaPrimerTrimestre() {
		return notaPrimerTrimestre;
	}


	public void setNotaPrimerTrimestre(double notaPrimerTrimestre) {
		this.notaPrimerTrimestre = notaPrimerTrimestre;
	}


	public double getNotaSegundoTrimestre() {
		return notaSegundoTrimestre;
	}


	public void setNotaSegundoTrimestre(double notaSegundoTrimestre) {
		this.notaSegundoTrimestre = notaSegundoTrimestre;
	}


	public double getNotaTercerTrimestre() {
		return notaTercerTrimestre;
	}


	public void setNotaTercerTrimestre(double notaTercerTrimestre) {
		this.notaTercerTrimestre = notaTercerTrimestre;
	}


	public String getDni() {
		return dni;
	}

	public int obtenerFinal() {
		
		int notaFinal= (int) ((notaPrimerTrimestre + notaSegundoTrimestre + notaTercerTrimestre)/3);
				return notaFinal;
	}
	
	


	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", notaPrimerTrimestre="
				+ notaPrimerTrimestre + ", notaSegundoTrimestre=" + notaSegundoTrimestre + ", notaTercerTrimestre="
				+ notaTercerTrimestre + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni);
	}

	
	//metodos
	

}
