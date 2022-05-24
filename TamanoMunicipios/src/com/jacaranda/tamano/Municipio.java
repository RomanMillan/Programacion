package com.jacaranda.tamano;

import java.util.HashSet;
import java.util.Objects;

public class Municipio {

	private String  descrip;
	HashSet<Datos> datos;
	
	//constructor
	public Municipio(String descrip) {
		super();
		this.descrip = descrip;
		datos = new HashSet<>();
	}

	//getter and setter
	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public HashSet<Datos> getDatos() {
		return datos;
	}

	public void setDatos(HashSet<Datos> datos) {
		this.datos = datos;
	}

	//hashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(datos, descrip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Municipio other = (Municipio) obj;
		return Objects.equals(datos, other.datos) && Objects.equals(descrip, other.descrip);
	}

	//toString
	@Override
	public String toString() {
		return "Municipio [descrip=" + descrip + ", datos=" + datos + "]";
	}
	
	
	
	
	
	
}
