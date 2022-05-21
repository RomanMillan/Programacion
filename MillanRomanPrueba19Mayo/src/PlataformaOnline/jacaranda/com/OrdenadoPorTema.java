package PlataformaOnline.jacaranda.com;

import java.util.Comparator;

public class OrdenadoPorTema implements Comparator<Serie>{

	@Override
	public int compare(Serie o1, Serie o2) {
		return o1.getAnno() - o2.getAnno();
	}

}
