package Persona;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Password {

	private final int LONGITUD = 8;
	private int longitud;
	private String contrasena;

	/**
	 * - Generar un constructor que genere una clave aleatoria de long 8 
	 * - Generar otro constructor que reciba la longitud de la contraseña a generar
	 */

	// constructor que genera una contraseña
	public Password() {
		super();
		this.contrasena = "";
		ThreadLocalRandom r1 = ThreadLocalRandom.current();
		for (int i = 0; i < LONGITUD; i++) {
			int num = r1.nextInt(48, 122);
			this.contrasena += (char) num;
		}
	}

	// constructor que genera una contraseña indicando la longitud desde el usuario
	public Password(int longitud) {
		super();
		this.contrasena = "";
		this.longitud = longitud;
		ThreadLocalRandom r1 = ThreadLocalRandom.current();
		for (int i = 0; i < this.longitud; i++) {
			int num = r1.nextInt(48, 122);
			this.contrasena += (char) num;
		}
	}

	// get and set
	public int getLongitud() {
		return longitud = contrasena.length();
	}

	public String getContrasena() {
		return contrasena;
	}

	/**
	 * - metodo para comprobar si la contraseña es fuerte (+2Mays / +1Minus / +5Num)
	 * - metodo que genere una nueva contraseña aleatoria con la longitud insertada
	 * por el usario
	 */
	
	// metodo que comprueba si la contraseña es fuerte
	public boolean esFuerte() {
		boolean fuerte = false, mayus = false, minus = false, num = false;
		int cont = 0, caracter, mayusCont = 0, minusCont = 0,numCont = 0;
		do {
			caracter = contrasena.charAt(cont);
			if (caracter >= 65 && caracter <= 90) {
				mayusCont++;
				if (mayusCont == 2) {
					mayus = true;
				}
			} else if (caracter >= 97 && caracter <= 122) {
				minusCont++;
				if (minusCont == 2) {
					minus = true;
			}else if(caracter >= 48 && caracter <= 57) {
				numCont++;
				if(numCont == 2) {
						num = true;
				}
			  }
			}
			cont++;
		} while (cont < longitud && (mayus == false || minus == false || num == false));
		
		if (!(mayus == false || minus == false || num == false)) {
			fuerte = true;
		}
		return fuerte;
	}
	
	//metodo que genera una nueva contraseña desde el parameto que determine
	public void generarPassword(int longitud) {
		this.longitud = longitud;
		this.contrasena = "";
		ThreadLocalRandom r1 = ThreadLocalRandom.current();
		for (int i = 0; i < this.longitud; i++) {
			int num = r1.nextInt(48, 122);
			this.contrasena += (char) num;
		}
	}
	
	// hastCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(contrasena);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Password other = (Password) obj;
		return Objects.equals(contrasena, other.contrasena);
	}

	// toString
	@Override
	public String toString() {
		return this.contrasena;
	}

}
