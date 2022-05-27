package com.miCasa.zeteam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;



public class Principal {

	public static Scanner teclado = new Scanner(System.in);

	
	public static void main(String[] args) throws VideojuegoException {
		
		//Conectarse con la BD
		try {
			Connection conexion = DriverManager.getConnection(
					//"jdbc:oracle:thin:@//localhost:1521/ORCLCDB.localdomain","videojuegoBD","videojuegoBD"
					"jdbc:oracle:thin:@//localhost:1521/xe","videojuegoBD","videojuegoBD" //para connectarme en casa
					);
			
			//para ver si tiene conexion con la BD
			DatabaseMetaData infoBD= conexion.getMetaData();
			System.out.println("Base de datos: " + infoBD.getDatabaseProductName());
			System.out.println("Version: " + infoBD.getDatabaseProductVersion());
			

			int opc; 
	
			do {
				menu();

				opc = leeInt("Eligue una opcion: ");

				switch (opc) {
				// comprar juego
				case 1: {
					addDatos(conexion);
					break;
				}

				// Devolver juego
				case 2: {				
					delJuego(conexion);
					break;
				}

				// Jugar		
				case 3: {
					updateJuego(conexion);
					break;
				}

				// ver lista de juegos
				case 4: {
					selectVideojuego(conexion);
					break;
				}
				
				// ver juego
				case 5: {
					selectVC(conexion);
					break;
				}

				// salir
				case 6: {
					System.out.println("Programa finalizado.");
					break;
				}
				default:
					System.out.println("Error al elegir una opcion.");
				}
					
			} while (opc != 6);
			
	

			
			//cerramos la conexion con la BD
			conexion.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		

	}

	// ==============================================================================

	// metodo que imprime menu
	public static void menu() {
		System.out.println("\n" 
							+ "1. Comprar juego. \n" 
							+ "2. Devolver juego. \n" 
							+ "3. Jugar. \n"
							+ "4. Ver lista de juegos. \n" 
							+ "5. Ver juego. \n" 
							+ "6. Salir aplicación. \n");
	}

	// metodo que lee enteros
	public static int leeInt(String texto) {
		System.out.print(texto);
		return Integer.parseInt(teclado.nextLine());
	}

	// metodo que lee cadenas
	public static String leeString(String texto) {
		System.out.print(texto);
		return teclado.nextLine();
	}
	
	//metodos que inserta datos a la tabla videojuegos
	public static void addDatos(Connection conexion) throws SQLException, VideojuegoException {
		String nombre, manual,extra;
		double precio;
		String query;
		//pedimos los datos a insertar
		nombre = leeString("Nombre del juego: ");
		precio = leeInt("Precio del juego: ");
		manual = leeString("Tiene manual [si/no]: ");
		extra = leeString("Tiene extras [si/no]: ");
		
		//establecemos la conexion
		Statement instruccion = conexion.createStatement();
		
		//creamos la query o instruccion (donde insertamos los datos a la BD)
		if(manual.equals("no")&& extra.equals("no")) {
			 query = "insert into videojuegos values('"+ nombre + "',"+ 
					precio + ",'" + manual + "','" + extra + "',null)";
		}else {
			Videojuego g = new Goody(nombre, precio, manual, extra);
			precio = g.getPrecio();
			 query = "insert into videojuegos values('"+ nombre + "',"+ 
					precio + ",'" + manual + "','" + extra + "'," + 0 + ")";
		}
		
		
		//mostramos la query generada.
		System.out.println(query);
		
		//mostramos un mensaje de como se ha desarrollado la query.
		if(instruccion.executeUpdate(query)==0) {
			System.out.println("error en la sencentia: " + query);
		}else {
			System.out.println("Registro insertado");
		}
	}
	
	//metodo para borrar un juego.
	public static void delJuego(Connection conexion) throws SQLException{
		
		String nombre_juego = leeString("Indique el nombre: ");
		
		//establecemos la conexion
		Statement instruccion = conexion.createStatement();
		
		//borramos el videojuego
		String query = "delete from videojuegos where nombre like '" + nombre_juego + "'";
		
		//mostramos la query generada.
		System.out.println(query);
		
		//mostramos un mensaje de como se ha desarrollado la query.
		if(instruccion.executeUpdate(query)==0) {
			System.out.println("error en la sencentia: " + query);
		}else {
			System.out.println("Registro Borrado");
		}
	}
	
	//metodo para modificar un juego (horas jugadas).
	public static void updateJuego(Connection conexion) throws SQLException{
		
		String nombre_juego = leeString("Indique el nombre: ");
		double horas_j = leeInt("Indica las horas a jugar: ");
		
		//establecemos la conexion
		Statement instruccion = conexion.createStatement();
		
		//borramos el videojuego
		String query = "update videojuegos set horas = horas + "+ horas_j + 
						" where nombre like '" + nombre_juego + "'";
		
		//mostramos la query generada.
		System.out.println(query);
		
		//mostramos un mensaje de como se ha desarrollado la query.
		if(instruccion.executeUpdate(query)==0) {
			System.out.println("error en la sencentia: " + query);
		}else {
			System.out.println("Registro Modificado");
		}
	}
	
	//metodo que realiza una consulta de todos los videojuegos
	public static void selectVideojuego(Connection conexion) throws SQLException {
		Statement instruccion = conexion.createStatement();
		String sentencia = "select * from videojuegos";
		ResultSet resultado = instruccion.executeQuery(sentencia);
		
		while (resultado.next()) {
			System.out.println("Nombre: " + resultado.getString("nombre"));
			System.out.println("Precio: " + resultado.getString("precio") + "€");
			System.out.println("Manual: " + resultado.getString("manual"));
			System.out.println("Extras: " + resultado.getString("extra"));
			System.out.println("Horas Jugadas: " + resultado.getString("horas") + " h");
			System.out.println("-------------");
		}
	}

	//metodo que realiza una consulta de todos los videojuegos
	public static void selectVC(Connection conexion) throws SQLException {
		String nombre_v = leeString("Inserte el nombre del juego: ");
		Statement instruccion = conexion.createStatement();
		
		String sentencia = "select * from videojuegos where nombre = '" + nombre_v + "'";
	
		ResultSet resultado = instruccion.executeQuery(sentencia);
		resultado.next();
		System.out.println("Nombre: " + resultado.getString("nombre"));
		System.out.println("Precio: " + resultado.getString("precio") + "€");
		System.out.println("Manual: " + resultado.getString("manual"));
		System.out.println("Extras: " + resultado.getString("extra"));
		System.out.println("Horas Jugadas: " + resultado.getString("horas") + " h");
	}
}
