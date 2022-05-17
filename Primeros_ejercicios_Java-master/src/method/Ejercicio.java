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
			
	}
			else {
				result = -1000;
			}
			
			return result;
	}
	
}
