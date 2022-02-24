import java.time.LocalDate;

public class Libro {

	private String titulo;
	private Autor autor;
	private String nombreAutor;
	private String apellidoAutor;
	private double precioBase;
	private static final double IVA = 0.25;
	private LocalDate fechaPublicacion;
	private String isbn ="";
	
	//constructores
	public Libro(String titulo, Autor autor, double precioBase) throws LibroExpction {
		super();
		this.titulo = titulo;
		this.autor = autor;
		setPrecioBase(precioBase);
		fechaPublicacion = LocalDate.now();
		isbn += titulo.substring(0, 2);
		isbn += autor.getNombre().substring(0, 2);
		isbn += autor.getApellido().substring(autor.getApellido().length()-2); 
		 
	}

	public Libro(String titulo, String nombreAutor, String apellidoAutor, double precioBase) throws LibroExpction {
		super();
		this.titulo = titulo;
		this.nombreAutor = nombreAutor;
		this.apellidoAutor = apellidoAutor;
		autor = new Autor(nombreAutor, apellidoAutor, "España");
		
		setPrecioBase(precioBase);
		fechaPublicacion = LocalDate.of(2000, 5, 10);
		isbn += titulo.substring(0, 2);
		isbn += autor.getNombre().substring(0, 2);
		isbn += autor.getApellido().substring(autor.getApellido().length()-2); 
	}

	
	//Get and Set
	public String getTitulo() {
		return titulo;
	}

	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getApellidoAutor() {
		return apellidoAutor;
	}

	public void setApellidoAutor(String apellidoAutor) {
		this.apellidoAutor = apellidoAutor;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) throws LibroExpction {
		if(precioBase<0) {
			throw new LibroExpction("el precio no puede ser menor a 0");
		}
		this.precioBase = precioBase;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getIsbn() {
		return isbn;
	}

	private void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public static double getIva() {
		return IVA;
	}

	
	//toString
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + "precioBase=" + precioBase + ", fechaPublicacion=" + fechaPublicacion + ", isbn="
				+ isbn + "]";
	}
	

	
}
