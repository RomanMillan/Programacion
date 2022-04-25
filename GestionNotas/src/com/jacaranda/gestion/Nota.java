package com.jacaranda.gestion;

import java.time.LocalDate;
import java.util.Objects;

public class Nota {

	private double nota;
	private LocalDate fecha;
	private Alumnado alumno;
	private Modulo modulo;
	
	//Constructor
	public Nota(double nota, LocalDate fecha, Alumnado alumno, Modulo modulo) {
		super();
		this.nota = nota;
		this.fecha = fecha;
		this.alumno = alumno;
		this.modulo = modulo;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getAlumno() {
		return alumno.getDni();
	}

	public String getModulo() {
		return modulo.getNombre();
	}

	@Override
	public int hashCode() {
		return Objects.hash(alumno, fecha, modulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(alumno, other.alumno) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(modulo, other.modulo);
	}

	@Override
	public String toString() {
		return "Nota [nota=" + nota + ", fecha=" + fecha + ", alumno=" + alumno + ", modulo=" + modulo + "]";
	} 
	
	
	
	
	
}
