package com.micasa.libreria;

public class LibroDigital extends Libro {

	private double precio;
	private formatoEnumerado formato;
	
	//constructor
	public LibroDigital(String titulo, String autor, String editorial, double precio, String formato) throws LibroDigitalExption {
		super(titulo, autor, editorial);
		this.precio = precio;
		try {
			this.formato = formatoEnumerado.valueOf(formato.toUpperCase()) ;	
		} catch (Exception e) {
			throw new LibroDigitalExption("formato digital no valido");
		}
		
	}

	//getter and setter
	public double getPrecio() {
		return precio;
	}

	public formatoEnumerado getFormato() {
		return formato;
	}


	//toString
	@Override
	public String toString() {
		return super.toString() + ". Precio:" + precio + ". Formato:" + formato;
	}
	
	
	
}
