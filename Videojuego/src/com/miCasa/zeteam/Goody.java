package com.miCasa.zeteam;

public class Goody extends Videojuego {

	private boolean manual;
	private boolean extras;

	// constructor
	public Goody(String nombre, double precio, boolean manual, boolean extras) throws VideojuegoException {
		super(nombre, precio);
		addManual(manual);
		addExtras(extras);
	}

	// getter and setter
	private void addManual(boolean manual) {
		if (manual) {
			try {
				super.setPrecio(getPrecio() + 10);
				this.manual = true;
			} catch (VideojuegoException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void addExtras(boolean extra) {
		if (extra) {
			try {
				super.setPrecio(getPrecio() + 25);
				extras = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public boolean isManual() {
		return manual;
	}

	public boolean isExtras() {
		return extras;
	}

	// toString
	@Override
	public String toString() {
		return super.toString() + " Goody [manual=" + manual + ", extras=" + extras + "] \n";
	}

}
