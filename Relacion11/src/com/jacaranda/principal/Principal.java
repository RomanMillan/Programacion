package com.jacaranda.principal;

import com.jacaranda.equipo.Equipo;
import com.jacaranda.equipo.EquipoException;
import com.jacaranda.jugadores.Alumno;

public class Principal {

	public static void main(String[] args) {

		Alumno a = new Alumno("Roman","4444");
		Alumno a2 = new Alumno("Roman","dd");
		Equipo e = new Equipo("1ºDAW-B");
		
		//añadimos alumno a la lista
		try {
			e.addAlumno(a);
			System.out.println("Alumno añadido.");

		} catch (EquipoException e1) {
			System.out.println(e1.getMessage());
		}

		//intentamos borrar el alumno (no está en la lista)
		try {
			e.borrarALumno(a2);
			System.out.println("Alumno borrado");
		} catch (EquipoException e3) {
			System.out.println(e3.getMessage());
		}
		
		//intentamos añadir el mismo alumno ya añadido
		try {
			e.addAlumno2(a);
			System.out.println("Alumno añadido");
		} catch (EquipoException e1) {
			System.out.println(e1.getMessage());
		}
		
		//miramos si el jugador está en el equipo (true si está, false si no)
		System.out.println(e.estaEquipo(a));
		System.out.println(e.estaEquipo(a2));
		
		//devolvemos la lista de jugadores de equipo
		System.out.println(e.toString());
	
	}

}
