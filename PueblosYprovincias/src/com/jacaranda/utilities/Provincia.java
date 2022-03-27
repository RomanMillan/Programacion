package com.jacaranda.utilities;

import java.util.HashSet;
import java.util.Set;

public class Provincia {

	private String nombre;
	private String codigo;
	private int numeroHabitantes;
	private double rentaPerCapita;
	private double superficie;
	private Set<Pueblo> listaPueblos = new HashSet<Pueblo>();

	// -----Constructor
	public Provincia(String nombre, String codigo) throws ProvinciaException {
		super();
		this.nombre = nombre.toUpperCase();
		setCodigo(codigo);
		listaPueblos = new HashSet<Pueblo>();
	}

	// -----Metodos
	// añade pueblos a la lista
	public boolean addPueblo(String nombre, String codigo, int numHabitantes, double rentaPerCapita, double superficie)
			throws ProvinciaException, PuebloException {
		boolean anadido = false;
		Pueblo p1;

		// ..comprobamos si el nombre del pueblo es nulo
		if (nombre == null || nombre.isEmpty()) {
			throw new ProvinciaException("El nombre no puede estar vacio");
		}

		// ..comprobamos si el pueblo ya esta insertado
		if (existePueblo(nombre)) {
			throw new ProvinciaException("El pueblo ya existe");
		} else {
			try {
				p1 = new Pueblo(nombre, this.codigo + codigo, numHabitantes, rentaPerCapita, superficie);
				listaPueblos.add(p1);
				this.numeroHabitantes += numHabitantes;
				this.rentaPerCapita += rentaPerCapita;
				this.superficie += superficie;
				anadido = true;
			} catch (PuebloException e) {
				System.out.println(e.getMessage());
			}
		}
		return anadido;
	}

	// ver si existe el pueblo
	private boolean existePueblo(String nombre) {
		boolean existe = false;
		String nombreAmirar = nombre.toUpperCase();

		// miramos si el nombre del pueblo esta en la lista de pueblos
		for (Pueblo p : listaPueblos) {
			if (p.getNombre().equals(nombreAmirar)) {
				existe = true;
			}
		}
		return existe;
	}

	// muestra el listado de pueblos que tiene la provincia
	public String listadoPueblos() {
		return listaPueblos.toString();
	}

	// muestra el numero de pueblos que tiene la provincia
	public int numPueblos() {
		return listaPueblos.size();
	}

	//mostrar el listado de nombres de los pueblos de la provincia
	public String listadoNombresPueblos() {
		StringBuilder nombresPueblos = new StringBuilder();
		for(Pueblo p: listaPueblos) {
		 nombresPueblos.append(p.getNombre()+"\n");
		}
		return nombresPueblos.toString();
	}
	
	public boolean delPueblo(String nombre) {
		boolean borrado = false;
		Pueblo p1=null;
		for(Pueblo p: listaPueblos) {
			if(p.getNombre().equals(nombre.toUpperCase())) {
				p1 = p;
			}
		}
		
		if(listaPueblos.remove(p1)) {
			borrado = true;
		}
		return borrado;
	}
	
	// -----Getter and Setter
	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public boolean setNumeroHabitantes(String nombre , int numeroHabitantes) {
		boolean cambiado=false;
		for(Pueblo p: listaPueblos) {
			int habitantesAcambiar= p.getNumeroHabitantes() -numeroHabitantes;
			if(p.getNombre().equals(nombre.toUpperCase())) {
				if(p.getNumeroHabitantes()>numeroHabitantes) {
					this.numeroHabitantes -= habitantesAcambiar;
					try {
						p.setNumeroHabitantes(p.getNumeroHabitantes()-habitantesAcambiar);
					} catch (PuebloException e) {
						System.out.println(e.getMessage());
					}
					cambiado = true;
				}else if(p.getNumeroHabitantes()<numeroHabitantes) {
					this.numeroHabitantes += habitantesAcambiar;
					try {
						p.setNumeroHabitantes(p.getNumeroHabitantes()+habitantesAcambiar);
					} catch (PuebloException e) {
						System.out.println(e.getMessage());
					}
					cambiado = true;
				}
			}
		}
		return cambiado;
	}

	public double getSuperficie() {
		return superficie;
	}


	public boolean setSuperficie(String nombre, double superficie) {
		boolean cambiado= false;
		for(Pueblo p: listaPueblos) {
			if(p.getNombre().equals(nombre.toUpperCase())) {
				//miramos si la superficie es mayor a la insertada
				double superficeAcambiar = p.getSuperficie() - superficie;
				if(p.getSuperficie()>superficie) {
					this.superficie -= superficeAcambiar;
					try {
						p.setSuperficie(p.getSuperficie()-superficeAcambiar);
					} catch (PuebloException e) {
						System.out.println(e.getMessage());
					}
					cambiado = true;	
				}else if(p.getSuperficie()<superficie) {
					this.superficie += superficeAcambiar;
					try {
						p.setSuperficie(p.getSuperficie()+superficeAcambiar);
					} catch (PuebloException e) {
						System.out.println(e.getMessage());
					}
					cambiado = true;
				}
			}
		}	
		return cambiado;
	}

	public String getProvincia() {
		return nombre;
	}

	public double getRentaPerCapita() {
		return rentaPerCapita;
	}

	private void setCodigo(String codigo) throws ProvinciaException {
		if (codigo.length() < 2) {
			throw new ProvinciaException("El codigo tiene que tener almenos 2 caracteres");
		} else {
			for (int i = 0; i < codigo.length() - 1; i++) {
				if (codigo.charAt(i) < 48 || codigo.charAt(i) > 57) {
					throw new ProvinciaException("El codigo tiene que ser numerico");
				}
			}
		}
		this.codigo = codigo;
	}

	// -----toString
	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre + ", codigo=" + codigo + ", " + "numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + "\n, listaPueblos="
				+ listaPueblos + "]\n";
	}

}
