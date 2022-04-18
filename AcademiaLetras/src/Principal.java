import java.util.HashMap;

public class Principal {

	public static void main(String[] args) {
		HashMap<Character, Academico> lista = new HashMap<>();
		
		lista.put('A', new Academico("In", 1988, "Poner Almondiga"));
		lista.put('L', new Academico("Lucioa", 1988, "oficio 2"));
		lista.put('B', new Academico("Bartolo", 1988, "oficio 3"));
		
		
		System.out.println(lista);
	}

}
