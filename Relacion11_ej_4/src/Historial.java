import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Historial {

	private List<PaginaWeb> listaPaginasWebs;

	//---Constructor
	public Historial() {
		super();
		listaPaginasWebs = new ArrayList<PaginaWeb>();
	}
	
	//---Metodos
	//añade una pagina web al historial de busquedas
	public void addPaginaWeb(String url, LocalDateTime fecha) throws HistorialException {
		PaginaWeb pw;
		for(PaginaWeb p: listaPaginasWebs) {
			if(p.getFecha().isAfter(fecha)) {
				throw new HistorialException("La fecha erronea.");
			}
		}
		
		try {
			pw = new PaginaWeb(url, fecha);
		} catch (PaginaWebException e) {
			System.out.println("mal");
			throw new HistorialException(e.getMessage());
		}
		listaPaginasWebs.add(pw);
	}

	//elimina el historial de busqueda
	public void borrarHistorial() {
		listaPaginasWebs.clear();
	}
	
	//consulta el historial de un dia especifico.
	public String consultarHistorialUnDia(LocalDateTime fecha) {
		PaginaWeb pweb=null;
		boolean encontrado =false;
		StringBuilder resultado = new StringBuilder();
		
		Iterator<PaginaWeb> p = listaPaginasWebs.iterator();
		while(p.hasNext()&& !encontrado) {
			pweb = p.next();
			if(pweb.getFecha().equals(fecha)) {
				encontrado = true;
			}
		}
		if(encontrado) {
			resultado.append(pweb.toString());
		}
		
		return resultado.toString();
		
	}
	
	//---toString
	@Override
	public String toString() {
		if(listaPaginasWebs.isEmpty()) {
			return "El historial esta vacio.";
		}
		return "Historial [listaPaginasWebs=" + listaPaginasWebs + "]";
	}
	
	
	
}
