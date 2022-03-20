package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Post extends Publicacion {
	private int numeroLecturas;
	private String tema;
	
	//Constructor
	public Post(String texto, Usuario usuario, String tema) throws PublicacionException {
		super(texto, usuario);
		this.tema = tema;
		this.numeroLecturas = 0;
	}

	//guarda un post
	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if(texto.isEmpty()) {
			throw new PublicacionException("No puede estar vacio");
		}else {
			this.texto = texto;
		}
	}
	
	// guarda una valoracion y contabiliza el numero de lecturas
	@Override
	public boolean valorar(String valoracion) throws PublicacionException {
		try {
			Valoraciones puntValoracion = Valoraciones.valueOf(valoracion.toUpperCase());
			 this.valoracion += puntValoracion.getValoracion();
			 this.numeroLecturas++;
			 return true;
		} catch (Exception e) {
			throw new PublicacionException("No es correcta la valoracion");
		}
	}

	//toString
	@Override
	public String toString() {
		return "Post" + super.toString() + ". Numero de lecturas: " + numeroLecturas ;
	}

}
