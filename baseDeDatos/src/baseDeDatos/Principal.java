package baseDeDatos;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			Connection conexion = DriverManager.getConnection(
					"jdbc:oracle:thin:@//localhost:1521/ORCLCDB.localdomain","dummy","dummy");
			DatabaseMetaData infoBD= conexion.getMetaData();
			System.out.println("Base de datos: " + infoBD.getDatabaseProductName());
			System.out.println("Version: " + infoBD.getDatabaseProductVersion());
			
			addUser(conexion);
			//consultar(conexion);
			
			conexion.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public static void addUser(Connection conexion) throws SQLException {
		String nombre_dep;
		int numero_dep, presupuesto_dep;
		
		System.out.println("Inserete numero:  ");
		numero_dep = Integer.parseInt(teclado.nextLine());
		System.out.println("Inserte nombre: ");
		nombre_dep = teclado.nextLine();
		System.out.println("Inserte el presupuesto: ");
		presupuesto_dep = Integer.parseInt(teclado.nextLine());
		
		Statement instruccion = conexion.createStatement();
		
		String query = "insert into departamento values(" + numero_dep + ",'" + 
		nombre_dep + "'," + presupuesto_dep + ")";
		
		System.out.println(query);
		
		if(instruccion.executeUpdate(query)==0) {
			System.out.println("error en la sencentia: " + query);
		}else {
			System.out.println("Registro insertado");
		}
	}
	
	public static void consultar(Connection conexion) throws SQLException {
		Statement instruccion = conexion.createStatement();
		String sentencia = "select * from departamento";
		ResultSet resultado = instruccion.executeQuery(sentencia);
		
		while (resultado.next()) {
			System.out.println(resultado.getString("numero_dep"));
			System.out.println(resultado.getString("nombre_dep"));
			System.out.println(resultado.getString("presupuesto_dep"));
			System.out.println("********");
		}
	}

}
