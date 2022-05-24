package com.jacaranda.tamano;
import java.util.ArrayList;
import java.util.Objects;

import com.google.gson.Gson;
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
	
	
	public void CargarDatos(String datos) {
		Gson gson = new Gson();
		this.lista = gson.fromJson(datos, new TypeToken<ArrayList<Comunidad>>(){}.getType());
	}
	
	
}
