package Ej2;

import java.util.Objects;

public class Producto {

	private static int codigoContado =1;
	private int codigo;
	private String descripcion;
	private double precio;
	private static final int IVA = 20;
	
	//constructor
	public Producto(String descripcion, double precio) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
		codigo = codigoContado ++;
	}
	
	//metodo
	//metodo que calcula el precio de venta del producto
	public double calcularPrecio(Producto p1) {
		double precio;
		precio = p1.getPrecio() + ((p1.getPrecio()*IVA)/100);
		return precio;
	}
	
	//metodo que obtiene el iva
	public int getIVA() {
		return IVA;
	}
	
	//get and set
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio){
		this.precio = precio;
	}

	public int getCodigo() {
		return codigo;
	}

	//hashCode And equals
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return codigo == other.codigo;
	}

	//toString
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}


	
	
}
