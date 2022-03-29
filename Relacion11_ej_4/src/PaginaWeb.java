import java.time.LocalDateTime;
import java.util.Objects;

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
		setFecha(fecha);
	}

	
	//----Getter and Setter
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) throws PaginaWebException {
		if(url == null || url.isEmpty()) {
			throw new PaginaWebException("La URL no pude estar en blanco o ser nulla");
		}
		this.url = url;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) throws PaginaWebException {
		if(fecha == null) {
			throw new PaginaWebException("La fecha no puede ser nula");
		}
		this.fecha = fecha;
	}

	//hashCode and Equals (URL)
	@Override
	public int hashCode() {
		return Objects.hash(url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaginaWeb other = (PaginaWeb) obj;
		return Objects.equals(url, other.url);
	}

	@Override
	public String toString() {
		return "PaginaWeb [url=" + url + ", fecha=" + fecha + "] \n";
	}
	
	
	
}
