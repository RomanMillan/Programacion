package com.jacaranda.elementos;

import com.jacaranda.enumerados.PlayerType;

public class Jugador {

	private int dinero;
	private int gemas;
	private PlayerType player;
	private int pociones;
	
	//constructor
	public Jugador(PlayerType player) {
		super();
		this.player = player;
	}

	//getter and setter
	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public int getGemas() {
		return gemas;
	}

	public void setGemas(int gemas) {
		this.gemas = gemas;
	}

	public int getPociones() {
		return pociones;
	}

	public void setPociones(int pociones) {
		this.pociones = pociones;
	}

	public PlayerType getPlayer() {
		return player;
	}
	
	//TODO consegur la fuerza
	private int getFuerza() {
		
	}
	
}
