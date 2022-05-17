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
					//"jdbc:oracle:thin:@//localhost:1521/ORCLCDB.localdomain","dummy","dummy"
					"jdbc:oracle:thin:@//localhost:1521/xe","dummy","dummy" //para connectarme en casa
					);
			
			//para ver si tiene conexion con la BD
			DatabaseMetaData infoBD= conexion.getMetaData();
			System.out.println("Base de datos: " + infoBD.getDatabaseProductName());
			System.out.println("Version: " + infoBD.getDatabaseProductVersion());
			
			//llamamos a los metodos
			addUser(conexion);
			consultar(conexion);
			
			//cerramos la conexion con la BD
			conexion.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//metodo que inserta datos a la tabla departamento del esquema dummy
	public static void addUser(Connection conexion) throws SQLException {
		String nombre_dep;
		int numero_dep, presupuesto_dep;
		
		//pedimos los datos a insertar
		System.out.print("Inserete numero:  ");
		numero_dep = Integer.parseInt(teclado.nextLine());
		System.out.print("Inserte nombre: ");
		nombre_dep = teclado.nextLine();
		System.out.print("Inserte el presupuesto: ");
		presupuesto_dep = Integer.parseInt(teclado.nextLine());
		
		//establecemos la conexion
		Statement instruccion = conexion.createStatement();
		
		//creamos la query o instruccion (donde insertamos los datos a la BD)
		String query = "insert into departamento values(" + numero_dep + ",'" + 
		nombre_dep + "'," + presupuesto_dep + ")";
		
		//mostramos la query generada.
		System.out.println(query);
		
		//mostramos un mensaje de como se ha desarrollado la query.
		if(instruccion.executeUpdate(query)==0) {
			System.out.println("error en la sencentia: " + query);
		}else {
			System.out.println("Registro insertado");
		}
	}
	
	//metodo que realiza una consulta de los datos de la tabla departamento del esquema dummy
	public static void consultar(Connection conexion) throws SQLException {
		Statement instruccion = conexion.createStatement();
		String sentencia = "select * from departamento";
		ResultSet resultado = instruccion.executeQuery(sentencia);
		
		while (resultado.next()) {
			System.out.println(resultado.getString("numero_dep"));
			System.out.println(resultado.getString("nombre_dep"));
			System.out.println(resultado.getString("presupuesto_dep"));
			System.out.println("-------------");
		}
	}

}
