package com.jacaranda.publicacion;

import java.time.LocalDateTime;
import java.util.Objects;

import com.jacaranda.usuario.Usuario;

public abstract class Publicacion implements Valorable{

	protected String texto;
	private LocalDateTime fechaCreacion;
	protected int valoracion;
	private int codigo;
	private static int codigoSiguente =1;
	private Usuario usuario;
	
	//constructor
	public Publicacion(String texto, Usuario usuario) throws PublicacionException {
		super();
		setTexto(texto);
		this.usuario = usuario;
		codigo += codigoSiguente++;
		fechaCreacion = LocalDateTime.now();
		valoracion = 0;
	}

	//metodos 
	protected abstract void setTexto(String texto) throws PublicacionException;
	
	public boolean valorar(String valoracion) {
		 Valoraciones puntValoracion = Valoraciones.valueOf(valoracion.toUpperCase());
		 this.valoracion += puntValoracion.getValoracion();
		return true;
	}
	
	//getter and setter
	public String getTexto() {
		return texto;
	}

	public int getCodigo() {
		return codigo;
	}

	public Usuario getLoginUsuario() {
		return usuario;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	
	public int getValoracion() {
		return valoracion;
	}

	//hashCode and Equals (fechaCreación y texto)
	@Override
	public int hashCode() {
		return Objects.hash(fechaCreacion, texto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicacion other = (Publicacion) obj;
		return Objects.equals(fechaCreacion, other.fechaCreacion) && Objects.equals(texto, other.texto);
	}


	@Override
	public String toString() {
		return "Publicación" + texto + ". Realizada por: " + getLoginUsuario()
		+ ". Valoración: " + getValoracion() + ". Fecha de publicacion: " + getFechaCreacion();
	}

	
	
}
