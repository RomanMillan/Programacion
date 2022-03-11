package com.jacaranda.alquiler.vehiculos;

public enum CarburanteEnum {
GASOLINA(3.5), GASOIL(2);
	private final double precio;

	private CarburanteEnum(double precio) {
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}
	
	
}
