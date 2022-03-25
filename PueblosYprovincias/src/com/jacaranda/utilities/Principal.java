package com.jacaranda.utilities;

public class Principal {

	public static void main(String[] args) {
		
		Pueblo p1;
		try {
			p1 = new Pueblo("Tordesilla", "856472");
			System.out.println(p1.toString());
		} catch (PuebloException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			p1 = new Pueblo("Tocina", "1564847", 4, 25025, 4000);
			System.out.println(p1.toString());
		} catch (PuebloException e) {
			System.out.println(e.getMessage());
		}

	}

}
