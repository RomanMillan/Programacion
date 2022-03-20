package com.jacaranda.usuario;

import java.util.Objects;

public class Usuario {

	private String login;
	private String pass;
	
	//constructor
	public Usuario(String login, String pass) {
		super();
		this.login = login;
		this.pass = pass;
	}

	//getter and setter
	public String getLogin() {
		return login;
	}

	//cambia el password antiguo por uno nuevo
	public boolean setPass(String passAntiguo, String passNuevo) {
		if(pass.equals(passAntiguo)) {
			pass = passNuevo;
			return true;
		}else {
			return false;
		}
	}

	//hashCode and Equals (login)
	@Override
	public int hashCode() {
		return Objects.hash(login);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(login, other.login);
	}

	//solo puesto para probar
	@Override
	public String toString() {
		return "Usuario [login=" + login + ", pass=" + pass + "]";
	}
	
	
}
