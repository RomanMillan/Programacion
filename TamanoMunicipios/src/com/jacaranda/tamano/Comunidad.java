package com.jacaranda.tamano;

import java.util.HashSet;
import java.util.Objects;

public class Comunidad {
	private String nombre;
	HashSet<Municipio> listMunicipio;
	

	
	public Comunidad(String descrip) {
		this.nombre = descrip;
		listMunicipio = new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashSet<Municipio> getListMunicipio() {
		return listMunicipio;
	}

	public void setListMunicipio(HashSet<Municipio> listMunicipio) {
		this.listMunicipio = listMunicipio;
	}

	
	//hashCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(listMunicipio, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comunidad other = (Comunidad) obj;
		return Objects.equals(listMunicipio, other.listMunicipio) && Objects.equals(nombre, other.nombre);
	}

	//toString
	@Override
	public String toString() {
		return "Comunidad [nombre=" + nombre + ", listMunicipio=" + listMunicipio + "]";
	}
	
	

	
}
