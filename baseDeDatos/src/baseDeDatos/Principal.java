package baseDeDatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class Principal {

	public static void main(String[] args) {
		try {
			Connection conexion = DriverManager.getConnection(
					"jdbc:oracle:thin:@//localhost:1521/ORCLCDB.localdomain","dummy","dummy");
			DatabaseMetaData infoBD= conexion.getMetaData();
			System.out.println("Base de datos: " + infoBD.getDatabaseProductName());
			System.out.println("Version: " + infoBD.getDatabaseProductVersion());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
