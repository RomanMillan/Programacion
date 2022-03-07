package sieteYmedia;

import java.util.Objects;

public class Carta {

	private int numero =0;
	private String numMayor="";
	private String palo;
	
	//constructores
	public Carta(int numero, String palo) throws CartaException {
		super();
		setNumero(numero);
		setPalo(palo);
	}
	

	public Carta(String numMayor, String palo) throws CartaException {
		super();
		setNumMayor(numMayor);
		setPalo(palo);
	}


	//get and set
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) throws CartaException {
		if(numero<0 || numero>10) {
			throw new CartaException("Numero fuera de rango");
		}else {
			this.numero = numero;	
		}
	}

	public String getPalo() throws CartaException {
		return palo;		
	}

	public void setPalo(String palo)throws CartaException  {
		if(!palo.equals("Espada") && palo.equals("Basto") && palo.equals("Oro") && palo.equals("Copa")) {
			throw new CartaException("Palo fuera de opcion");
		}else {
			this.palo = palo;
		}
	}
	
	

	public String getNumMayor() {
		return numMayor;
	}


	public void setNumMayor(String numMayor) throws CartaException {
		if(!numMayor.equals("Sota") && numMayor.equals("Caballo") && numMayor.equals("Rey")) {
			throw new CartaException("Numero mayor fuera de rango");
		}
		this.numMayor = numMayor;
	}


	//metodo getValor
	public double getValor() {
		double valor;
		if (!numMayor.equals("")) {
			valor = 0.5;
		}else {
			valor = numero;
		}
		
		return valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numMayor, palo);
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
		return Objects.equals(numMayor, other.numMayor) && Objects.equals(palo, other.palo);
	}


	@Override
	public String toString() {
		if(numero!=0) {
			return "Carta [numero=" + numero + ", palo=" + palo + "]";
		}else {
			return "Carta [numero=" + numMayor + ", palo=" + palo + "]";	
		}
		
	}

	
	
	//toString
	
	
	
}
