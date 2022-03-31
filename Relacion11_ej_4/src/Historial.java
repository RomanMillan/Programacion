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
	//a�ade una pagina web al historial de busquedas
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
		StringBuilder resultado = new StringBuilder();
		boolean salir = false;
		
		//buscamos la pagina web
		Iterator<PaginaWeb> p = listaPaginasWebs.iterator();
		while(p.hasNext()&& !salir) {
			pweb = p.next();
			
			if(pweb.getFecha().isAfter(fecha)) {
				salir = true;
			}
			
			if(pweb.getFecha().equals(fecha)) {
				resultado.append(pweb.toString()+"\n");
			}
		}
		//si ha sido encontrada se muestra la informacion
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
