package Persona;

public class MainPersona {

	public static void main(String[] args) {
		
		/*
		//persona 1
		Persona per1 = new Persona();
		System.out.println(per1.toString());
		
		//persona 2
		Persona per2 = new Persona();
		try {
			per2 = new Persona("Juan",40,"15464644E",'H',83,1.79);
		} catch (PersonaException e2) {
			e2.printStackTrace();
		}
		System.out.println(per2.calcularIMC());
		System.out.println(per2.esMayorDeEdad());
		*/
		
		//persona 3
		Persona per3 = new Persona();
		try {
			per3 = new Persona("Alejandra",31,'M');
			System.out.println(per3);
			per3.setSexo('K');
		} catch (PersonaException e1) {
			int codigo = Integer.parseInt(e1.getMessage().substring(0, 5));
			if (codigo == 1) {
				System.out.println("Error en la edad");
			}else if (codigo == 2) {
				System.out.println("Error en el sexo");
			}
			e1.printStackTrace();
		}
		
	}
}
