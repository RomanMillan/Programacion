package com.jacaranda.genericos;

import java.util.Arrays;

public class Utilidades {
	
		public static <T> void volcarArray(T[] origen, T[]destino) {
			int tamanio = Math.min(origen.length, destino.length);
			for(int i=0;i<tamanio;i++) {
				destino[i]=origen[i];
			}
		}
		
		public static <T> void toString(T[] array) {
			StringBuilder resultado = new StringBuilder();
			for (int i=0;i<array.length;i++) {
				if(array[i] !=null) {
					resultado.append(array[i].toString());
				}
			}
		}
		
		

		public static void main(String[]args) {
			String[] origen = {"Luis","Pepe","Lola"};
			String[] destino = new String[7];
			Integer[] array1Int = {10,20,30};
			Integer[] array2Int = new Integer[7];
			
			Utilidades.volcarArray(origen, destino);
			Utilidades.volcarArray(array1Int, array2Int);
			
			
			System.out.println("Array string origen" + Arrays.toString(origen));
			System.out.println("Array string destino" + Arrays.toString(destino));
			System.out.println("Array string origen" + Arrays.toString(array1Int));
			System.out.println("Array string destino" + Arrays.toString(array2Int));
			
			
		}
	}