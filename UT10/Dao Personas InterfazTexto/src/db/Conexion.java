package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * Representa una conexión a una BD a través de JDBC. La modelamos como una
 * clase con métodos estáticos
 * Sigue el patrón de diseño Singleton
 */
public class Conexion {

	private static final String BD = "bdpersonas";
	private static final String USUARIO = "pepe";
	private static final String PASSWORD = "pepa";

	public static Connection getConexion() throws SQLException {

		return DriverManager.getConnection(
				                    "jdbc:mysql://localhost/" + BD, USUARIO,
				                    PASSWORD);

	}


	public static void closeConexion(Connection con) throws SQLException {

			if (con != null && !con.isClosed()) {
				con.close();
			}

	}

}