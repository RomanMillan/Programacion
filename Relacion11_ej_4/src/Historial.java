import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Historial {

	private List<PaginaWeb> listaPaginasWebs;

	public Historial() {
		super();
		listaPaginasWebs = new ArrayList<PaginaWeb>();
	}
	
	public void addPaginaWeb(String url, LocalDateTime fecha) throws HistorialException {
		PaginaWeb pw;
		try {
			pw = new PaginaWeb(url, fecha);
		} catch (PaginaWebException e) {
			throw new HistorialException(e.getMessage());
		}
		listaPaginasWebs.add(pw);
	}
	
}
