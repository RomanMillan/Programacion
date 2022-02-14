package linea;

import java.util.Objects;

public class Linea {

	private Punto puntoA;
	private Punto puntoB;
	
	//constructores
	public Linea() {
		super();
		puntoA = new Punto(0,0);
		puntoB = new Punto(0,0);
	}

	public Linea(Punto puntoA, Punto puntoB) {
		super();
		this.puntoA = puntoA;
		this.puntoB = puntoB;
	}

	//metodos
	//metodo que mueve la linea a la derecha
	public void moverDerecha(int movimiento) {
		puntoA.setEjeX(puntoA.getEjeX()+ movimiento);
		puntoB.setEjeX(puntoB.getEjeX() + movimiento);	
	}
	
	//metodo que mueve la linea a la izquierda
	public void moverIzquierda(int movimiento) {
		puntoA.setEjeX(puntoA.getEjeX() - movimiento);
		puntoB.setEjeX(puntoB.getEjeX() - movimiento);
	}
	
	//metodo que mueve la linea hacia arriba
	public void moverArriba(int movimiento) {
		puntoA.setEjeY(puntoA.getEjeY() + movimiento);
		puntoB.setEjeY(puntoB.getEjeY() + movimiento);
	}
	
	//metodo que mueve la linea hacia abajo
		public void moverAbajo(int movimiento) {
			puntoA.setEjeY(puntoA.getEjeY() - movimiento);
			puntoB.setEjeY(puntoB.getEjeY() - movimiento);
		}
	
	//get AND set
	private Punto getPuntoA() {
		return puntoA;
	}

	private void setPuntoA(Punto puntoA) {
		this.puntoA = puntoA;
	}

	private Punto getPuntoB() {
		return puntoB;
	}

	private void setPuntoB(Punto puntoB) {
		this.puntoB = puntoB;
	}

	//Hashcode And equals
	@Override
	public int hashCode() {
		return Objects.hash(puntoA, puntoB);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Linea other = (Linea) obj;
		return Objects.equals(puntoA, other.puntoA) && Objects.equals(puntoB, other.puntoB);
	}

	//toString
	@Override
	public String toString() {
		return "Linea [puntoA=" + puntoA + ", puntoB=" + puntoB + "]";
	}
	
	
}
