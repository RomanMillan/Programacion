package ejercicios;

/*
 * Método que muestre los números del 1 al 100 utilizando la instrucción 
 * do.while (repetir .. hasta)
 * */
public class Ej9 {

	public static void main(String[] args) {
		System.out.println(num1Al100());	

	}
	
	//metodo que imprime los num del 1 al 100
		public static String num1Al100() {
			String resultado = "";
			int num = 0;
			do {
				++num;
				resultado += Integer.toString(num) + "\n"; 
			}while(num<100);
			return resultado;
		}
}