
package ut10.pruebasbd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 * CREATE DEFINER=`root`@`localhost` PROCEDURE `sumarEdades`(in gen varchar(1),
 * out suma integer) BEGIN
 * 
 * set suma = 0; select sum(edad) from personas where genero = gen into suma;
 * 
 * END
 * 
 * CREATE DEFINER=`root`@`localhost` FUNCTION `sumarEdadesFun`(gen varchar(1))
 * RETURNS int(11) DETERMINISTIC
 * BEGIN declare suma integer default 0; select sum(edad) from
 * personas where genero = gen into suma; RETURN suma; END
 * 
 * 
 */
public class EjemploCallableStatement {

	private final static String BD = "bdpersonas";
	private final static String USUARIO = "pepe";
	private final static String PASSWORD = "pepa";

	/**
	 * carga del driver y conexión con la BD
	 */
	public static Connection conectar() throws SQLException {

		// Obtener conexión a la BD
		Connection conexion = DriverManager.getConnection(
				"jdbc:mysql://localhost/" + BD, USUARIO,
				PASSWORD);
		return conexion;

	}


	public static void ejecutarProcedimientoAlmacenado() throws SQLException {

		CallableStatement cst = null;
		Connection conexion = null;
		try {
			conexion = conectar();
			String sql = "{ CALL sumarEdades(?, ?) }";
			cst = conexion.prepareCall(sql);
			cst.setString(1, "h");
			cst.registerOutParameter(2, Types.INTEGER);
			cst.execute();
			int suma = cst.getInt(2);
			System.out.println("Suma edades con procedimiento: " + suma);
		}
		finally {
			cerrarConexion(conexion);
		}

	}

	public static void ejecutarFuncion() throws SQLException {
		Connection conexion = null;
		CallableStatement cst = null;
		try {
			conexion = conectar();
			String sql = "{ ? = CALL sumarEdadesFun(?) }";
			cst = conexion.prepareCall(sql);
			cst.setString(2, "h");
			cst.registerOutParameter(1, Types.INTEGER);
			cst.execute();
			int suma = cst.getInt(1);
			System.out.println("Suma edades con función: " + suma);
		}
		finally {
			cerrarConexion(conexion);
		}

	}

	public static void cerrarConexion(Connection conexion) throws SQLException {
		conexion.close();

	}

	public static void main(String[] args) throws SQLException {

		EjemploCallableStatement.ejecutarProcedimientoAlmacenado();
		System.out.println("------------------");
		EjemploCallableStatement.ejecutarFuncion();

	}

}
