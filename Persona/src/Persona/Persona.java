package Persona;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Persona {
	private String nombre;
	private int edad;
	private String dni;
	private Password password;
	private char sexo;
	private double peso;
	private double altura;
	
	//Constructores
	public Persona() {
		super();
		dni = dni();
		password = new Password();
		sexo = 'M';
		edad = 0;
		peso = 0;
		altura = 0;
		nombre = "";
	}

	public Persona(String nombre, int edad, char sexo) throws PersonaException {
		super();
		dni = dni();
		password = new Password();
		this.nombre = nombre;
		setEdad(edad);
		setSexo(sexo);
		peso = 0;
		altura = 0;
		
	}
	

	public Persona(String nombre, int edad, String dni, char sexo, double peso, double altura) throws PersonaException {
		super();
		password = new Password();
		this.nombre = nombre;
		setEdad(edad);
		this.dni = dni;
		setSexo(sexo);
		this.peso = peso;
		this.altura = altura;
	}

	//METODOS

	//generar dni
	private String dni() {
		String dni ="";
		ThreadLocalRandom r1 = ThreadLocalRandom.current();
		for (int i = 0; i < 8; i++) {
			 dni += (char) r1.nextInt(48, 57);
		}
		dni += (char) r1.nextInt(65,90); 	
		return dni;
	}
	//calcular IMC
	public double calcularIMC() {
		double peso;
		final int  BAJOPESO = -1, PESOIDEAL = 0, SOBREPESO = 1;
		peso = this.peso /(Math.pow(this.altura, 2));
		if (peso <20) {
			peso = BAJOPESO; 
		}else if (peso >= 20 && peso <= 25) {
			peso = PESOIDEAL;
		}else {
			peso = SOBREPESO;
		}
		return peso;
	}
	
	//Mira si es mayor de edad
	public boolean esMayorDeEdad() {
		boolean mayor = false;
		if (this.edad >= 18) {
			mayor = true;
		}
		return mayor;
	}
	
	//comprobar el sexo
	public boolean comprobarSexo(char sexo) {
		boolean igual = false;
		if (this.sexo == sexo) {
			igual = true;
		}
		return igual;
	}
	
	//get and set (creo que habia que ponerlos en privado)
	private String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws PersonaException {
		if (edad <0 || edad > 120) {
			throw new PersonaException("00001: Edad incorrecta");
		}
		this.edad = edad;
	}

	private Password getPassword() {
		return password;
	}

	private void setPassword(Password password) {
		this.password = password;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) throws PersonaException{
		if (sexo != 'H' && sexo != 'M') {
			throw new PersonaException("00002: sexo incorrecto");
		}
		this.sexo = sexo;
	}

	private double getPeso() {
		return peso;
	}

	private void setPeso(double peso) {
		this.peso = peso;
	}

	private double getAltura() {
		return altura;
	}

	private void setAltura(double altura) {
		this.altura = altura;
	}

	private String getDni() {
		return dni;
	}

	//HashCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Persona (password = " + password + ", nombre = "+ nombre + ", sexo = "
				+ sexo + ", dni = " + dni + ", peso = " + peso + ", altura = " + altura + ")";
	}
	
}
