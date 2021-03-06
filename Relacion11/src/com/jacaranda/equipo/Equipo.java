package com.jacaranda.equipo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.jacaranda.jugadores.Alumno;

public class Equipo {

	private String nombre;
	private Set<Alumno> listado = new HashSet<Alumno>();
	
	//constructor
	public Equipo(String nombre) {
		super();
		this.nombre = nombre;
		listado = new HashSet<Alumno>();
	}
	//metodos
	//para añadir alumnos al equipo
	public void addAlumno(Alumno alumno) throws EquipoException {
		if(listado.contains(alumno) || alumno==null) {
			throw new EquipoException("Alumno ya está insertado o nulo");
		}
		listado.add(alumno);
	}
	//otra forma de añadir alumno -- .add devuelve un true si se añade o false si 
	// ya existia y no añade nada.
	public void addAlumno2(Alumno alumno) throws EquipoException {
		if(alumno==null || !listado.add(alumno)) {
			throw new EquipoException("Alumno ya está insertado o nulo");
		}
	}

	//para borrar del alumno del equipo
	public void borrarALumno(Alumno alumno) throws EquipoException {
		if(!listado.contains(alumno)) {
			throw new EquipoException("Alumno no está en el equipo");
		}
		listado.remove(alumno);
	}
	
	//para mirar si el alumno está en el equipo
	public boolean estaEquipo(Alumno alumno) {
		boolean existe = false;
		if(listado.contains(alumno)) {
			existe = true;
		}
		return existe;
	}
	
	
	//unir un equipo al equipo sin repetir
	public Equipo unionEquipo(Equipo equipo) {
		Equipo resultado = new Equipo("Union de los dos equipos");
		for(Alumno a: listado) {
			if(equipo.listado.contains(a)) {
				try {
					resultado.addAlumno(a);
				} catch (EquipoException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		return resultado;
	}
	
	
	
	
	//para saber cuantos alumnos tiene el equipo
	public int numAlumnos() {
		return this.listado.size();
	}
	
	
	
	/*
	 * borrar todos los alumnos que se llamen igual.
	 * */
	public boolean delUnAlumno(String nombre) {
		boolean encontrado = false;
		Iterator<Alumno> siguente = listado.iterator();
		
		while(siguente.hasNext()&&!encontrado) {
			Alumno a = siguente.next();
			if(a.getNombre().equalsIgnoreCase(nombre)) {
				listado.remove(a);
				encontrado = true;
			}
		}
		return encontrado;
	}
	
	public void delAlumno(String nombre) {
		while(delUnAlumno(nombre)==true);
	}
	
	//toString
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", listado=" + listado + "]";
	}
	

	
}
