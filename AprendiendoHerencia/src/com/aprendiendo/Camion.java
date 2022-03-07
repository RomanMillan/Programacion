package com.aprendiendo;

public class Camion extends Coche{

	private boolean gancho;
	private double cargaPeso;
	
	//constructor
	public Camion(double cargaPeso) {
		super();
		this.gancho = false;
		this.cargaPeso = cargaPeso;
	}

	public void anadirGancho() {
		gancho = true;
	}
	
	
	
	@Override
	public String toString() {
		return super.toString() +  "Camion [gancho=" + gancho + ", cargaPeso=" + cargaPeso + "]";
	}

	@Override
	protected int numero() {
		return 40;
	}
	
	@Override
	public int velocidadC() {
		int velocidadCamion = super.velocidadC();
		return velocidadCamion + 20;
	}
	
}
