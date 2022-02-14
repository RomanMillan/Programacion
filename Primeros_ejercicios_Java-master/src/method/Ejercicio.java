package method;


public class Ejercicio {
	
	public static final Double PI = 3.14;
	

	public static void main(String[] args) {
				
		// Variables
		
		// Inicio
		
				
				
	}
	
	public static int numeroSolucionesEcuacionSegundoGrado(int a, int b, int c) {

		 int x,result = 0;
		x = (int) (Math.pow(b,2)+ (- 4*a*c));
		if (a==0) {
			result = -1;
		}else if (x>0) {
			result = 2;
		}else if (x == 0) {
			result =1;
		}else {
			result = 0;
		}
		return result;
	}
	
	public static Double solucionSumaEcuacionSegundoGrado(int a, int b, int c) {
		 double x,result = 0;
		 int comp=  numeroSolucionesEcuacionSegundoGrado(a, b, c);
		 
		 if (comp==2){
				x = (-b + (Math.pow(b,2)+ (- 4*a*c)) /(2*a));
				result = x;
			}else if (comp == 0) {
				//TODO de una sola solucion
	}
			else {
				result = -1000;
			}
			
			return result;
	}
	
	
	
//	public static Double solucionRestaEcuacionSegundoGrado(int a, int b, int c) {
//		
//	}	
//	
//	public static Double areaCirculo(Double r) {
//		
//	}
//	
//	public static Double longitudCirculo(Double r) {
//		
//	}
//	
//	public static boolean esMultiplo(int a, int b) {
//		
//	}
//	
//	public static int horaMayor(int hora1, int min1, int seg1, int hora2, int min2, int seg2) {
//		
//		
//	}
//	
//	public static int segundosEntre(int hora1, int min1, int seg1, int hora2, int min2, int seg2) {
//				
//		
//	}
//	
//	public static int maximoComunDivisor(int a, int b) {
//		
//	}
//	
//	public static int minimoComunMultiplo(int a, int b) {
//		
//	}
//	
//	public static String binario(int num) {
//		
//	}
//	
//	public static int decimal(String num) {
//		
//	}
}
