package Ej5;

public class MainPartido {

	public static void main(String[] args) throws PartidoException {
		
		Equipo e1 = new Equipo("San tonio", "Alberca","Sevilla");
		Equipo e2 = new Equipo("Murca", "Lorena Ad","Madrid");
		Equipo e3 = new Equipo("Norzzila", "Refenta","Albacete");
		Equipo e4 = new Equipo("Huerta Bolayos", "Los Descampaos","Sevilla");
		Equipo e5 = new Equipo("Real Nada", "Alto Monte","Oviedo");
		Equipo e6 = new Equipo("Equipo 96", "Lope Rando","Valencia");
		
		
		Partido p1;
		Partido p2;
		Partido p3;
		
		boolean partidosCorrectos = false;
		do {
			try {
				p1 = new Partido(1, e1, e2, '1');
				p2 = new Partido(1, e3, e4, '0');
				p3 = new Partido(1, e5, e6, '0');
				
				p1.ponerResultado("2-1");
				p2.ponerResultado("0-0");
				p3.ponerResultado("1-2");
				
				String terminados = "Si";
				boolean terPartdio = false;
				
				if (terminados.equals("Si")) {
					terPartdio = true;
				}
				System.out.println(p1.toString(terPartdio));
				
				partidosCorrectos = true;
			} catch (Exception e) {
				System.out.println("El gran error");
			}
		}while(partidosCorrectos == false);
	
	}
	
}

