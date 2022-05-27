
package ut10.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase de utilidades con métodos estáticos
 */
public class UtilsConexion {
    private static final String USUARIO = "pepe";
    private static final String PASSWORD = "pepa";


    public static Connection getConexion(String bd) throws SQLException {
        // Obtener conexión a la BD
        return DriverManager.getConnection("jdbc:mysql://localhost/" + bd, USUARIO, PASSWORD);


    }


    public static void closeConexion(Connection conexion) throws SQLException {
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
        }

    }


    public static void closeStatement(Statement statement) throws SQLException {

        if (statement != null) {
            statement.close();
        }


    }


    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            resultSet.close();

        }
    }


    public static void main(String[] args) {
        try {
            UtilsConexion.getConexion("bdusuarios");
            System.out.println("Conexión establecida");
        } catch (SQLException e) {
            System.out.println("Fallo al conectar " + e);
        }
    }
}


