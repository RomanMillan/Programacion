package Ej3;

import java.util.Objects;

public class Maquina {
	private int cafe;
	private int leche;
	private int vaso;
	private double monedero;
	private final double COSTECAFE = 1;
	private final double COSTELECHE = 0.8;
	private final double COSTECAFECONLECHE = 1.5;
	
	//constructor
	public Maquina(double monedero) {
		super();
		if (monedero >0) {
			this.monedero = monedero;	
		}
		cafe = 50;
		leche = 50;
		vaso = 80;
	}

	//get and set
	public int getCafe() {
		return cafe;
	}

	public int getLeche() {
		return leche;
	}

	public int getVaso() {
		return vaso;
	}

	public double getMonedero() {
		return monedero;
	}

	//metodos
	//metodo que controla el dinero
	public String controlDinero(double cantidad,int elc) {
		String respuesta;
		if(cantidad <0) {
			respuesta = "No se puede insertar una cantidad negativa.";
		}else if (cantidad >monedero) {
			respuesta = "Lo sentimos, no tenemos cambio";
		}else if ((elc ==1 && cantidad<COSTECAFE)||(cafe == 0 || vaso ==0)) {
			if (cantidad<COSTECAFE) {
				respuesta = "No puede insertar una cantidad menor al precio";
			}else {
				respuesta = "Lo sentimos, no tenemos existencias";
			}
		}else if (elc ==2 && cantidad<COSTELECHE||(leche == 0 || vaso ==0)) {
			if (cantidad<COSTELECHE) {
				respuesta = "No puede insertar una cantidad menor al precio";
			}else {
				respuesta = "Lo sentimos, no tenemos existencias";
			}
		}else if((elc == 3 && cantidad<COSTECAFECONLECHE)||(cafe == 0 ||leche == 0 || vaso ==0)) {
			if (cantidad<COSTECAFECONLECHE) {
				respuesta = "No puede insertar una cantidad menor al precio";
			}else {
				respuesta = "Lo sentimos, no tenemos existencias";
			}
		}else {
			respuesta = "correcto";
		}
		
		return respuesta;
	}
	
	//metodo que sirve cafe
	 public String cafe (double cantidad) {
		 String resp;
		 double cambio;
		 cafe --;
		 vaso --;
		 if (cantidad >COSTECAFE) {
			 monedero += cantidad;
			 cambio = cantidad - COSTECAFE;
			 monedero -= cambio;
			 resp = "Recoge tu cambio de " + cambio + "€";
		 }else {
			 monedero += cantidad;
			 resp = "Recoge su cafe.";
		 }
		 return resp;
	 }
	 
	 //metodo que sirve leche
	 public String leche(double cantidad) {
		 String resp;
		 double cambio;
		 leche--;
		 vaso --;
		 if (cantidad >COSTELECHE) {
			 monedero += cantidad;
			 cambio = cantidad - COSTELECHE;
			 monedero -= cambio;
			 resp = "Recoge tu cambio de " + cambio + "€";
		 }else {
			 monedero += cantidad;
			 resp = "Recoge su leche.";
		 }
		 return resp; 
	 }
	
	 //metodo que sirve cafe con leche
	 public String cafeConLeche(double cantidad) {
		 String resp;
		 double cambio;
		 cafe--;
		 leche--;
		 vaso --;
		 if (cantidad >COSTECAFECONLECHE) {
			 monedero += cantidad;
			 cambio = cantidad - COSTECAFECONLECHE;
			 monedero -= cambio;
			 resp = "Recoge tu cambio de " + cambio + "€";
		 }else {
			 monedero += cantidad;
			 resp = "Recoge su cafe con leche.";
		 }
		 return resp; 
	 }
	 
	 //metodo para vaciar monedero
	 public void vaciarMonedero() {
		 monedero = 0;
	 }
	 
	 //metodo para llenar los depositos
	 public void llenarDepositos() {
		 cafe = 50;
		 leche = 50;
		 vaso = 80;
	 }
	 
	//HashCode and Equals
	@Override
	public int hashCode() {
		return Objects.hash(COSTECAFE, COSTECAFECONLECHE, COSTELECHE, cafe, leche, monedero, vaso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Maquina other = (Maquina) obj;
		return Double.doubleToLongBits(COSTECAFE) == Double.doubleToLongBits(other.COSTECAFE)
				&& Double.doubleToLongBits(COSTECAFECONLECHE) == Double.doubleToLongBits(other.COSTECAFECONLECHE)
				&& Double.doubleToLongBits(COSTELECHE) == Double.doubleToLongBits(other.COSTELECHE)
				&& cafe == other.cafe && leche == other.leche
				&& Double.doubleToLongBits(monedero) == Double.doubleToLongBits(other.monedero) && vaso == other.vaso;
	}

	//toString
	@Override
	public String toString() {
		return "Maquina [cafe=" + cafe + ", leche=" + leche + ", vaso=" + vaso + ", monedero=" + monedero + "]";
	}

}
