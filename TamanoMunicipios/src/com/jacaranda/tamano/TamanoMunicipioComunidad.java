package com.jacaranda.tamano;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class TamanoMunicipioComunidad {

	private ArrayList<Comunidad> lista;

	public TamanoMunicipioComunidad() {
		lista = new ArrayList<>();
	}

	public ArrayList<Comunidad> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Comunidad> lista) {
		this.lista = lista;
	}

	public String datosAnio(int anio) {
		StringBuilder s = new StringBuilder();
		for(Comunidad i: lista) {
			s.append(i.mostrarPorAnio(anio));
		}
		return s.toString();
	}
	
	public String datosComunAnio(String comunidad, int anio) {	
		StringBuilder s = new StringBuilder();
		boolean encontrado = false;
		Comunidad auxC;
		Iterator<Comunidad> puntero = lista.iterator();
		while(puntero.hasNext()&& !encontrado) {
			auxC = puntero.next();
			if(auxC.getNombre().contains(comunidad)) {
				encontrado = true;
				s.append(auxC.mostrarPorAnio(anio));
			}
		}
		return s.toString();
	}
	
	
	public String inertarDatos(String comunidad, String descripcion, int anio, int dato) {
		String respuesta ="Inserccion realizada";
		Iterator<Comunidad> puntero = lista.iterator();
		Comunidad auxC;
		boolean encontrado = false;
		while(puntero.hasNext()&& !encontrado) {
			auxC = puntero.next();
			if(auxC.getNombre().contains(comunidad)){
				encontrado = true;
				auxC.anadirDatos(descripcion, anio, dato);
				//lista.add(auxC);
			}
		}
		if(!encontrado) {
			respuesta = "Error, no encontrado la comunidad";
		}
		return respuesta;
	}
	
	public String comprobarValor(String comunidad, int anio) {
		String r = "Datos no encontrado";
		Iterator<Comunidad> puntero = lista.iterator();
		Comunidad auxC;
		boolean encontrado = false;
		while(puntero.hasNext()&& !encontrado) {
			auxC = puntero.next();
			if(auxC.getNombre().contains(comunidad)){
				encontrado = true;
				r =  auxC.comprobarValor(comunidad, anio);
			}
		}
		return r;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(lista);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TamanoMunicipioComunidad other = (TamanoMunicipioComunidad) obj;
		return Objects.equals(lista, other.lista);
	}

	@Override
	public String toString() {
		return "TamanoMunicipioComunidad [lista=" + lista + "]";
	}
	
	
	public void cargarDatos(String datos) {
		Gson gson = new Gson();
		this.lista = gson.fromJson(datos, new TypeToken<ArrayList<Comunidad>>(){}.getType());
	}
	
	public void guardarDatosNuevoArchivo(String nombre) {
		final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		final String representacionBonita = prettyGson.toJson(lista);
		try {
			FileWriter flujoEscritura=new FileWriter("fichero/"+nombre + ".json");
			PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
			filtroEscritura.print(representacionBonita);
		
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
	
	public void guardarDatos() {
		final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		final String representacionBonita = prettyGson.toJson(lista);
		try {
			FileWriter flujoEscritura=new FileWriter("fichero/tamanoMunicipioComunidad.json");
			PrintWriter filtroEscritura=new PrintWriter(flujoEscritura);
			filtroEscritura.print(representacionBonita);
		
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
	
}
