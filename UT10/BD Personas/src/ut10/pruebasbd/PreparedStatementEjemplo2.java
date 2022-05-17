
package ut10.pruebasbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementEjemplo2 {

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

    /**
     * actualizar las personas con un apellido determinado a un ecivil determinado
     */
    public static void ejecutarConsultaActualizacion() {

        try (Connection conexion = conectar();
             PreparedStatement pst = conexion.prepareStatement("UPDATE personas SET eCivil = ? WHERE apellido = ?");) {
            pst.setString(1, "s");
            pst.setString(2, "Redrado");
            pst.executeUpdate();


        } catch (SQLException e) {
            System.out.println("Error al conectar " + e);
        }


    }


    public static void cerrarConexion(Connection conexion) throws SQLException {
        conexion.close();


    }


    public static void main(String[] args) {
        PreparedStatementEjemplo2.ejecutarConsultaActualizacion();


    }

}
