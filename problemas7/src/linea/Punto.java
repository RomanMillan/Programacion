package linea;

import java.util.Objects;

public class Punto {

	private int ejeX;
	private int ejeY;
	
	//constructor
	public Punto(int ejeX, int ejeY) {
		super();
		this.ejeX = ejeX;
		this.ejeY = ejeY;
	}

	//get and set
	public int getEjeX() {
		return ejeX;
	}

	public int getEjeY() {
		return ejeY;
	}

	public void setEjeX(int ejeX) {
		this.ejeX = ejeX;
	}

	public void setEjeY(int ejeY) {
		this.ejeY = ejeY;
	}

	//hashcode AND equals
	@Override
	public int hashCode() {
		return Objects.hash(ejeX, ejeY);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		return ejeX == other.ejeX && ejeY == other.ejeY;
	}

	//toStirng
	@Override
	public String toString() {
		return "Punto [ejeX=" + ejeX + ", ejeY=" + ejeY + "]";
	}
	
}
