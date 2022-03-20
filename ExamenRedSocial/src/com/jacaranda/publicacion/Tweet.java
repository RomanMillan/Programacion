package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Tweet extends Publicacion {

	//cosntructor
	public Tweet(String texto, Usuario usuario) throws PublicacionException {
		super(texto, usuario);
	}
	
	
	//metodo que agrega el tweet
	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if(texto.length() <= 50) {
			this.texto = texto;
		}else {
			throw new PublicacionException("No puede tener mas de 50 caracteres el tweet");
		}
	}
	
	//metodo que valora el tweet (x2 la valoracion normal)
	@Override
	public boolean valorar(String valoracion) throws PublicacionException {
		try {
			Valoraciones puntValoracion = Valoraciones.valueOf(valoracion.toUpperCase());
			 this.valoracion += (puntValoracion.getValoracion() *2);
			return true;	
		} catch (Exception e) {
			throw new PublicacionException("No es correcta la valoracion");
		}
		 
	}

	//toString
	@Override
	public String toString() {
		return "Tweet." + super.toString();
	}

}
