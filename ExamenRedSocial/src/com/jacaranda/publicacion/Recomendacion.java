package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Recomendacion extends Publicacion {
	private int numeroEstrellas;

	//constructor
	public Recomendacion(String texto, Usuario usuario, int numeroEstrellas) throws PublicacionException {
		super(texto, usuario);
		this.numeroEstrellas = numeroEstrellas;
	}

	//agrega una recomendacion
	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if((texto.length()>= 4 && texto.length() <= 200) && 
				(numeroEstrellas>= 1 && numeroEstrellas<= 5)) {
			this.texto = texto;
		}else {
			throw new PublicacionException("No cumple las normas de recomendación");
		}
	}

	public int getNumeroEstrellas() {
		return numeroEstrellas;
	}

	//toSting
	@Override
	public String toString() {
		return "Recomendación. \n"
				+ super.toString() + ". Número de estrellas: " + getNumeroEstrellas() ;
	}
	
	

}
