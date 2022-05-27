package com.miCasa.zeteam;

public class Goody extends Videojuego {

	private String manual = "no";
	private String extras = "no";

	// constructor
	public Goody(String nombre, double precio, String manual, String extras) throws VideojuegoException {
		super(nombre, precio);
		addManual(manual);
		addExtras(extras);
	}

	// getter and setter
	private void addManual(String manual) {
		if (manual.equals("si")) {
			try {
				super.setPrecio(getPrecio() + 10);
				this.manual = "si";
			} catch (VideojuegoException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void addExtras(String extra) {
		if (extra.equals("si")) {
			try {
				super.setPrecio(getPrecio() + 25);
				extras = "si";
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public String isManual() {
		return manual;
	}

	public String isExtras() {
		return extras;
	}

	// toString
	@Override
	public String toString() {
		return super.toString() + " Goody [manual=" + manual + ", extras=" + extras + "] \n";
	}

}
