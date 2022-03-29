package com.jacaranda.utilities;

import java.util.HashSet;
import java.util.Iterator;
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
		setNombre(nombre);
		setCodigo(codigo);
		listaPueblos = new HashSet<Pueblo>();
	}

	// -----Metodos
	// a�ade pueblos a la lista
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
				throw new ProvinciaException(e.getMessage());
			}
		}
		return anadido;
	}

	// ver si existe el pueblo
	private boolean existePueblo(String nombre) throws ProvinciaException {
		boolean existe = false;
		Pueblo p1;
		if(nombre ==null) {
			throw new ProvinciaException("El nombre no puede ser nulo");
		}
		
		// miramos si el nombre del pueblo esta en la lista de pueblos
		Iterator<Pueblo> p = listaPueblos.iterator();
		while(p.hasNext() && !existe) {
			p1 = p.next();
			if(p1.getNombre().equals(nombre.toUpperCase()))
				existe = true;
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
	
	//borra el pueblo buscado
	public boolean delPueblo(String nombre) {
		boolean borrado = false;
		Pueblo p1=null;
		Iterator<Pueblo> p = listaPueblos.iterator();
		while(p.hasNext()&& !borrado) {
			p1 = p.next();
			if(p1.getNombre().equalsIgnoreCase(nombre)) {
				listaPueblos.remove(p1);
				borrado = true;
			}
		}
		return borrado;
	}
	
	//muestra la informacion del pueblo buscado
		public String getInformacionPueblo(String nombre) {
			Pueblo p1=null;
			boolean encontrado = false;
			if(nombre== null) {
				return null;
			}
			Iterator<Pueblo> p = listaPueblos.iterator();
			while (p.hasNext()&& !encontrado) {
				p1 = p.next();
				if(p1.getNombre().equals(nombre.toUpperCase())) {
					encontrado = true;
				}
			}
			if(encontrado)
				return p1.toString();
			else
				return null;
		}
	
	// -----Getter and Setter
	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public boolean setNumeroHabitantes(String nombre , int numeroHabitantes) throws ProvinciaException {
		boolean cambiado=false;
		for(Pueblo p: listaPueblos) {
			int habitantesAcambiar= p.getNumeroHabitantes() -numeroHabitantes;
			if(p.getNombre().equals(nombre.toUpperCase())) {
				if(p.getNumeroHabitantes()>numeroHabitantes) {
					this.numeroHabitantes -= habitantesAcambiar;
					try {
						p.setNumeroHabitantes(p.getNumeroHabitantes()-habitantesAcambiar);
					} catch (PuebloException e) {
						throw new ProvinciaException(e.getMessage());
					}
					cambiado = true;
				}else if(p.getNumeroHabitantes()<numeroHabitantes) {
					this.numeroHabitantes += habitantesAcambiar;
					try {
						p.setNumeroHabitantes(p.getNumeroHabitantes()+habitantesAcambiar);
					} catch (PuebloException e) {
						throw new ProvinciaException(e.getMessage());
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


	public boolean setSuperficie(String nombre, double superficie) throws ProvinciaException {
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
						throw new ProvinciaException(e.getMessage());
					}
					cambiado = true;	
				}else if(p.getSuperficie()<superficie) {
					this.superficie += superficeAcambiar;
					try {
						p.setSuperficie(p.getSuperficie()+superficeAcambiar);
					} catch (PuebloException e) {
						throw new ProvinciaException(e.getMessage());
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

	private void setNombre(String nombre) throws ProvinciaException {
		if(nombre == null) {
			throw new ProvinciaException("El nombre no puede ser nulo");
		}
		this.nombre = nombre.toUpperCase();
	}
	
	public double getRentaPerCapita() {
		return rentaPerCapita;
	}

	
	
	private void setCodigo(String codigo) throws ProvinciaException {
		if(codigo == null) {
			throw new ProvinciaException("El codigo no puede ser nulo");
		}
		if (codigo.length() < 2 || codigo.length()>=3) {
			throw new ProvinciaException("El codigo tiene que ser de 2 caracteres");
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
