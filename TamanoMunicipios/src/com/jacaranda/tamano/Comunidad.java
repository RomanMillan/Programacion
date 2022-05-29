package com.jacaranda.tamano;

import java.util.HashSet;
import java.util.Iterator;
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

	public String mostrarPorAnio(int anio) {
		StringBuilder s = new StringBuilder();
		for(Municipio i: listMunicipio) {
			s.append(i.datosAnio(anio));
		}
		return s.toString();

	}
	public String comprobarValor(String comunidad, int anio) {
		int valorSumado = 0;
		Iterator<Municipio> puntero = listMunicipio.iterator();
		Municipio auxM;
		while(puntero.hasNext()) {
			auxM = puntero.next();
			if(!auxM.getDescrip().contains("Total")){
				valorSumado +=  auxM.comprobarValor(anio);
			} 
		}
		int valorTotal = 0;
		boolean encontrado = false;
		Iterator<Municipio> puntero2 = listMunicipio.iterator();
		Municipio auxM2;
		while(puntero2.hasNext()) {
			auxM2 = puntero2.next();
			if(auxM2.getDescrip().contains("Total")&& !encontrado){
				valorTotal =  auxM2.comprobarValor(anio);
				encontrado = true;
			} 
		}
		
		StringBuilder r = new StringBuilder();
		if(valorSumado - valorTotal == 0) {
			r.append("Igual");
		}else {
			r.append("Valor acutal: " + valorTotal+ "\n"
					+ " El valor que deveria estar: " + valorSumado);
		}
		return r.toString();
	}
	
	public String anadirDatos(String descipcion, int anio, int dato) {
		String respuesta ="Inserccion realizada";
		Iterator<Municipio> puntero = listMunicipio.iterator();
		Municipio auxM;
		boolean encontrado = false;
		while(puntero.hasNext()&& !encontrado) {
			auxM = puntero.next();
			if(auxM.getDescrip().contains(descipcion)){
				encontrado = true;
				auxM.anadirDatos(anio, dato);
			}
		}
		if(!encontrado) {
			respuesta = "Error, no encontrada la descripcion";
		}
		return respuesta;
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
