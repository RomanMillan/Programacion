package notasAlumnos;

public class Principal {

	public static void main(String[] args) {
		Alumno a1 = new Alumno("12548K");
		a1.setNotaPrimerTrimestre(10);
		a1.setNotaSegundoTrimestre(9);
		a1.setNombre("Juan");
		a1.setApellidos("Kase");
		System.out.println(a1.toString());
		
		System.out.println(a1.obtenerFinal());
	}
}
