package com.jacaranda.publicacion;


import com.jacaranda.memoryStorage.MemoryStorage;
import com.jacaranda.usuario.Usuario;


public class SocialMain {

	public static void main(String[] args) {
		
		//creacion de usuario
		Usuario u1 = new Usuario("Nkixk", "161dfa_kk");
		
		//crear publicacion (recomendacion)
		Publicacion r1=null;
		try {
			r1 = new Recomendacion("viva la fiesta", u1, 4);
			System.out.println(r1.getTexto());
		} catch (PublicacionException e) {
			System.out.println(e.getMessage());
		}

		//crear un tweet
		Publicacion t1 = null;
		try {
			t1 = new Tweet("La mañana es fria", u1);
		} catch (PublicacionException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(t1.toString());	
	
		//crear un post
		Publicacion p1 = null;
		
		try {
			p1 = new Post("Los pajaros cantan", u1, "cancion");
		} catch (PublicacionException e) {
			System.out.println(e.getMessage());
		}
	
		System.out.println(p1.toString());
		
		
		// valoraciones
		System.out.println("----------------------");
		try {
			t1.valorar("superbuena");
		} catch (PublicacionException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("valoracion tweet: "+t1.getValoracion());
		
		try {
			r1.valorar("superbuena");
		} catch (PublicacionException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("valoracion recomendacion: "+r1.getValoracion());
		
		try {
			p1.valorar("superbuena");
		} catch (PublicacionException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("valoracion post: "+ p1.getValoracion());
		
		
		
		
		
		
	}

}






