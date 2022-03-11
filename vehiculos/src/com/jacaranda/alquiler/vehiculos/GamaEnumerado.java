package com.jacaranda.alquiler.vehiculos;

public enum GamaEnumerado {
ALTA(50), MEDIA(40), BAJA(30);
	private final double precio;

	private GamaEnumerado(double precio) {
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	
	
}
