package Ej2;

public class MainProducto {

	public static void main(String[] args) {
		
		Producto p1 = new Producto("Hola ",500);
		System.out.println(p1.getCodigo());

			System.out.println(p1.calcularPrecio(p1));
			
			System.out.println(p1.getIVA());
	}
}
