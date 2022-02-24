package prueba;

import java.util.Objects;

public class Libro {

	private static int generadorISBM = 0;
	private int isbm;
	private String nombre;
	private String autor;
	private Editorial editorial;
	private int numPaginas;
	
	public Libro(String nombre, String autor, Editorial editorial, int numPaginas) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		setEditorial(editorial);
		this.numPaginas = numPaginas;
		isbm += generadorISBM++;
	}
	
	public Libro(String nombre, String autor, Editorial editorial) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		setEditorial(editorial);
		numPaginas = 0;
		isbm += generadorISBM++;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Editorial getEditorial() {
		Editorial editorialCopia = new Editorial(nombre, autor);
		return editorialCopia;
	}

	private void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public int getNumPaginas(){
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) throws LibroException{
		if(numPaginas<= 0) {
			throw new LibroException("El numero de pagina debe ser superior a 0");
		}
		this.numPaginas = numPaginas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbm);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return isbm == other.isbm;
	}

	@Override
	public String toString() {
		return "Libro [isbm=" + isbm + ", nombre=" + nombre + ", autor=" + autor + ", editorial=" + editorial
				+ ", numPaginas=" + numPaginas + "]";
	}
	

}
