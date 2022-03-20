package com.jacaranda.memoryStorage;

import com.jacaranda.publicacion.Post;
import com.jacaranda.publicacion.Publicacion;
import com.jacaranda.publicacion.PublicacionException;
import com.jacaranda.publicacion.Recomendacion;
import com.jacaranda.publicacion.Tweet;
import com.jacaranda.usuario.Usuario;

public class MemoryStorage {

	private static final int NUM_MAXIMO_USUARIOS=15;
	private static final int NUM_MAXIMO_PUBLICACIONES=50;
	private int numUsuarioActuales;
	private int numPublicacionesActuales;
	private Usuario usuarios[] = new Usuario[NUM_MAXIMO_USUARIOS];
	private Publicacion publicaciones[] = new Publicacion[NUM_MAXIMO_PUBLICACIONES];
	
	//constructor
	public MemoryStorage() {
		super();
	}
	
	// busca la posicion del usuario en el array
	private int posicionUsuario(String login) {
		boolean encontrado = false;
		int posicion = -1;
		for(int i=0;i<numUsuarioActuales && encontrado== false;i++) {
			if(usuarios[i].getLogin().equals(login)) {
				encontrado = true;
				posicion = i;
			}
		}
		if(encontrado == true) {
			return posicion;
		}else {
			return posicion;
		}
	}
	
	//agrega un usuario al array de usuarios
	public void addUsuario(String login, String pass) {
		if(numUsuarioActuales< NUM_MAXIMO_USUARIOS) {
			usuarios[numUsuarioActuales] = new Usuario(login, pass);
			numPublicacionesActuales++;	
		}
	}
	
	//a�ade publicacion (tweet)
	public void addPublicacion(String texto,String login) {
		int posicion = posicionUsuario(login);
		
		if(numPublicacionesActuales<NUM_MAXIMO_PUBLICACIONES) {
			try {
				publicaciones[numUsuarioActuales] = new Tweet(texto, usuarios[posicion]);
				numPublicacionesActuales++;
			} catch (PublicacionException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	//a�ade publicacion (post)
	public void addPublicacion(String texto,String login, String tema) {
		int posicion = posicionUsuario(login);
		
		if(numPublicacionesActuales<NUM_MAXIMO_PUBLICACIONES) {
			try {
				publicaciones[numUsuarioActuales] = new Post(texto, usuarios[posicion], tema);
				numPublicacionesActuales++;
			} catch (PublicacionException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	//a�ade publicacion (recomendacion)
	public void addPublicacion(String texto,String login, int numEstrellas) {
		int posicion = posicionUsuario(login);
		
		if(numPublicacionesActuales<NUM_MAXIMO_PUBLICACIONES) {
			try {
				publicaciones[numUsuarioActuales] = new Recomendacion(texto, usuarios[posicion], numEstrellas);
				numPublicacionesActuales++;
			} catch (PublicacionException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	public String mostrarListaPublicaciones() {
		return "";
	}
	
	public String mostrarTweets() {
		publicaciones[i].getTexto();
		return "";
	}
	
	
}




