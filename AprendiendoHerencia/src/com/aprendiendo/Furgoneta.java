package com.aprendiendo;

public class Furgoneta extends Coche {

	private int capacidad_carga;
	private int plazas_extras;


	public Furgoneta(int capacidad_carga, int plazas_extras) {
		super();
		this.capacidad_carga = capacidad_carga;
		this.plazas_extras = plazas_extras;
	}
	
	@Override
	public int numero() {
		return 15;
	}

	@Override
	public String toString() {
		return dime_datos_generales() + "Furgoneta [capacidad_carga=" + capacidad_carga + ", plazas_extras=" + plazas_extras + "]";
	}
	
	@Override
	public int velocidadC() {
		int velocidadCamion = super.velocidadC();
		return velocidadCamion + 100;
	}
	
}
