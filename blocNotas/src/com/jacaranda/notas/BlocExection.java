package com.jacaranda.notas;

public class BlocExection extends Exception {

	public BlocExection() {
		super();
	
	}

	public BlocExection(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public BlocExection(String message, Throwable cause) {
		super(message, cause);
	
	}

	public BlocExection(String message) {
		super(message);
	
	}

	public BlocExection(Throwable cause) {
		super(cause);

	}

}
