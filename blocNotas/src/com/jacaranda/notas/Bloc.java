package com.jacaranda.notas;

import java.util.Arrays;
import java.util.Objects;

public class Bloc {

	private static final int NUMERO_NOTAS_MAXIMA = 20;
	private int numNotas;
	private String nombre;
	private Nota listaNota[]  ;
	
	//constructor
	public Bloc(String nombre) {
		super();
		this.numNotas = 0;
		this.nombre = nombre;
		listaNota = new Nota[NUMERO_NOTAS_MAXIMA];
	}
	
	//getter and setter
	public static int getNumeroNotasMaxima() {
		return NUMERO_NOTAS_MAXIMA;
	}

	public String getNombre() {
		return nombre;
	}

	//metodos
	
	/**
	 * Agrega una nota a un bloc
	 * @param notaAagregar nota a insertar en el bloc
	 * @throws BlocExection Si el bloc está lleno
	 */
	public void agregarNota(Nota notaAagregar) throws BlocExection {
		if(numNotas== NUMERO_NOTAS_MAXIMA) {
			throw new BlocExection("Bloc de notas llenos");
		}	
		else {
			listaNota[numNotas] = notaAagregar;
			numNotas++;
		}	
	}
	
	
	/**
	 * Obtiene la cadena de texto de la nota
	 * @param numNota la posicion de la nota
	 * @return nota de texto
	 * @throws BlocExection si se inserta un numero fuera de la lista
	 */
	public String getNota(int numNota) throws BlocExection {
		String nota;
		if(numNota >this.numNotas ) {
			throw new BlocExection("Fuera de rango");
		}else {
			nota = listaNota[numNota].getTexto();
		}
		return nota;
	}

	/**
	 * Actualiza la nota indicada en posicion
	 * @param numNota posicion de la nota
	 * @param notaAct nota actualizada
	 * @throws BlocExection fuera de la lista de notas
	 */
	public void updateNota(int numNota, String notaAct) throws BlocExection {
		if(numNota >this.numNotas) {
			throw new BlocExection("Fuera de rango");
		}else {
			listaNota[numNota].setTexto(notaAct);
		}
	}
	
	/**
	 * Activa la alarma de una nota
	 * @param numNota posiicion de la nota
	 * @throws BlocExection si no es un objeto de alarma
	 */
	public void activa(int numNota) throws BlocExection {
		if(listaNota[numNota] instanceof NotaAlarma) {
			((NotaAlarma) listaNota[numNota]).activar();
		}else {
			throw new BlocExection("Esta nota no tiene alarma"); 
		}
	}
	
	/**
	 * Desactiva la alarma de una nota
	 * @param numNota posicion de la nota
	 * @throws BlocExection si no es un objeto de alarma
	 */
	public void desactiva(int numNota) throws BlocExection {
		if(listaNota[numNota] instanceof NotaAlarma) {
			((NotaAlarma) listaNota[numNota]).desactivar();
		}else {
			throw new BlocExection("Esta nota no tiene alarma"); 
		}
	}
	
	//ordena la lista de notas (notas y fechas)
	public String ordenaBloc() {
		Nota notasOrdenar[] = new Nota[numNotas];
		StringBuilder salida = new StringBuilder();
		
		for(int i = 0;i<numNotas;i++) {
			notasOrdenar[i] = this.listaNota [i];
		}
		Arrays.sort(notasOrdenar);
		
		for (int i=0;i<numNotas;i++) {
			salida.append(notasOrdenar[i]);
		}
		return salida.toString();
	}
	
	//hashcode and equals
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bloc other = (Bloc) obj;
		return Objects.equals(nombre, other.nombre);
	}

	//toString
	@Override
	public String toString() {
		return "Bloc [numNotas=" + numNotas + ", nombre=" + nombre + ", listaNota=" + 
	Arrays.toString(listaNota) + "] \n";
	}
	
	
}
