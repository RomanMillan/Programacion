import java.time.LocalDateTime;

public class PaginaWeb {

	private String url;
	private LocalDateTime fecha;
		
	
	//----Constructores
	public PaginaWeb(String url) throws PaginaWebException {
		super();
		setUrl(url);
		fecha = LocalDateTime.now();
	}

	public PaginaWeb(String url, LocalDateTime fecha) throws PaginaWebException {
		super();
		setUrl(url);
		this.fecha = fecha;
	}

	
	//----Getter and Setter
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) throws PaginaWebException {
		if(url == null || url.isEmpty()) {
			throw new PaginaWebException("La URL no pude estár en blanco o ser nulla");
		}
		this.url = url;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
}
