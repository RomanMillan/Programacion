package sieteYmedia;

import java.util.Objects;

public class Carta {

	private int numero;
	private String palo;
	
	//constructor
	public Carta(int numero, String palo) throws CartaException {
		super();
		setNumero(numero);
		setPalo(palo);
	}

	//get and set
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) throws CartaException {
		if(numero<0 || numero>12) {
			throw new CartaException("Numero fuera de rango");
		}else {
			this.numero = numero;	
		}
	}

	public String getPalo() throws CartaException {
		return palo;		
	}

	public void setPalo(String palo)throws CartaException  {
		if(!palo.equals("Espada") || palo.equals("Basto") || palo.equals("Oro") || palo.equals("Copa")) {
			throw new CartaException("Palo fuera de opcion");
		}else {
			this.palo = palo;
		}
	}

	//metodo getValor
	public double getValor() {
		double valor;
		if (numero >= 7) {
			valor = 0.5;
		}else {
			valor = numero;
		}
		
		return valor;
	}

	//hashCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(numero, palo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		return numero == other.numero && Objects.equals(palo, other.palo);
	}

	//toString
	@Override
	public String toString() {
		return "Carta [numero=" + numero + ", palo=" + palo + "]";
	}
	
	
}
