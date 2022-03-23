package com.jacaranda.publicacion;

import java.time.LocalDateTime;
import java.util.Objects;

import com.jacaranda.usuario.Usuario;

public abstract class Publicacion implements Valorable, Comparable<Publicacion>{

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
	
	public boolean valorar(String valoracion) throws PublicacionException {
		try {
			Valoraciones puntValoracion = Valoraciones.valueOf(valoracion.toUpperCase());
			 this.valoracion += puntValoracion.getValoracion();
			return true;	
		} catch (Exception e) {
			throw new PublicacionException("No es correcta la valoracion");
		} 
		
	}
	
	//TODO ordenar las publicaciones
	public int compareTo(Publicacion o) {
		if(getValoracion() < o.getValoracion())
			return -1;
		else if (getValoracion()>o.getValoracion())
			return 1;
		else
			if(isAnterior(o))
				return -1;
			else
				return 1;
	}
	
	//mira si la fecha es anterior o posterior.
	public boolean isAnterior(Publicacion pAcomparar) {
		boolean esAnterior = false;
		if(this.fechaCreacion.equals(pAcomparar.fechaCreacion))
			esAnterior = true;
		return esAnterior;
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

	//toString
	@Override
	public String toString() {
		return "Publicación" + texto + ". Realizada por: " + getLoginUsuario()
		+ ". Valoración: " + getValoracion() + ". Fecha de publicacion: " + getFechaCreacion();
	}

	
	
}
