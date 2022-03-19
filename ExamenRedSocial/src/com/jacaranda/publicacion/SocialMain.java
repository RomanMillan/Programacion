package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class SocialMain {

	public static void main(String[] args) {
		
		//creacion de usuario
		Usuario u1 = new Usuario("Nkixk", "161dfa_kk");
		
		//crear publicacion (recomendacion)
		Publicacion r1 = null;
		try {
			r1 = new Recomendacion("viva la fiesta", u1, 4);
			System.out.println(r1.getTexto());
		} catch (PublicacionException e) {
			System.out.println(e.getMessage());
		}

	}

}
